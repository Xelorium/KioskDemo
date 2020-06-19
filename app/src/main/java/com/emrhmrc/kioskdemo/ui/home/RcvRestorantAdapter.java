package com.emrhmrc.kioskdemo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.emrhmrc.genericrecycler.adapters.GenericAdapter;
import com.emrhmrc.genericrecycler.interfaces.IOnItemClickListener;
import com.emrhmrc.kioskdemo.R;
import com.emrhmrc.kioskdemo.databinding.ItemRestorantBinding;
import com.emrhmrc.kioskdemo.models.RestorantModel;

/**
 * Created by hamurcuabi on 26,March,2020
 **/
public class RcvRestorantAdapter extends GenericAdapter<RestorantModel,
        IOnItemClickListener<RestorantModel>, RcvRestorantViewHolder> {


    public RcvRestorantAdapter(Context context, IOnItemClickListener<RestorantModel> listener, @Nullable ViewGroup emptyView) {
        super(context, listener, emptyView);
    }

    @NonNull
    @Override
    public RcvRestorantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRestorantBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_restorant, parent, false);
        return new RcvRestorantViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
