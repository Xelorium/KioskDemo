package com.emrhmrc.kioskdemo.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

/**
 * Created by hamurcuabi on 03,March,2020
 **/
public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = "BaseActivity";
    private ViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = setBinding();
        View view = binding.getRoot();
        setContentView(view);
        onLoad();


    }

    public abstract ViewBinding setBinding();

    public abstract void onLoad();

}
