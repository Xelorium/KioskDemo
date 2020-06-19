package com.emrhmrc.kioskdemo.ui.helper;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Created by hamurcuabi on 18,June,2020
 **/
public class DataBindingHelper {
    @BindingAdapter("loadImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, int spanCount) {
        if (spanCount == -1)
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        else if (spanCount == -2)
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false));
        else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), spanCount,
                    GridLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(gridLayoutManager);
        }

    }
}
