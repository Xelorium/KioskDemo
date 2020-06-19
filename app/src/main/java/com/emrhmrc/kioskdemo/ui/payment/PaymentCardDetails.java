package com.emrhmrc.kioskdemo.ui.payment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import com.emrhmrc.kioskdemo.base.BaseActivity;
import com.emrhmrc.kioskdemo.databinding.ActivityPaymentCardDetailsBinding;
import com.emrhmrc.kioskdemo.utils.Tools;

public class PaymentCardDetails extends BaseActivity {

    private ActivityPaymentCardDetailsBinding binding;

    @Override
    public ViewBinding setBinding() {
        binding = ActivityPaymentCardDetailsBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    public void onLoad() {
        binding.etCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    binding.cardNumber.setText("**** **** **** ****");
                } else {
                    String number = Tools.insertPeriodically(charSequence.toString().trim(), " ", 4);
                    binding.cardNumber.setText(number);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.etExpire.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    binding.cardExpire.setText("MM/YY");
                } else {
                    String exp = Tools.insertPeriodically(charSequence.toString().trim(), "/", 2);
                    binding.cardExpire.setText(exp);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.etCvv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    binding.cardCvv.setText("***");
                } else {
                    binding.cardCvv.setText(charSequence.toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    binding.cardName.setText("Your Name");
                } else {
                    binding.cardName.setText(charSequence.toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnFinish.setOnClickListener(view -> submitAction());
    }

    private void submitAction() {
        binding.progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialogPaymentSuccess();
                binding.progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }

    private void showDialogPaymentSuccess() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogPaymentSuccessFragment newFragment = new DialogPaymentSuccessFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, newFragment).addToBackStack(null).commit();
    }


}
