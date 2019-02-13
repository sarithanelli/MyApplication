package com.gm.settingsapp.ui.activities

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.Toast
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.HTMLViewerActivityBinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.ics_page_htmlviewer.*
import java.io.File
import java.io.IOException
import java.net.URI
import java.util.zip.GZIPInputStream

/*
 * This activity launch OpenSourceResource Screen
 */
class HTMLViewerActivity : BaseActivity() {
    val binding: HTMLViewerActivityBinding? = null
    private val TAG = "HTMLViewer"

    private lateinit var mWebView: WebView
    private var mLoading: View? = null
    var title: String = ""

    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_page_htmlviewer) as HTMLViewerActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        /*
        * condition for checking simmulation and sdk manager
        * */

            initWebView()


    }

    /*
   * This method use to initialize the web view
   * */
    fun initWebView() {
        // mWebView = findViewById(R.id.webview) as WebView
        mWebView = webview
        // mLoading = findViewById(R.id.loading)
        mLoading = loading
        mWebView.setWebChromeClient(ChromeClient())
        mWebView.setWebViewClient(ViewClient())
        val s = mWebView.settings
        s.setUseWideViewPort(true)
        s.setSupportZoom(true)
        s.setBuiltInZoomControls(true)
        s.setDisplayZoomControls(false)
        /*s.setSavePassword(false)
        s.setSaveFormData(false)*/
        s.setBlockNetworkLoads(true)
        // Javascript is purposely disabled, so that nothing can be
        // automatically run.
        s.setJavaScriptEnabled(false)
        s.setDefaultTextEncodingName("utf-8")
//        val intent = getIntent()

        if (dataPoolDataHandler.HTML_INTENT_VIEW_PATH_DATA.get()!!) {
            val intent = dataPoolDataHandler.HTML_INTENT_VIEW.get()
            if (intent!!.hasExtra(Intent.EXTRA_TITLE)) {
                title = intent.getStringExtra(Intent.EXTRA_TITLE)
            }
            mWebView.loadUrl((intent.getData()).toString())
        }else{
            mLoading!!.setVisibility(View.GONE)
            val imageUri = Uri.fromFile(File("//android_asset/NOTICE.html"))

            mWebView.loadUrl(URI(imageUri.toString()).toString())
        }

    }

    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(resources.getString(R.string.updater_open_source_software))
    }

    override fun onDestroy() {
        super.onDestroy()
        // mWebView.destroy()
    }

    private inner class ChromeClient : WebChromeClient() {
        override fun onReceivedTitle(view: WebView, title: String) {
            if (!getIntent().hasExtra(Intent.EXTRA_TITLE)) {
                this@HTMLViewerActivity.setTitle(title)
            }
        }
    }

    private inner class ViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView, url: String) {
            mLoading!!.setVisibility(View.GONE)
        }

        override fun shouldInterceptRequest(view: WebView,
                                            request: WebResourceRequest): WebResourceResponse? {
            val uri = request.url
            if (ContentResolver.SCHEME_FILE == uri.scheme && uri.path!!.endsWith(".gz")) {
                Log.d(TAG, "Trying to decompress $uri on the fly")
                try {
                    val `in` = GZIPInputStream(
                            getContentResolver().openInputStream(uri)!!)
                    val resp = WebResourceResponse(
                            getIntent().getType(), "utf-8", `in`)
                    resp.setStatusCodeAndReasonPhrase(200, "OK")
                    return resp
                } catch (e: IOException) {
                    Log.w(TAG, "Failed to decompress; falling back", e)
                }

            }
            return null
        }
    }
}