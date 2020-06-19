package com.emrhmrc.kioskdemo.ui.food;

import androidx.annotation.Nullable;

import com.emrhmrc.genericrecycler.adapters.BaseViewHolder;
import com.emrhmrc.genericrecycler.interfaces.IOnItemClickListener;
import com.emrhmrc.kioskdemo.databinding.ItemFoodBinding;
import com.emrhmrc.kioskdemo.models.FoodModel;

/**
 * Created by hamurcuabi on 16,April,2020
 **/
public class RcvFoodViewHolder extends BaseViewHolder<FoodModel,
        IOnItemClickListener<FoodModel>> {
    private ItemFoodBinding binding;


    public RcvFoodViewHolder(ItemFoodBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void onBind(FoodModel item, @Nullable IOnItemClickListener<FoodModel> listener, int position) {
        binding.setModel(item);
        binding.getRoot().setOnClickListener(click -> {
            listener.onItemClicked(item, position);
        });
    }
}
