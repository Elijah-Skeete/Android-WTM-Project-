package com.wtm.eventsched;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


public class HomeActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton ibNewEvent = (ImageButton) findViewById(R.id.ibNewEvent);
        ibNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });

        // start service that fetches new events and notifies user
        this.StartBackgroundService();

    }

    private void StartBackgroundService() {
        Log.d("HomeActivity: ", "service is running: " + RetrieveNewEventsService.isRunning );
        if (!RetrieveNewEventsService.isRunning) {
            Intent serviceIntent = new Intent(this, RetrieveNewEventsService.class);
            startService(serviceIntent);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferencesManager preferencesManager = new PreferencesManager(this,null);
        if (preferencesManager.getRememberLogin() == false) {
            // stop service and clear preferences
            preferencesManager.logout();
        }
    }
}
