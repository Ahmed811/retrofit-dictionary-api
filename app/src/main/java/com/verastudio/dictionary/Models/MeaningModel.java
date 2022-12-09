package com.verastudio.dictionary.Models;

import java.util.ArrayList;
import java.util.List;

public class MeaningModel {
    String partOfSpeech="";

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<DefinitionsModel> getDefinitionsModels() {
        return definitions;
    }

    public void setDefinitionsModels(List<DefinitionsModel> definitionsModels) {
        this.definitions = definitionsModels;
    }

    List<DefinitionsModel>definitions=null;
}
