package kh.edu.rupp.ite.visitme.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kh.edu.rupp.ite.visitme.R;
import kh.edu.rupp.ite.visitme.databinding.FragmenteditBinding;

public class EditFragment extends Fragment {

    private FragmenteditBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmenteditBinding.inflate(inflater, container,false);
        View view = binding.getRoot();
        takeData();
        binding.btnSaveProfile.setOnClickListener(v -> returnData());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        takeData();
        binding.allowBack.setOnClickListener(v -> onBack());
//        binding.btnSaveProfile.setOnClickListener(v -> returnData());
    }


    private void onBack() {
        ProfileFragment profileFragment = new ProfileFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, profileFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void takeData() {
        Bundle args = getArguments();
        if (args != null) {
            String fname = args.getString("fName");
            binding.fName.setText(fname);
            String lname = args.getString("lName");
            binding.lName.setText(lname);
            String bio = args.getString("bIo");
            binding.bio.setText(bio);
        }
    }
    private void returnData() {
        String fname = binding.fName.getText().toString();
        String lname = binding.lName.getText().toString();
        String bio = binding.bio.getText().toString();

        Bundle result = new Bundle();
        result.putString("fName", fname);
        result.putString("lName", lname);
        result.putString("bIo", bio);

        getParentFragmentManager().setFragmentResult("requestKey", result);
        getParentFragmentManager().popBackStack();
    }
}
