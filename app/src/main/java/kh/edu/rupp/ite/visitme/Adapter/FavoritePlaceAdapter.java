package kh.edu.rupp.ite.visitme.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.visitme.Model.FavoritePlaceinProfile;
import kh.edu.rupp.ite.visitme.Model.Place;
import kh.edu.rupp.ite.visitme.databinding.ViewHolderProfileBinding;

public class FavoritePlaceAdapter extends RecyclerView.Adapter<FavoritePlaceViewHolder> {

    private List<FavoritePlaceinProfile> data;

    public void setDataSet(List<FavoritePlaceinProfile> dataSet) {
        this.data = dataSet;
    }

    @NonNull
    @Override
    public FavoritePlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderProfileBinding binding = ViewHolderProfileBinding.inflate(inflater, parent, false);
        return new FavoritePlaceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritePlaceViewHolder holder, int position) {
        FavoritePlaceinProfile favoritePlace = data.get(position);
        holder.bind(favoritePlace);
    }

    @Override
    public int getItemCount() {
        if(data == null){
            return 0;
        } else {
            return data.size();
        }
    }
}
