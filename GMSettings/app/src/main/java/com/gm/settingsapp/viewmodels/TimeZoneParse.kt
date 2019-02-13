package com.gm.settingsapp.viewmodels

import android.content.Context
import android.content.res.XmlResourceParser
import android.os.AsyncTask
import android.text.BidiFormatter
import android.text.TextDirectionHeuristics
import android.text.TextUtils
import android.view.View
import com.gm.settingsservice.models.GmTimeZone
import com.gm.settingsservice.utils.Log
import org.xmlpull.v1.XmlPullParserException
import java.text.SimpleDateFormat
import java.util.*
import com.gm.settingsapp.R
object TimeZoneParse {

    public val sTimeZoneList = HashMap<String, String>()
    private val XMLTAG_TIMEZONE = "timezone"


    /**
     * Invoke background time zone list parser.  Time zone list comes from resources and is language-dependent.
     * @param ctx current activity context
     */
    fun parseTimeZoneList(ctx: Context?) {
        if (null == ctx) {
            throw IllegalArgumentException("Context null")
        }

        XmlParseAsyncTask(ctx).execute()
    }

    /**
     * To perform xml parsing in background
     * @param context curret activity context
     *
     */
    class XmlParseAsyncTask(context: Context): AsyncTask<Void, Void, Void>() {

       var mcontext : Context = context
        protected override fun doInBackground(vararg arg0: Void): Void? {
            val newList = parseFile(mcontext)

            synchronized(sTimeZoneList) {
                sTimeZoneList.clear()
                sTimeZoneList.putAll(newList)

            android.util.Log.d("TZC", "Parsing completed")
            return null
        }

    }}

    /**
     * Parsing xml file which contains total time zones
     * @param context current activity context
     * @return Time zones
     */
    private fun parseFile(context: Context): HashMap<String, String> {
        val result = HashMap<String, String>()
        try {
            val xrp = context.resources.getXml(R.xml.timezones)
            while (xrp.next() != XmlResourceParser.START_TAG) {
            }
            xrp.next()
            while (xrp.eventType != XmlResourceParser.END_TAG) {
                while (xrp.eventType != XmlResourceParser.START_TAG) {
                    if (xrp.eventType == XmlResourceParser.END_DOCUMENT) {
                        return result
                    }
                    xrp.next()
                }
                if (xrp.name == XMLTAG_TIMEZONE) {
                    val id = xrp.getAttributeValue(0)
                    val displayName = xrp.nextText()
                    Log.d(XMLTAG_TIMEZONE, " timeZoneList id  $id")
                    result[id] = displayName
                }
                while (xrp.eventType != XmlResourceParser.END_TAG) {
                    xrp.next()
                }
                xrp.next()
            }
            xrp.close()
        } catch (xppe: XmlPullParserException) {
            Log.d(XMLTAG_TIMEZONE, "Ill-formatted timezones.xml file")
        } catch (ioe: java.io.IOException) {
            Log.d(XMLTAG_TIMEZONE, "Unable to read timezones.xml file")
        }

        return result
    }

    /**
     *  preparing time zone format
     *  @param date time in millis
     *  @param tz timezone
     *  @return String
     */
    private fun tzOffsetAsString(date: Long, tz: TimeZone): String {
        val locale = Locale.getDefault()
        // Use SimpleDateFormat to format the GMT+00:00 string.
        val gmtFormatter = SimpleDateFormat("ZZZZ", locale)
        gmtFormatter.timeZone = tz
        var result = gmtFormatter.format(date)

        // Ensure that the "GMT+" stays with the "00:00" even if the digits are RTL.
        val bidiFormatter = BidiFormatter.getInstance()
        val isRtl = TextUtils.getLayoutDirectionFromLocale(locale) == View.LAYOUT_DIRECTION_RTL
        result = bidiFormatter.unicodeWrap(result,
                if (isRtl) TextDirectionHeuristics.RTL else TextDirectionHeuristics.LTR)
        return result
    }

    /**
     * Get one time zone by Id (e.g. "America/Toronto").  Returns null if Id provided is unknown.
     */
    fun getTimeZone(tzId: String): GmTimeZone? {
        var displayName: String? = null
        synchronized(sTimeZoneList) {
            displayName = sTimeZoneList[tzId]
        }
        return if (displayName != null) makeItem(tzId, displayName!!, System.currentTimeMillis()) else null
    }

    /**
     * Preparing Timezones to display in specific format
     * @param id
     * @param displayName zone name
     * @param date current time in millis
     */
    private fun makeItem(id: String, displayName: String, date: Long): GmTimeZone? {
        val tz = TimeZone.getTimeZone(id)
        val abbr = tz.getDisplayName(tz.inDaylightTime(Date(date)), TimeZone.SHORT)
        if ("GMT" == abbr && "Europe/London" != id) {
            return null  // per API description: GMT zone is returned if Id is not found
        }

        var tzName = if (TextUtils.isEmpty(displayName))
            id.substring(id.indexOf('/') + 1).replace('_', ' ')  // fallback if name is not provided
        else
            displayName

        // Language-independent, unknown abbreviations are replaced with "GMT+xx:yy" or "GMT-xx:yy"
        if (abbr.length <= 3 || !abbr.startsWith("GMT")) {
            tzName = "$tzName ($abbr)"
        }

        val displayOffset = tzOffsetAsString(date, tz)
        val offset = tz.getOffset(date)

        return GmTimeZone(id, tzName, displayOffset, offset)
    }

}
