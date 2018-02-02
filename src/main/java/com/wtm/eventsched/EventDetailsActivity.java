package com.wtm.eventsched;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class EventDetailsActivity extends MenuActivity {

    private Event mEvent;
    private TextView tvTitle, tvDate, tvTime,
            tvDuration, tvLocation, tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        tvTitle = (TextView) findViewById(R.id.tvEventdetailsTitle);
        tvDate = (TextView) findViewById(R.id.tvEventdetailsDate);
        tvTime = (TextView) findViewById(R.id.tvEventdetailsTime);
        tvDuration = (TextView) findViewById(R.id.tvEventdetailsDuration);
        tvLocation = (TextView) findViewById(R.id.tvEventdetailsLocation);
        tvBody = (TextView) findViewById(R.id.tvEventdetailsBody);

        Intent intent = getIntent();
        mEvent = intent.getParcelableExtra("event");
        this.setEventDetails();
    }

    private void setEventDetails() {
        tvTitle.setText(this.mEvent.getTitle());
        tvDate.setText(this.mEvent.getDateString());
        tvTime.setText(this.mEvent.getTimeString());

        tvDuration.setText(Integer.toString(this.mEvent.getDuration()) + " Minutes");
        tvLocation.setText(this.mEvent.getLocation());
        tvBody.setText(this.mEvent.getDetails());
    }


    public Event getEvent() {
        return mEvent;
    }
}
