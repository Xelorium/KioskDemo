package com.emrhmrc.kioskdemo.ui.home;

import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.emrhmrc.genericrecycler.helpers.GRVHelper;
import com.emrhmrc.genericrecycler.interfaces.IOnItemClickListener;
import com.emrhmrc.kioskdemo.R;
import com.emrhmrc.kioskdemo.base.BaseActivity;
import com.emrhmrc.kioskdemo.databinding.ActivityHomeBinding;
import com.emrhmrc.kioskdemo.models.RestorantModel;
import com.emrhmrc.kioskdemo.ui.food.FoodActivity;

public class HomeActivity extends BaseActivity implements IOnItemClickListener<RestorantModel> {
    private ActivityHomeBinding binding;
    private RcvRestorantAdapter rcvRestorantAdapter;

    @Override
    public ViewBinding setBinding() {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    public void onLoad() {
        setRcvAdapter();
        prepareData();
        binding.toolbarTitle.setText("Restorant Seçimi");

    }

    private void setRcvAdapter() {
        GRVHelper.setResId(R.anim.layout_animation_fall_down);
        rcvRestorantAdapter = new RcvRestorantAdapter(this, this, null);
        GRVHelper.setup(rcvRestorantAdapter, binding.rcvRestorant);

    }

    private void prepareData() {
        RestorantModel testModel = new RestorantModel();
        testModel.setImage("https://primemall.s3-eu-west-1.amazonaws.com/images/brand_logo/VkbfX1G-l_brand_logo_-main-.jpg?1445524464684");
        testModel.setName("McDonalds");
        rcvRestorantAdapter.add(testModel);

        RestorantModel testModel2 = new RestorantModel();
        testModel2.setImage("https://d35mh9ae3ltweb.cloudfront.net/57d5ca2f47dde42bfbdc7e6c/KXKg0xgw8/web/gJ7QecpvO7JSW6uO11bOKEvma3E=/original");
        testModel2.setName("Hamurcu Balık Evi");
        rcvRestorantAdapter.add(testModel2);

        RestorantModel testModel3 = new RestorantModel();
        testModel3.setImage("https://cdn.yemek.com/mnresize/940/940/uploads/2014/10/tas-kebabi-yemekcom.jpg");
        testModel3.setName("Ev Yemekleri");
        rcvRestorantAdapter.add(testModel3);

        RestorantModel testModel4 = new RestorantModel();
        testModel4.setImage("https://vegnews.com/media/W1siZiIsIjE3ODcxL1ZlZ05ld3MuU3ViVmVnU3Vid2F5QnJhemlsLmpwZyJdLFsicCIsImNvbnZlcnQiLCItY3JvcCAxMTkxeDcwNCswKzQyICtyZXBhZ2UgLXJlc2l6ZSA4MDB4NDczXiIseyJmb3JtYXQiOiJqcGcifV0sWyJwIiwib3B0aW1pemUiXV0/VegNews.SubVegSubwayBrazil.jpg?sha=73649dac85fff7fa");
        testModel4.setName("SubWay");
        rcvRestorantAdapter.add(testModel4);

        rcvRestorantAdapter.add(testModel3);
        rcvRestorantAdapter.add(testModel2);
        rcvRestorantAdapter.add(testModel4);
        rcvRestorantAdapter.add(testModel);


    }

    @Override
    public void onItemClicked(RestorantModel item, int positon) {
        item.setSelected(!item.isSelected());
        rcvRestorantAdapter.updateItem(item, positon);
        startActivity(new Intent(this, FoodActivity.class));

    }
}
