package com.padc.mmhelathcare.viewholders

import android.view.View
import com.padc.mmhelathcare.R
import com.padc.mmhelathcare.data.vos.HealthCareInfoVO
import com.padc.mmhelathcare.utils.GlideApp
import kotlinx.android.synthetic.main.view_holder_health_info.view.*

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
class HealthCareInfoViewHolder(itemView: View) :
        BaseViewHolder<HealthCareInfoVO>(itemView) {

    override fun bindData(data: HealthCareInfoVO) {

        mData = data
        itemView.tv_health_info_heading.text = mData!!.title
        itemView.tv_type.text = if (mData!!.infoType != "") {
            mData!!.infoType
        } else {
            "Other"
        }
        itemView.tv_publisher.text = mData!!.author!!.authorName

        GlideApp.with(itemView.iv_health_care_hero)
                .load(mData!!.image)
                .placeholder(R.drawable.ic_placeholder)
                .centerCrop()
                .into(itemView.iv_health_care_hero)

        GlideApp.with(itemView.iv_share)
                .load(mData!!.author!!.authorPhoto)
                .placeholder(R.drawable.ic_placeholder)
                .centerCrop()
                .into(itemView.iv_share)


    }

    override fun onClick(v: View?) {

    }


}