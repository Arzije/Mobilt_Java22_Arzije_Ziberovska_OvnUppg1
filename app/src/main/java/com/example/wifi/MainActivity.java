package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        //WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        TextView text2 = findViewById(R.id.textView);
        text2.setText("Connecting...");

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

                //WifiInfo wifiInfo = wifiManager.getConnectionInfo();

                if (activeNetwork != null && activeNetwork.isConnectedOrConnecting() && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    Log.d("Connected", "Connected");
                    text2.setText("Connected to WiFi.");
                } else {
                    Log.d("Disconnected", "Disconnected");
                    text2.setText("Not connected to WiFi.");
                }
            }
        });
    }
}