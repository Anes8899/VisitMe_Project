package kh.edu.rupp.ite.visitme.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.visitme.Model.FavoritePlaceinProfile;
import kh.edu.rupp.ite.visitme.Model.Profile;
import kh.edu.rupp.ite.visitme.databinding.ViewHolderProfileBinding;

public class FavoritePlaceViewHolder extends RecyclerView.ViewHolder {

    private final ViewHolderProfileBinding binding;
    public FavoritePlaceViewHolder(ViewHolderProfileBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bind(FavoritePlaceinProfile favoritePlaceinProfile){
        Picasso.get().load(favoritePlaceinProfile.getImageUrl()).into(binding.imageViewHolder);
        binding.titleImageFavorite.setText(favoritePlaceinProfile.getName());
    }
}
