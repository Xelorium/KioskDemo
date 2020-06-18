package com.emrhmrc.kioskdemo.ui.home;

import androidx.viewbinding.ViewBinding;

import com.emrhmrc.kioskdemo.base.BaseActivity;
import com.emrhmrc.kioskdemo.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity {
    private ActivityHomeBinding binding;

    @Override
    public ViewBinding setBinding() {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    public void onLoad() {

    }
}
