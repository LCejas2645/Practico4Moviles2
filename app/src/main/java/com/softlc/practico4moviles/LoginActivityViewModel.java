package com.softlc.practico4moviles;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class LoginActivityViewModel extends AndroidViewModel {
    MutableLiveData<Boolean> mVerificar;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getMVerificar() {
        if(mVerificar == null){
            mVerificar = new MutableLiveData<>();
        }
        return mVerificar;
    }

    public void verificar(String u, String c){


        if (u.equals("admin") && c.equals("1234")){
            Log.d("salida","mutable");
            mVerificar.setValue(true);
        }else{
            mVerificar.setValue(false);
        }
    }
}
