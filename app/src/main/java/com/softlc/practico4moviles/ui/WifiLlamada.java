package com.softlc.practico4moviles.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class WifiLlamada extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean modoWifi = intent.getBooleanExtra("connected", false);

        if (modoWifi){
            Intent intentLlamada = new Intent(Intent.ACTION_CALL);
            intentLlamada.setData(Uri.parse("tel:" + "2664485655"));
            intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentLlamada);
        }else {
            Toast.makeText(context, "Wifi Desactivado, No se puede Llamar", Toast.LENGTH_LONG).show();
        }
    }
}
