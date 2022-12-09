package com.verastudio.dictionary.ViewHolders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verastudio.dictionary.databinding.DefinitionListItemBinding;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
    public DefinitionListItemBinding binding;
    public DefinitionViewHolder(@NonNull  DefinitionListItemBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}
