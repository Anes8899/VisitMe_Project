package kh.edu.rupp.ite.visitme.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.visitme.Model.Place;
import kh.edu.rupp.ite.visitme.databinding.ViewHolderPlaceBinding;

public class PlaceViewAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private List<Place> dataSet;


    public void setDataSet(List<Place> dataSet) {this.dataSet = dataSet;}
    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderPlaceBinding binding = ViewHolderPlaceBinding.inflate(inflater, parent, false);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(binding);
        return new PlaceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Place place = dataSet.get(position);
        holder.bind(place);

    }

    @Override
    public int getItemCount() {
        if (dataSet == null) {
            return 0;
        } else {
            return dataSet.size();
        }
    }
}
