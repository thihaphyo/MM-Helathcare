package com.padc.mmhelathcare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padc.mmhelathcare.R
import com.padc.mmhelathcare.data.vos.HealthCareInfoVO
import com.padc.mmhelathcare.viewholders.BaseViewHolder
import com.padc.mmhelathcare.viewholders.HealthCareInfoViewHolder

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
class HealthCareInfoAdapter : BaseAdapter<HealthCareInfoViewHolder,HealthCareInfoVO>() {

    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthCareInfoVO> {

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.view_holder_health_info, parent, false)
        return HealthCareInfoViewHolder(view)
    }


}