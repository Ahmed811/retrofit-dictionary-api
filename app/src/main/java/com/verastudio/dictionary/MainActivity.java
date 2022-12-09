package com.verastudio.dictionary;
//https://api.dictionaryapi.dev/api/v2/entries/en
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.verastudio.dictionary.Adapters.MeaningAdapter;
import com.verastudio.dictionary.Adapters.PhoneticsAdapter;
import com.verastudio.dictionary.Models.ApiResponseModel;
import com.verastudio.dictionary.Network.OnFetchDataListener;
import com.verastudio.dictionary.Network.RequestManager;
import com.verastudio.dictionary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ProgressDialog progressDialog;
PhoneticsAdapter phoneticsAdapter;
MeaningAdapter meaningAdapter;
    RequestManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog=new ProgressDialog(this);
        showDataOnFirstTime("Book");

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching data for: "+query);
                progressDialog.show();
                 manager=new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

private final OnFetchDataListener listener=new OnFetchDataListener() {
        @Override
        public void onFetchData(ApiResponseModel apiResponseModel, String message) {
        progressDialog.dismiss();
        if(apiResponseModel==null){
            Toast.makeText(MainActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
        }else {
            showData(apiResponseModel);
        }

        }

        @Override
        public void onError(String message) {
        progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            ProgressDialog networkFailerProgress=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Please Check Your Internet Connection!");
            progressDialog.show();
        }
    };

    private void showDataOnFirstTime(String word){
        progressDialog.setTitle("Loading...");
        progressDialog.show();
         manager=new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener,word);
    }
    private void showData(ApiResponseModel apiResponseModel) {

        binding.txtWord.setText("Word: "+apiResponseModel.getWord());
        binding.recyclerPhonetics.setHasFixedSize(true);
        binding.recyclerPhonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter=new PhoneticsAdapter(this,apiResponseModel.getPhonetics());
        binding.recyclerPhonetics.setAdapter(phoneticsAdapter);
        meaningAdapter=new MeaningAdapter(this,apiResponseModel.getMeanings());
        binding.recyclerMeanings.setHasFixedSize(true);
        binding.recyclerMeanings.setLayoutManager(new GridLayoutManager(this,1));
        binding.recyclerMeanings.setAdapter(meaningAdapter);
    }
}