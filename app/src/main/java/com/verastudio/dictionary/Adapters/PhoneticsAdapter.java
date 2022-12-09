package com.verastudio.dictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verastudio.dictionary.Models.PhoneticModel;
import com.verastudio.dictionary.ViewHolders.PhoneticViewHolder;
import com.verastudio.dictionary.databinding.PhoneticRowItemBinding;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    PhoneticRowItemBinding binding;
    public PhoneticsAdapter(Context context, List<PhoneticModel> phonetics) {
        this.context = context;
        this.phonetics = phonetics;
    }

    private List<PhoneticModel>phonetics;
    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=PhoneticRowItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new PhoneticViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
        holder.binding.txtPhonetic.setText(phonetics.get(position).getText());
        holder.binding.imgButtonPlayAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player=new MediaPlayer();
                try {
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(context,Uri.parse(phonetics.get(position).getAudio()));
                    player.prepare();
                    player.start();
                }catch (Exception e){
               e.printStackTrace();
                    Toast.makeText(context, "Cannot play Audio", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return phonetics.size();
    }
}
