package com.padc.mmhelathcare.data.models

import com.padc.mmhelathcare.network.MMHealthCareDataAgent
import com.padc.mmhelathcare.network.RetrofitDataAgentImpl

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

    private constructor() {

        mDataAgent = RetrofitDataAgentImpl.getObjectReference()
    }

    fun loadHealthCareInfo() {

        mDataAgent!!.loadHealthCareInfo(ACCESS_TOKEN)
    }


}