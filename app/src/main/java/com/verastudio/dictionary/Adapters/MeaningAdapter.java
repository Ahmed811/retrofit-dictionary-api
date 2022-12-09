package com.verastudio.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.verastudio.dictionary.Models.MeaningModel;
import com.verastudio.dictionary.ViewHolders.MeaningViewHolder;
import com.verastudio.dictionary.databinding.MeaningListItemBinding;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {
    Context context;
    MeaningListItemBinding binding;
    List<MeaningModel> meaningList;

    public MeaningAdapter(Context context, List<MeaningModel> meaningModels) {
        this.context = context;
        this.meaningList = meaningModels;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=MeaningListItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new  MeaningViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
      holder.binding.txtPartOfSpeech.setText("Parts of Speech "+ meaningList.get(position).getPartOfSpeech());
      holder.binding.recyclerviewDefinition.setHasFixedSize(true);
      holder.binding.recyclerviewDefinition.setLayoutManager(new GridLayoutManager(context,1));
      DefinitionAdapter definitionAdapter=new DefinitionAdapter(context,meaningList.get(position).getDefinitionsModels());
      holder.binding.recyclerviewDefinition.setAdapter(definitionAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningList.size();
    }
}
