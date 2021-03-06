package com.emrhmrc.kioskdemo.ui.food;

import android.content.Intent;
import android.widget.NumberPicker;

import androidx.viewbinding.ViewBinding;

import com.emrhmrc.genericrecycler.helpers.GRVHelper;
import com.emrhmrc.genericrecycler.interfaces.IOnItemClickListener;
import com.emrhmrc.kioskdemo.R;
import com.emrhmrc.kioskdemo.base.BaseActivity;
import com.emrhmrc.kioskdemo.databinding.ActivityFoodBinding;
import com.emrhmrc.kioskdemo.models.FoodModel;
import com.emrhmrc.sweetdialoglib.DialogCreater;

/**
 * Created by hamurcuabi on 19,June,2020
 **/
public class FoodActivity extends BaseActivity implements IOnItemClickListener<FoodModel>, NumberPicker.OnValueChangeListener {

    private ActivityFoodBinding binding;
    private RcvFoodAdapter adapter;
    private FoodModel selected;
    private int selectedIndex;

    @Override
    public ViewBinding setBinding() {
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        return binding;
    }

    private void setRcvAdapter() {
        GRVHelper.setResId(R.anim.layout_animation_fall_down);
        adapter = new RcvFoodAdapter(this, this, null);
        GRVHelper.setup(adapter, binding.rcvFood);

    }

    @Override
    public void onLoad() {
        setRcvAdapter();
        prepareData();
        binding.fabMic.setOnClickListener(view -> goList());
        binding.toolbarTitle.setText("Ürün Seçimi");

    }

    private void goList() {
        startActivity(new Intent(this, FoodListActivity.class));
    }

    private void prepareData() {
        FoodModel foodModel = new FoodModel();
        foodModel.setImage("https://cdn.pixabay.com/photo/2016/08/11/08/04/vegetables-1584999__340.jpg");
        foodModel.setName("Karışık Sebze");
        foodModel.setPrice("23.90 ₺");
        adapter.add(foodModel);

        FoodModel foodModel2 = new FoodModel();
        foodModel2.setImage("https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305__340.jpg");
        foodModel2.setName("Biftek");
        foodModel2.setPrice("34.90 ₺");
        adapter.add(foodModel2);

        FoodModel foodModel3 = new FoodModel();
        foodModel3.setImage("https://cdn.pixabay.com/photo/2020/06/02/18/10/noodles-5252012__340.jpg");
        foodModel3.setName("Soslu Makarna");
        foodModel3.setPrice("17.90 ₺");
        adapter.add(foodModel3);

        FoodModel foodModel4 = new FoodModel();
        foodModel4.setImage("https://cdn.pixabay.com/photo/2014/10/19/20/59/hamburger-494706__340.jpg");
        foodModel4.setName("Hamburger Menü");
        foodModel4.setPrice("19.90 ₺");
        adapter.add(foodModel4);

        FoodModel foodModel5 = new FoodModel();
        foodModel5.setImage("https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994__340.jpg");
        foodModel5.setName("Çöp Şiş");
        foodModel5.setPrice("29.90 ₺");
        adapter.add(foodModel5);

    }

    @Override
    public void onItemClicked(FoodModel item, int positon) {
        adapter.updateItem(item, positon);
        selected = item;
        selectedIndex = positon;
        showNumberPicker();

    }

    public void showNumberPicker() {
        NumberPickerDialog newFragment = new NumberPickerDialog();
        newFragment.setValueChangeListener(this);
        newFragment.show(getSupportFragmentManager(), "NumberPickerDialog picker");
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        if (i > 0) {
            selected.setSelected(true);
            DialogCreater.succesDialog(this, "" + i + " porsiyon " + selected.getName() + " " +
                    "sepete eklendi");
        } else {
            if (selected.getCount() != 0) {
                DialogCreater.succesDialog(this, selected.getName() + " sepetten çıkarıldı");
            } else {
               // DialogCreater.succesDialog(this, selected.getName() + " zaten sepette
                // bulunmuyor");
            }
            selected.setSelected(false);
        }

        selected.setCount(i);
        adapter.updateItem(selected, selectedIndex);
    }
}
