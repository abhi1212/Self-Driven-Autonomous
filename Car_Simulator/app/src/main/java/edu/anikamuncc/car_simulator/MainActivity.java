package edu.anikamuncc.car_simulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    double wheel_rotation_rate;
    double speed;
    double current_position_x;
    double current_position_y;
    double last_position_x;
    double last_position_y;
    double acceleraion;
    double prev_velocity;
    double new_velocity;
    int time=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt_start= (Button) findViewById(R.id.button_start);
        Button bt_accelerate = (Button) findViewById(R.id.button_accelerate);
        Button bt_brake = (Button) findViewById(R.id.button_brake);
        final TextView position = (TextView) findViewById(R.id.position);
        TextView display_metrics = (TextView) findViewById(R.id.display_metrics);
        TextView velocity = (TextView) findViewById(R.id.velocity);
        TextView engine_rpm = (TextView) findViewById(R.id.engine);
        TextView mph_time = (TextView) findViewById(R.id.time);
        TextView braking_distance = (TextView) findViewById(R.id.braking_distance);
        TextView slip_angle = (TextView) findViewById(R.id.slip_angle);
        TextView steering_angle = (TextView) findViewById(R.id.steering_angle);





        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag== false)
                {
                    bt_start.setText("Stop");
                    flag=true;
                }
                else
                {
                    flag=false;
                    bt_start.setText("Start");
                }

            }
        });



        bt_accelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        bt_brake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}


    protected void Longitudnalforce()
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
















        }












