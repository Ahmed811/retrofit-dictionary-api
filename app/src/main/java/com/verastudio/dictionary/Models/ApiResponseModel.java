package com.verastudio.dictionary.Models;

import java.util.List;

public class ApiResponseModel {
    String word="";

    List<PhoneticModel>phonetics=null;
    List<MeaningModel> meanings=null;
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<PhoneticModel> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<PhoneticModel> phonetics) {
        this.phonetics = phonetics;
    }

    public List<MeaningModel> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<MeaningModel> meanings) {
        this.meanings = meanings;
    }


}
