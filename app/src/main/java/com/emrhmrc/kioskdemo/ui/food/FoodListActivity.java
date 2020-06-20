package com.emrhmrc.kioskdemo.ui.food;

import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.emrhmrc.kioskdemo.base.BaseActivity;
import com.emrhmrc.kioskdemo.databinding.ActivityFoodListBinding;
import com.emrhmrc.kioskdemo.ui.payment.PaymentCardDetails;

public class FoodListActivity extends BaseActivity {

    private ActivityFoodListBinding binding;

    @Override
    public ViewBinding setBinding() {
        binding = ActivityFoodListBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    public void onLoad() {
        binding.setImg1("https://cdn.pixabay.com/photo/2020/06/02/18/10/noodles-5252012__340.jpg");
        binding.setImg2("https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994__340.jpg");
        binding.setImg3("https://cdn.pixabay.com/photo/2014/10/19/20/59/hamburger-494706__340.jpg");
        binding.btnPay.setOnClickListener(view -> goToPayment());

    }

    private void goToPayment() {
        startActivity(new Intent(this, PaymentCardDetails.class));
    }
}
