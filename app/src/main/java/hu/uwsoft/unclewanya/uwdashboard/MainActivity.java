package hu.uwsoft.unclewanya.uwdashboard;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    UWDashboardApp app;
    Button btnButton1;
    ProgressBar pbarSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = UWDashboardApp.instance();
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Handler handler = new Handler();
        Timer timer = new Timer(false);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Calendar calendar = Calendar.getInstance();
                        btnButton1 = (Button) findViewById(R.id.btnButton1);
                        btnButton1.setText(calendar.getTime().toString());
                        pbarSecond = (ProgressBar)findViewById(R.id.pbarSecond);
                        pbarSecond.setProgress(calendar.get(Calendar.SECOND));
                    }
                });
            }
        };

        timer.schedule(timerTask, 250, 250); // 1000 = 1 second.
/*
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Do whatever you want
                        TextView tvText = (TextView) findViewById(R.id.tvText);
                        tvText.setText(Calendar.getInstance().getTime().toString());
                    }
                });
            }
        };

        timer.schedule(timerTask, 1000); // 1000 = 1 second.
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            TextView tvText = (TextView) findViewById(R.id.tvText);
            tvText.setTextColor(Color.BLUE);
            }
        });

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
*/
    }

}
