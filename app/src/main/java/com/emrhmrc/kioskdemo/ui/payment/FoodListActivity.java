package com.emrhmrc.kioskdemo.ui.payment;

import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.emrhmrc.kioskdemo.base.BaseActivity;
import com.emrhmrc.kioskdemo.databinding.ActivityFoodListBinding;

public class FoodListActivity extends BaseActivity {

    private ActivityFoodListBinding binding;

    @Override
    public ViewBinding setBinding() {
        binding = ActivityFoodListBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    public void onLoad() {
        binding.btnPay.setOnClickListener(view -> goToPayment());

    }

    private void goToPayment() {
        startActivity(new Intent(this, PaymentCardDetails.class));
    }
}
