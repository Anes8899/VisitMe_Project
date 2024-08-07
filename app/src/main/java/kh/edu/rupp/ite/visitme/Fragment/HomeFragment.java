package kh.edu.rupp.ite.visitme.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import kh.edu.rupp.ite.visitme.R;
import kh.edu.rupp.ite.visitme.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnExplore.setOnClickListener(v -> onClickBtn());
    }

    private void onClickBtn(){
        Toast.makeText(getActivity(), "Button clicked!", Toast.LENGTH_SHORT).show();
        PlaceFragment placeFragment = new PlaceFragment();

        // Perform the fragment transaction
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, placeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
