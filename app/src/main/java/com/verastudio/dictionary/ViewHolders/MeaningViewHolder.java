package com.verastudio.dictionary.ViewHolders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verastudio.dictionary.databinding.MeaningListItemBinding;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
   public MeaningListItemBinding binding;
    public MeaningViewHolder(@NonNull  MeaningListItemBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}
