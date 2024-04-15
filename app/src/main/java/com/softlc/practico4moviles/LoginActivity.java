package com.softlc.practico4moviles;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softlc.practico4moviles.databinding.ActivityLoginBinding;
import com.softlc.practico4moviles.ui.WifiLlamada;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityViewModel vm;
    ActivityLoginBinding binding;
    private WifiLlamada llamada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm =  ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);

        registrarBroadcast();

        vm.getMVerificar().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                }else{
                    binding.tvError.setText("Usuario o contraseña incorrecta");
                }

            }
        });

        binding.btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = binding.etUsuario.getText().toString();
                String contrasenia = binding.etContrasenia.getText().toString();
                vm.verificar(usuario, contrasenia);
            }
        });



    }

    private void registrarBroadcast(){
        this.llamada = new WifiLlamada();
        registerReceiver(llamada, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(llamada);
    }
}