package com.padc.mmhelathcare.data.models

import com.padc.mmhelathcare.data.vos.HealthCareInfoVO
import com.padc.mmhelathcare.events.SuccessGetHealthCareEvent
import com.padc.mmhelathcare.network.MMHealthCareDataAgent
import com.padc.mmhelathcare.network.RetrofitDataAgentImpl
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
class MMHealthModel {

    companion object {

        private var objectReference: MMHealthModel? = null

        private val ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"

        private var mDataAgent: MMHealthCareDataAgent? = null

        fun getObjectReference(): MMHealthModel? {

            if (objectReference == null) {
                objectReference = MMHealthModel()
            }
            return objectReference
        }

    }

    private var mDataRepo: HashMap<Int, HealthCareInfoVO> = HashMap()

    private constructor() {

        mDataAgent = RetrofitDataAgentImpl.getObjectReference()
        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetHealthInfo(event: SuccessGetHealthCareEvent) {
        setHealthInfoDataRepo(event.healthCareList)
    }

    fun setHealthInfoDataRepo(mHealthList: List<HealthCareInfoVO>) {

        for (healthCare: HealthCareInfoVO in mHealthList) {
            mDataRepo[healthCare.id] = healthCare
        }
    }

    fun getHealthInfoById(id: Int): HealthCareInfoVO? {

        return mDataRepo[id]
    }

    fun loadHealthCareInfo() {

        mDataAgent!!.loadHealthCareInfo(ACCESS_TOKEN)
    }


}