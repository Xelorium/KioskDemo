package com.emrhmrc.kioskdemo.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by hamurcuabi on 11,April,2020
 **/
public class BaseViewModel extends ViewModel {
    public static final String TAG = "BaseViewModel";
    public CompositeDisposable disposable = new CompositeDisposable();
    public MutableLiveData<Boolean> isLoadingMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> errorTextMutableLiveData = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
