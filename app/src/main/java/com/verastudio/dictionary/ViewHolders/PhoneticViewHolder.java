package com.verastudio.dictionary.ViewHolders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verastudio.dictionary.databinding.PhoneticRowItemBinding;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
public PhoneticRowItemBinding binding;
    public PhoneticViewHolder(@NonNull PhoneticRowItemBinding binding) {
        super(binding.getRoot());
       this.binding=binding;

    }
}
