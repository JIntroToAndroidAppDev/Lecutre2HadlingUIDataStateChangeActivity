package ghoshal.shankhadeep.it15.lecutre2;

import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronoMainAct);

        ChronometerViewModel chronometerViewModel =
                ViewModelProviders.of(this)
                .get(ChronometerViewModel.class);

        if(chronometerViewModel.getCurrentTime() == null){
            long currTime = SystemClock.elapsedRealtime();
            chronometer.setBase(currTime);
            chronometerViewModel.setCurrentTime(currTime);
        } else
            chronometer.setBase(chronometerViewModel.getCurrentTime());

        chronometer.start();

        /*if(savedInstanceState!=null){
            long currentTime = savedInstanceState.getLong("currentTime");
            chronometer.setBase(currentTime);
        } else
            chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.start();*/
        /*try{
            long currentTime = savedInstanceState.getLong("currentTime");
            chronometer.setBase(currentTime);
        }catch(NullPointerException e){
            chronometer.setBase(SystemClock.elapsedRealtime());
        }finally {
            chronometer.start();
        }*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("currentTime",chronometer.getBase());
    }
}