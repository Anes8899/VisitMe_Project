package kh.edu.rupp.ite.visitme.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;

import kh.edu.rupp.ite.visitme.Fragment.HomeFragment;
import kh.edu.rupp.ite.visitme.Fragment.PlaceFragment;
import kh.edu.rupp.ite.visitme.Fragment.ProfileFragment;
import kh.edu.rupp.ite.visitme.R;
import kh.edu.rupp.ite.visitme.databinding.ActivityLangdingBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityLangdingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLangdingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        HomeFragment homeFragment = new HomeFragment();
        showFragment(homeFragment);

        binding.itemMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return handleOnNavigationItemSelected(item);
            }
        });


    }

    private boolean handleOnNavigationItemSelected(MenuItem item){
        if (item.getItemId() == R.id.itemHome){
            showFragment(new HomeFragment());
        } else if (item.getItemId() == R.id.itemPlace) {
            showFragment(new PlaceFragment());
        }else {
            showFragment(new ProfileFragment());
        }
        return true;
    }


    private void showFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(binding.fragmentContainer.getId(), fragment);

        fragmentTransaction.commit();
    }

}


