package com.verastudio.dictionary.Network;

import com.verastudio.dictionary.Models.ApiResponseModel;

public interface OnFetchDataListener {
    void onFetchData(ApiResponseModel apiResponseModel,String message);
    void onError(String message);
}
