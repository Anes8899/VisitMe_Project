package kh.edu.rupp.ite.visitme.Adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.visitme.Model.Place;
import kh.edu.rupp.ite.visitme.databinding.ViewHolderPlaceBinding;

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    private final ViewHolderPlaceBinding binding;

    public PlaceViewHolder(ViewHolderPlaceBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }


    public void bind(Place place){
        Picasso.get().load(place.getImageUrl()).into(binding.imageView);
        binding.title.setText(place.getName());
        binding.paragraph1.setText(place.getType());
        binding.paragraph2.setText(String.valueOf((float) place.getDistance()));

    }

}
