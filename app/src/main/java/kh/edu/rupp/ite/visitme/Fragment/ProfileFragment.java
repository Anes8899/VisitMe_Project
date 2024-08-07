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
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.visitme.Adapter.FavoritePlaceAdapter;
import kh.edu.rupp.ite.visitme.Api.ApiManager;
import kh.edu.rupp.ite.visitme.Api.ApiService;
import kh.edu.rupp.ite.visitme.Model.FavoritePlaceinProfile;
import kh.edu.rupp.ite.visitme.Model.Profile;
import kh.edu.rupp.ite.visitme.R;
import kh.edu.rupp.ite.visitme.databinding.FragmentHomeBinding;
import kh.edu.rupp.ite.visitme.databinding.FragmentProfileBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String fname = bundle.getString("fName");
                String lname = bundle.getString("lName");
                String bio = bundle.getString("bIo");

                binding.firstName.setText(fname);
                binding.lastName.setText(lname);
                binding.bio.setText(bio);
            }
        });
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadingProfileData();
//        binding.edit.setOnClickListener(v -> onClickEdit());
        binding.edit.setOnClickListener(v -> openEditFragment());
    }

    private void loadingProfileData() {
        showLoading();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/iteapp-api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        ApiService apiService = retrofit.create((ApiService.class));
        ApiService apiService = ApiManager.getInstance().getApiService();
        apiService.loadingProfile().enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.isSuccessful()) {
                    hideLoading();
                    assert response.body() != null;
                    disPlayProfile(response.body());
                } else {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show();
                    Log.e("ite-app", "Error" + response.message());

                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable throwable) {
                hideLoading();
                Toast.makeText(requireContext(), "Error from api", Toast.LENGTH_LONG).show();
                Log.e("ite-app", "Error" + throwable.getMessage());
            }
        });
    }

    private void disPlayProfile(Profile profile) {
        binding.firstName.setText(profile.getFirstName());
        binding.lastName.setText(profile.getLastName());
        binding.email.setText(profile.getEmail());
        binding.bio.setText(profile.getBio());
        Picasso.get()
                .load(profile.getCoverImage())
                .into(binding.coverImage);
        Picasso.get()
                .load(profile.getCoverImage())
                .into(binding.imageProfile);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireContext(),3,LinearLayoutManager.VERTICAL, false);

        binding.recycleViewProfile.setLayoutManager(layoutManager);

        FavoritePlaceAdapter adapter = new FavoritePlaceAdapter();
        adapter.setDataSet(profile.getFavoritePlaces());
        binding.recycleViewProfile.setAdapter(adapter);
    }

    private void showLoading(){
        binding.lyContent.setVisibility(View.GONE);
        binding.loading.setVisibility(View.VISIBLE);
    }
    private void hideLoading(){
        binding.loading.setVisibility(View.GONE);
        binding.lyContent.setVisibility(View.VISIBLE);
    }
//    private void onClickEdit(){
//        EditFragment editFragment = new EditFragment();
//        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_container, editFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
    private void openEditFragment() {
        String fname = binding.firstName .getText().toString();
        String lname = binding.lastName.getText().toString();
        String bio = binding.bio.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("fName", fname);
        bundle.putString("lName", lname);
        bundle.putString("bIo", bio);

        EditFragment editFragment = new EditFragment();
        editFragment.setArguments(bundle);

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, editFragment)
                .addToBackStack(null)
                .commit();
    }
}
