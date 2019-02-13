package com.gm.settingsapp.ui.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import com.gm.settingsapp.BR
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.models.ESettingsLanguageType

/**
 * Assigning RecyclerViewAdapter to RecyclerView to display list
 */

class RecyclerViewAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    private var mInflater: LayoutInflater? = null
    private var mListObjects: ObservableArrayList<*>? = null
    private var mListOfObjects: ObservableField<ArrayList<ESettingsLanguageType>>? = null
    private var mChildLayoutId: Int = 0
    lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit var eventHandler: EventHandler
    lateinit var bindingComponent: BinderDataBindingComponent
    lateinit var dataPoolDataHandler: DataPoolDataHandler

    constructor(items: ObservableArrayList<*>, childlayout: Int, eventHandler: EventHandler, binderDataBindingComponent: BinderDataBindingComponent, dataPoolDataHandler: DataPoolDataHandler) : this() {
        this.mListObjects = items
        this.mChildLayoutId = childlayout
        this.eventHandler = eventHandler
        this.bindingComponent = binderDataBindingComponent
        this.dataPoolDataHandler = dataPoolDataHandler
    }

    // below constructor used for languages list
    constructor(items: ObservableField<ArrayList<ESettingsLanguageType>>, childlayout: Int, eventHandler: EventHandler, binderDataBindingComponent: BinderDataBindingComponent, dataPoolDataHandler: DataPoolDataHandler) : this() {
        this.mListOfObjects = items
        this.mChildLayoutId = childlayout
        this.eventHandler = eventHandler
        this.bindingComponent = binderDataBindingComponent
        this.dataPoolDataHandler = dataPoolDataHandler
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    inner class RecyclerViewHolder(// each data item is just a string in this case
            private val binding: ViewDataBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any, position: Int) {
            binding.setVariable(BR.obj, item)
            binding.setVariable(BR.clickHandler, eventHandler)
            binding.setVariable(BR.position, position)
            binding.setVariable(BR.dataPoolHandler, dataPoolDataHandler)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.RecyclerViewHolder {

        if (mInflater == null) {
            mInflater = parent.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        val binding = DataBindingUtil.inflate<ViewDataBinding>(mInflater!!, mChildLayoutId, parent, false,bindingComponent)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.RecyclerViewHolder, position: Int) {
        if (mListObjects != null && mListObjects!![position]!=0) {
            val item = mListObjects!![position]
            holder.bind(item!!, position)
        }

        if (mListOfObjects != null) {
            val item = mListOfObjects!!.get()!![position]
            holder.bind(item, position)
        }

    }

    override fun getItemCount(): Int {
        var size: Int = 0;
        if (mListObjects != null) {
            size = mListObjects!!.size
        }
        if (mListOfObjects != null) {
            size = mListOfObjects!!.get()!!.size
        }
        return size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * To update view when list changes
     *
     **/
    fun updateItems(mList: ObservableArrayList<*>?) {
        mListObjects = mList!!
        notifyDataSetChanged()
    }

}