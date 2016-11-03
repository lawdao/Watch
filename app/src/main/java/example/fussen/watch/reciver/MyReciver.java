package example.fussen.watch.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import example.fussen.watch.activity.MainActivity;

/**
 * Created by Fussen on 2016/11/3.
 */

public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent startIntent = new Intent();
        startIntent.setClass(context, MainActivity.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startIntent);
    }
}
