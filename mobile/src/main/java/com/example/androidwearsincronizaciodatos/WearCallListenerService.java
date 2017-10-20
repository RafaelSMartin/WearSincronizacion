package com.example.androidwearsincronizaciodatos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;


public class WearCallListenerService extends WearableListenerService {

    public static String SERVICE_CALLED_WEAR = "WearMessage";
    private static final String SHARE_TEXT = "SHARE_TEXT";
    private static final String WEAR_MANDAR_TEXTO ="/mandar_texto";
    Activity activity;

    private final static String ENABLE_AUTO_SPEAK_TRANSLATION = "ENABLE_AUTO_SPEAK_TRANSLATION";
    private static String APP_SETTINGS_KEY = "APP_SETTINGS";
    private SharedPreferences settings;

    private static final String KEY_CONTADOR = "com.example.key.contador";
    private static final String ITEM_CONTADOR = "/contador";
    private int contador;

    /**
     * sincronizacion
     */
    private static final String WEAR_INICIAR_ACTIVIDAD = "/iniciar";
    private static final String WEAR_ENVIAR_TEXTO = "/enviar_texto";
    private static final String WEAR_ENVIAR_TEXTO_AL_PHONE="/enviar_texto_al_phone";




    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
//        super.onMessageReceived(messageEvent);

        if (messageEvent.getPath().equals(WEAR_ENVIAR_TEXTO_AL_PHONE)) {
            String event = messageEvent.getPath();

            Log.d(WEAR_ENVIAR_TEXTO_AL_PHONE, event);

            String[] message = event.split("--");

//        if (message[0].equals(WEAR_ENVIAR_TEXTO_AL_PHONE)) {
            Log.d(WEAR_ENVIAR_TEXTO_AL_PHONE, message[1]);
            Toast.makeText(this, message[1].toString() + "", Toast.LENGTH_SHORT).show();
//        }

            Intent sendIntent = new Intent(this, MainActivity.class);
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(WEAR_ENVIAR_TEXTO_AL_PHONE, message[1]);
            sendIntent.setFlags(sendIntent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(sendIntent);
        } else {
            super.onMessageReceived(messageEvent);
        }
    }

}
