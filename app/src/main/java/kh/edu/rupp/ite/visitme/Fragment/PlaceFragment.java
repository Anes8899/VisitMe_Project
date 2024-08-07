package kh.edu.rupp.ite.visitme.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.visitme.Adapter.PlaceViewAdapter;
import kh.edu.rupp.ite.visitme.Api.ApiManager;
import kh.edu.rupp.ite.visitme.Api.ApiService;
import kh.edu.rupp.ite.visitme.Model.Place;
import kh.edu.rupp.ite.visitme.databinding.FragmentPlaceBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceFragment extends Fragment {

    private FragmentPlaceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentPlaceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPlaceData();
    }

    private void loadPlaceData(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/iteapp-api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        showLoading();

        ApiService apiService = ApiManager.getInstance().getApiService();
        apiService.loadingPlace().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                if(response.isSuccessful()){
                    hideLoading();
                    showPlaceList(response.body());
                }else {

                    Toast.makeText(requireContext(), "Error take api", Toast.LENGTH_LONG).show();
                    Log.e("ite-app", "Error"+response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable throwable) {
                hideLoading();
                Toast.makeText(requireContext(), "Error ..", Toast.LENGTH_LONG).show();
                Log.e("ite-app", "Error..."+throwable.getMessage());
            }
        });
    }

    private void showPlaceList(List<Place> places){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false);
        binding.recyclerViewPlace.setLayoutManager(layoutManager);

        PlaceViewAdapter adapter = new PlaceViewAdapter();
        adapter.setDataSet(places);
        binding.recyclerViewPlace.setAdapter(adapter);
    }
    private void showLoading(){
        binding.recyclerViewPlace.setVisibility(View.GONE);
        binding.loading.setVisibility(View.VISIBLE);
    }
    private void hideLoading(){
        binding.loading.setVisibility(View.GONE);
        binding.recyclerViewPlace.setVisibility(View.VISIBLE);
    }

}
