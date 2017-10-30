package edu.anikamuncc.car_simulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean flag=true;
    double engine_force;
    double drag_force;
    double rolling_resistance;
    double drive_force;
    double torque_engine;
    double gear_ratio= 2.66;
    double differential_ratio=3.42;
    double transmission_efficieny=0.7;
    double wheel_radius;
    int rpm;
    private double wheel_rotation_rate;
    double speed;
    double current_position_x;
    double current_position_y;
    double last_position_x;
    double last_position_y;
    double acceleraion;
    double prev_velocity;
    double new_velocity;
    int time=1;
    double Crr=12.8;
    double Cdrag=0.4257;
    static int decide=0;
    ImageView wheel;
    double mCurrAngle = 0;
    double mPrevAngle = 0;
    ImageView bask;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Views mView;
        Button btnAnimation;
        ImageView image;
        ImageView image1;
        //mView =(Views) findViewById(R.id.View);
       // Views vv= new Views(null,null);
        final Button bt_start= (Button) findViewById(R.id.button_start);
        Button bt_accelerate = (Button) findViewById(R.id.button_accelerate);
        Button bt_brake = (Button) findViewById(R.id.button_brake);
        final TextView position = (TextView) findViewById(R.id.position);
        TextView display_metrics = (TextView) findViewById(R.id.display_metrics);
        TextView velocity = (TextView) findViewById(R.id.velocity);
        TextView engine_rpm = (TextView) findViewById(R.id.engine);
        TextView mph_time = (TextView) findViewById(R.id.time);
        TextView braking_distance = (TextView) findViewById(R.id.braking_distance);
        final TextView slip_angle = (TextView) findViewById(R.id.slip_angle);
        TextView steering_angle = (TextView) findViewById(R.id.steering_angle);



        wheel=(ImageView)findViewById(R.id.wheelimage);
        //wheel.setOnClickListener(new View.OnClickListener() {

        wheel.setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                final float xc = wheel.getWidth() / 2;
                final float yc = wheel.getHeight() / 2;

                final float x = event.getX();
                final float y = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        wheel.clearAnimation();
                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        mPrevAngle = mCurrAngle;
                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        animate(mPrevAngle, mCurrAngle, 0);
                        System.out.println(mCurrAngle);
                        break;
                    }
                    case MotionEvent.ACTION_UP : {
                        mPrevAngle = mCurrAngle = 0;
                        break;
                    }
                }
                return true;
            }

        });





            bt_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (flag == false) {
                        bt_start.setText("Stop");
                        decide = 0;
                        flag = true;
                    } else {
                        flag = false;
                        bt_start.setText("Start");
                        decide = 1;
                    }

                }
            });


            bt_accelerate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    decide = 0;
                    slip_angle.setText("dda");

                }
            });


            bt_brake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                }
            });

        }


    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        wheel.startAnimation(rotate);
        System.out.println(mCurrAngle);
    }




}




  /*  protected void Longitudnalforce()
    {




    }


    protected void Dragforce()
    {



    }


    protected void RollingResistance()
    {




    }

    protected void Tractionalforce()
    {



    }

    protected void Engineforce()
    {
        engine_force= torque_engine * gear_ratio * differential_ratio * transmission_efficieny / wheel_radius;

    }

    protected void rpm() {
        rpm =(int) ((wheel_rotation_rate *gear_ratio *differential_ratio *60 )/ 2 * (3.14));
    }

    protected void wheel_rotation_rate()
    {
        wheel_rotation_rate=(speed/wheel_radius);
    }

    protected void Calculatespeed()
    {



    }

    protected void Updateposition() {

        new_velocity = prev_velocity + (acceleraion * time);




    }




 }


}

*/



























