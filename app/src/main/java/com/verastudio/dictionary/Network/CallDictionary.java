package com.verastudio.dictionary.Network;

import com.verastudio.dictionary.Models.ApiResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CallDictionary {

    @GET("entries/en/{word}")
    Call<List<ApiResponseModel>>callMeaning(@Path("word") String word);

}
