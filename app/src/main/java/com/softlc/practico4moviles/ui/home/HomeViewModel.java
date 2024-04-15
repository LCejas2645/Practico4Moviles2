package com.softlc.practico4moviles.ui.home;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<String> mText;
    private MutableLiveData<String> mError;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getText() {
        if(mText == null){
            mText = new MutableLiveData<>();
        }
        return mText;
    }

    public LiveData<String> getMError() {
        if(mError == null){
            mError = new MutableLiveData<>();
        }
        return mError;
    }

    public void llamar(String num){
        Log.d("salida","logllA");
        if (num == null){
            mError.setValue("Ingrese un numero valido");
        }else {
            Log.d("salida","logllA");
            Intent intentLlamada = new Intent(Intent.ACTION_CALL);
            intentLlamada.setData(Uri.parse("tel:" + num));
            intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intentLlamada);
        }

    }
}