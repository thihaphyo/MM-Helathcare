package com.padc.mmhelathcare.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.mmhelathcare.data.vos.HealthCareInfoVO

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
class GetHealthCareResponse {
    @SerializedName("code")
    val code: Int = 0
    @SerializedName("message")
    val message: String = ""
    @SerializedName("healthcare-info")
    val healthCareInoList: List<HealthCareInfoVO>? = null

    fun isResponseOK():Boolean{

        return code == 200 && healthCareInoList !=null

    }
}