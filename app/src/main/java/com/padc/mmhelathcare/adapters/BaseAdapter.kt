package com.padc.mmhelathcare.adapters

import android.support.v7.widget.RecyclerView
import com.padc.mmhelathcare.viewholders.BaseViewHolder

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
abstract class BaseAdapter<VH, W> : RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var mList: List<W>? = null

    init {
        mList = ArrayList()
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {

        holder.bindData(mList!![position])

    }

    /**
     * for setting data to ArrayList and reload Recycler View
     */
    fun setHealthCareInfoList(healthCareList: List<W>) {

        mList = healthCareList
        notifyDataSetChanged()
    }
}