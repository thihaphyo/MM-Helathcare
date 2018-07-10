package com.padc.mmhelathcare.network

import com.padc.mmhelathcare.network.responses.GetHealthCareResponse
import com.padc.mmhelathcare.utils.AppConstants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
interface MMHealthCareApi {

    @FormUrlEncoded
    @POST(AppConstants.API_GET_HEALTHCARE_INFO)
    fun loadHealthCareInfo(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) accessToken: String
    ): Call<GetHealthCareResponse>
}