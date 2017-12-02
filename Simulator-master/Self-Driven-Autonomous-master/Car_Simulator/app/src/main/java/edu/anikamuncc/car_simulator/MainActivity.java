package edu.anikamuncc.car_simulator;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    boolean flag=false;
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
    static int decide=1;
    ImageView wheel;
    double mCurrAngle = 0;
    static int choose=0;
    double mPrevAngle = 0;
    int accel_steps=0;
    int brake_steps=0;
    int brake_x=0;
    int brake_y=0;
    ImageView bask;

    Views mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnimation;
        ImageView image;
        ImageView image1;
        //mView =(Views) findViewById(R.id.View);
       // Views vv= new Views(null,null);
        final Button bt_start= (Button) findViewById(R.id.button_start);
        final Button bt_accelerate = (Button) findViewById(R.id.button_accelerate);
        final Button bt_brake = (Button) findViewById(R.id.button_brake);
        final TextView position = (TextView) findViewById(R.id.position);
        TextView display_metrics = (TextView) findViewById(R.id.display_metrics);
        TextView velocity = (TextView) findViewById(R.id.velocity);
        TextView engine_rpm = (TextView) findViewById(R.id.engine);
        TextView mph_time = (TextView) findViewById(R.id.time);
        TextView braking_distance = (TextView) findViewById(R.id.braking_distance);
        final TextView slip_angle = (TextView) findViewById(R.id.slip_angle);
        TextView steering_angle = (TextView) findViewById(R.id.steering_angle);
        mView = (Views) findViewById(R.id.View);  //Calling the object of view which is created.


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
                        //Log.d("down","down");
                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        mPrevAngle = mCurrAngle;
                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        //Log.d("move","move");

                        animate(mPrevAngle, mCurrAngle, 0);
                        System.out.println(mCurrAngle);
                        mView.inval(mCurrAngle);
                        break;
                    }
                    case MotionEvent.ACTION_UP : {
                        mPrevAngle = mCurrAngle = 0;
                       // Log.d("up","up");
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
                        bt_accelerate.setEnabled(true);
                        accel_steps=1;
                        bt_brake.setEnabled(true);
                        wheel.setVisibility(View.VISIBLE);
                        mView.invalidate();

                    } else {
                        flag = false;
                        decide = 1;
                        bt_start.setText("Start");
                        bt_accelerate.setEnabled(false);
                        bt_brake.setEnabled(false);
                        mView.setCar_x(50);
                        mView.setCar_y(500);
                        wheel.setVisibility(View.INVISIBLE);
                        mView.invalidate();



                    }

                }
            });


            bt_accelerate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    accel_steps=accel_steps+1;
                    brake_steps=0;
                    if(accel_steps==1)
                    {
                        mView.setX_dir(2);
                        mView.setY_dir(2);
                    }

                    if(accel_steps==2)
                    {
                        mView.setX_dir(4);
                        mView.setY_dir(4);
                    }

                    if(accel_steps==3)
                    {
                        mView.setX_dir(6);
                        mView.setY_dir(6);
                    }
                    if(accel_steps>=4)
                    {
                        mView.setX_dir(8);
                        mView.setY_dir(8);
                    }





                }
            });


            bt_brake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                mView.getX_dir();
                mView.getY_dir();
                brake_steps=brake_steps+1;
                if(brake_steps==1)
                {
                    brake_x=  mView.getX_dir()/2;
                    brake_y=  mView.getY_dir()/2;
                    if(brake_x==4)
                    {
                        accel_steps=3;
                    }
                    else if(brake_x==3)
                    {
                        accel_steps=2;
                    }
                    else
                    {
                        accel_steps=1;
                    }

                    mView.setX_dir(brake_x);
                    mView.setY_dir(brake_y);


                }
                if(brake_steps>=2)
                {
                    brake_x= 0;
                    brake_y= 0;
                    mView.setX_dir(brake_x);
                    mView.setY_dir(brake_y);
                    accel_steps=1;
                }

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



























