package com.emrhmrc.kioskdemo.ui.home;

import androidx.annotation.Nullable;

import com.emrhmrc.genericrecycler.adapters.BaseViewHolder;
import com.emrhmrc.genericrecycler.interfaces.IOnItemClickListener;
import com.emrhmrc.kioskdemo.databinding.ItemRestorantBinding;
import com.emrhmrc.kioskdemo.models.RestorantModel;

/**
 * Created by hamurcuabi on 16,April,2020
 **/
public class RcvRestorantViewHolder extends BaseViewHolder<RestorantModel,
        IOnItemClickListener<RestorantModel>> {
    private ItemRestorantBinding binding;


    public RcvRestorantViewHolder(ItemRestorantBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void onBind(RestorantModel item, @Nullable IOnItemClickListener<RestorantModel> listener, int position) {
        binding.setModel(item);
        binding.getRoot().setOnClickListener(click -> {
            listener.onItemClicked(item, position);
        });
    }
}
