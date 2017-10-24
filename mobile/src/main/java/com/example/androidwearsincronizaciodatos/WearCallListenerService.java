package com.example.androidwearsincronizaciodatos;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;


public class WearCallListenerService extends WearableListenerService {

    public static String SERVICE_CALLED_WEAR = "WearMessage";
    private static final String SHARE_TEXT = "SHARE_TEXT";
    private static final String WEAR_ENVIAR_TEXTO="/enviar_texto";
    Activity activity;

    private final static String ENABLE_AUTO_SPEAK_TRANSLATION = "ENABLE_AUTO_SPEAK_TRANSLATION";
    private static String APP_SETTINGS_KEY = "APP_SETTINGS";
    private SharedPreferences settings;




    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);

        String event = messageEvent.getPath();

        Log.d(WEAR_ENVIAR_TEXTO, event);

        String [] message = event.split("--");

//        Toast.makeText(this, "Mensaje: "+message[1], Toast.LENGTH_SHORT).show();

        if (message[0].equals(WEAR_ENVIAR_TEXTO)) {

            Log.d(WEAR_ENVIAR_TEXTO, message[1]);
//            MyApplication.getInstance();
//            MyApplication.setStringFromWear(message[1]);

//            startActivity(new Intent((Intent) Listactivity.getInstance().tutorials.get(message[1]))
//                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            //todo deshabilitar sonido de traduccion
//            settings = getSharedPreferences(APP_SETTINGS_KEY, Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = settings.edit();
//            editor.putBoolean(ENABLE_AUTO_SPEAK_TRANSLATION, false).commit();


            Intent sendIntent = new Intent(this, MainActivity.class);
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(WEAR_ENVIAR_TEXTO, message[1]);
            sendIntent.setFlags(sendIntent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(sendIntent);

//            Intent i = new Intent(this, MainActivity.class);
//            i.putExtra("SHARE_TEXT", message[1]);
//            startActivity(i);

        }
    }
}