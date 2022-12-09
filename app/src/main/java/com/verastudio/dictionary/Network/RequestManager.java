package com.verastudio.dictionary.Network;

import android.content.Context;
import android.widget.Toast;

import com.verastudio.dictionary.Models.ApiResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    Context context;

    public RequestManager(Context context) {
        this.context = context;

    }

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public  void getWordMeaning(OnFetchDataListener listener,String word){
     CallDictionary callDictionary=retrofit.create(CallDictionary.class);
        Call<List<ApiResponseModel>>call=callDictionary.callMeaning(word);
        try {
            call.enqueue(new Callback<List<ApiResponseModel>>() {
                @Override
                public void onResponse(Call<List<ApiResponseModel>> call, Response<List<ApiResponseModel>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0),response.message());

                }

                @Override
                public void onFailure(Call<List<ApiResponseModel>> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        }catch (Exception e){
            Toast.makeText(context, "An Error Occurred", Toast.LENGTH_SHORT).show();
        }
    }
}
