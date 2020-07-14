package com.emrhmrc.kioskdemo.ui.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.emrhmrc.genericrecycler.adapters.GenericAdapter;
import com.emrhmrc.genericrecycler.interfaces.IOnItemClickListener;
import com.emrhmrc.kioskdemo.R;
import com.emrhmrc.kioskdemo.databinding.ItemFoodBinding;
import com.emrhmrc.kioskdemo.models.FoodModel;

/**
 * Created by hamurcuabi on 26,March,2020
 **/
public class RcvFoodAdapter extends GenericAdapter<FoodModel,
        IOnItemClickListener<FoodModel>, RcvFoodViewHolder> {


    public RcvFoodAdapter(Context context, IOnItemClickListener<FoodModel> listener, @Nullable ViewGroup emptyView) {
        super(context, listener, emptyView);
    }

    @NonNull
    @Override
    public RcvFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
               R.layout.item_food, parent, false);
        return new RcvFoodViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
