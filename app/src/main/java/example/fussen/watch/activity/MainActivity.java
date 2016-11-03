package example.fussen.watch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import example.fussen.watch.R;
import example.fussen.watch.device.DeviceMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView open = (TextView) findViewById(R.id.open);

        open.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                DeviceMethod.getInstance(MainActivity.this).onActivate();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
