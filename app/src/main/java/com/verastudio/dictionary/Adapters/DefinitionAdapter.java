package com.verastudio.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verastudio.dictionary.Models.DefinitionsModel;
import com.verastudio.dictionary.ViewHolders.DefinitionViewHolder;
import com.verastudio.dictionary.databinding.DefinitionListItemBinding;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    Context context;
    List<DefinitionsModel> definitionsList;

    public DefinitionAdapter(Context context, List<DefinitionsModel> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }
  DefinitionListItemBinding binding;
    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=DefinitionListItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new DefinitionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
    holder.binding.txtDefinition.setText(definitionsList.get(position).getDefinition());
    holder.binding.txtExample.setText("Example: "+definitionsList.get(position).getExample());
    StringBuilder antonyms=new StringBuilder();
    StringBuilder synonyms=new StringBuilder();
    antonyms.append(definitionsList.get(position).getAntonyms());
        synonyms.append(definitionsList.get(position).getSynonyms());
    holder.binding.txtAntonyms.setText(antonyms);
    holder.binding.txtSynonyms.setText(synonyms);
    holder.binding.txtSynonyms.setSelected(true);
    holder.binding.txtAntonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
