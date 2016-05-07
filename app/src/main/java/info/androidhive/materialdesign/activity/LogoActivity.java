package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import info.androidhive.materialdesign.R;

public class LogoActivity extends AppCompatActivity {
    protected boolean _active = true;
    protected int _splashTime = 2000;

    private Intent intent;
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        final SharedPreferences shared=getSharedPreferences("users",MODE_PRIVATE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
                if(!(shared.getString("username","default").equals("default"))&&!(shared.getString("password","default").equals("default"))){
                    intent = new Intent(getBaseContext(),ScheduleActivity.class);
                    Toast.makeText(getBaseContext(),"hj",Toast.LENGTH_LONG).show();

                }else{
                     intent = new Intent(LogoActivity.this, HomeActivity.class);
               }
                startActivity(intent);
            }
        }, _splashTime);
    }
}


