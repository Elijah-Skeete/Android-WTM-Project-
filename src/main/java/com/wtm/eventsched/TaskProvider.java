package com.wtm.eventsched;

import android.os.AsyncTask;


public interface TaskProvider<T extends AsyncTask<Void,?,?>> {
    T getTask(int num);
}
