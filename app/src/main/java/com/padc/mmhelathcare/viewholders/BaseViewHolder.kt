package com.padc.mmhelathcare.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
abstract class BaseViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView)
        , View.OnClickListener {

    protected var mData: W? = null

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun bindData(data: W)
}