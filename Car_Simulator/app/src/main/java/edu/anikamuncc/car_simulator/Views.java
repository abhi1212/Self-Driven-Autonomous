package edu.anikamuncc.car_simulator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import static edu.anikamuncc.car_simulator.MainActivity.accel_steps;
import static edu.anikamuncc.car_simulator.MainActivity.choose;
import static edu.anikamuncc.car_simulator.MainActivity.decide;
import static edu.anikamuncc.car_simulator.R.id.position;

/**
 * Created by dnika on 10/29/2017.
 */

public class Views extends View {

    private static final int SQUARE_SIZE = 250;

    private Rect mRectSquare;

    private Rect mRectSquare1;

    private Rect mRectSquare2;


    private Paint mPaintSquare;

    private Paint mPaintSquare1;

    private Paint mPaintSquare2;



    Bitmap car_bm;

    Bitmap car_bm1;

    int car_x, car_y;

    int x_dir, y_dir;

    int carHeight, carWidth;    //Car_height is 10 and car_width is 5.

    Button btnAnimation;

    private Views mView;

    Matrix matrix = new Matrix();



    public Views(Context context) {
        super(context);


        init(null); //called from all the constructors

        car_x = 50; //our locations updated
        car_y = 500;
        x_dir = 1; //speed in which coordinates are changed
        y_dir = 1;
    }

    public Views(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        init(attrs);

        car_x = 50; //our locations updated
        car_y = 500;
        x_dir = 2;
        y_dir = 2;
    }

    public Views(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);

        car_x = 50; //our locations updated
        car_y = 500;
        x_dir = 2;
        y_dir = 2;
    }

    @SuppressLint("NewApi")
    public Views(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

        car_x = 50; //our locations updated
        car_y = 500;
        x_dir = 2;
        y_dir = 2;
    }


    public int getX_dir() {
        return x_dir;
    }

    public void setX_dir(int x_dir) {
        this.x_dir = x_dir;
    }

    public int getY_dir() {
        return y_dir;
    }

    public void setY_dir(int y_dir) {
        this.y_dir = y_dir;
    }


    public void setCar_x(int car_x) {
        this.car_x = car_x;
    }

    public void setCar_y(int car_y) {
        this.car_y = car_y;
    }

    private void init(@Nullable AttributeSet set) {

        mRectSquare2 = new Rect();
        mPaintSquare2 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        mRectSquare1 = new Rect();
        mPaintSquare1 = new Paint(Paint.ANTI_ALIAS_FLAG);


    }

    protected void onDraw(Canvas canvas) {

        //Object rect used for the setup position and size for our square

        //below are coordinate points for corners of the black square

       // System.out.println("Car Height and Car width is "+carHeight+" "+ carWidth);
        mRectSquare2.left = 0; //x = 0
        mRectSquare2.top = 0; //y = 0
        mRectSquare2.right = 470 + mRectSquare2.left; //x = 470
        mRectSquare2.bottom = mRectSquare2.top + 610; //y = 610

        //below are coordinate points for corners of the grey square

        mRectSquare.left = 50; // x = 50
        mRectSquare.top = 50; // y = 50
        mRectSquare.right = 380 + mRectSquare.left-10; // x = 430
        mRectSquare.bottom = mRectSquare.top + 510; // y = 560

        //below are coordinate points for corners of the green square

        mRectSquare1.left = 110; // x = 110
        mRectSquare1.top = 110; // y = 110
        mRectSquare1.right = 330 + mRectSquare.left-20; // x = 360
        mRectSquare1.bottom = mRectSquare.top + 450; //  y = 500

        mPaintSquare2.setColor(Color.BLACK);

        mPaintSquare.setColor(Color.GRAY);

        mPaintSquare1.setColor(Color.GREEN);


        canvas.drawRect(mRectSquare2, mPaintSquare2);

        canvas.drawRect(mRectSquare, mPaintSquare);

        canvas.drawRect(mRectSquare1, mPaintSquare1);

        car_bm = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        car_bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.car);

        BitmapFactory.Options option = new BitmapFactory.Options(); //how dimensions of image is found
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.car, option);
        carHeight = option.outHeight;
        carWidth = option.outWidth;

//        ImageView img1 = (ImageView)findViewById(R.drawable.car);
//        matrix.postRotate(-90);
//        Bitmap rotatedBitmap = Bitmap.createBitmap(car_bm, 0, 0, carWidth, carHeight, matrix, true );


        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        Bitmap bmpBowRotated = Bitmap.createBitmap(car_bm, 0, 0, car_bm.getWidth(), car_bm.getHeight(), matrix, false);



    if(car_x>=50 && car_x<=110-carHeight) //
    {


        if(car_y<=(110-carHeight) && car_y>=50) //
        {
            canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
            car_x = car_x + x_dir;

        }

        else if(car_y>=(110-carHeight) && car_y<500+carHeight)
        {
            canvas.drawBitmap(car_bm, car_x, car_y, null);
            car_y = car_y - y_dir;

        }

        else if(car_y>=500+carHeight && car_y<=560)            //Upper left //commented
        {

            canvas.drawBitmap(car_bm, car_x, car_y, null);
            car_y = car_y - y_dir;

        }




    }

    if(car_x>110-carHeight && car_x<=(360))          //Upper right lane
    {
        if(car_y<=110+carHeight && car_y>=50) {

            canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
            car_x = car_x + x_dir;
        }
        else if (car_y>=500+carHeight && car_y<560)
        {
            canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
            car_x = car_x - x_dir;

        }

    }


    if(car_x>=360 && car_x<=420)            //Going Down
    {
        if(car_y<110 && car_y>=50) {

            canvas.drawBitmap(car_bm, car_x, car_y, null);
            car_y = car_y + y_dir;
        }

        else if(car_y>=110 && car_y<500+carHeight)
        {
            canvas.drawBitmap(car_bm, car_x, car_y, null);
            car_y = car_y + y_dir;

        }


        else if(car_y>=500 && car_y<560)
        {
            canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
            car_x = car_x - x_dir;

        }
    }


        if(decide==0) {
            //Log.d("tag1","inside decide 0");

            invalidate(); //allows us to draw the Bitmap map again and again
            //clears everything is done in this method at the very end, Android then repeats itself
            //the x and y coordinates remember there values so they can be incremented
        }
    }




    public  void inval(double angle) {


        int cary1;
        int carx1;
        int lane_selector = 0;
        lane_selector = (int) angle / 15;
        //System.out.println("Lane selector is "+lane_selector);

       if(car_x>=110-carHeight && car_x<=360)       //New change
       {

            if(car_y>50 && car_y<=110)
            {
                cary1=car_y;
                car_y= car_y+lane_selector;
                if(car_y>110 || car_y<50-carHeight)  //New Change
                {
                    setpositionup();
                }
            }


            else if(car_y>500 && car_y<=560)
            {
                cary1=car_y;
                car_y= car_y-lane_selector;
                if(car_y<500 || car_y>=560)
                {
                    setpositiondown();
                    System.out.println("Entering set down");
                }
            }


       }


       if(car_x>=50 && car_x<110)
       {
           carx1=car_x;
           car_x= car_x+lane_selector;
           if(car_x<50 || car_x>110 )
           {
               setpositionleft();
           }

       }


       if(car_x>360 && car_x<=420)
        {
            carx1=car_x;
            car_x= car_x+lane_selector;
            if(car_x<360 || car_x>420 )
            {
               setpositionright();
            }


        }



    }

    public void setpositiondown()
    {
        car_x=200;
        car_y=520;
    }

    public void setpositionup()
    {
        car_x=200;
        car_y=60;
    }

    public void setpositionleft()
    {
        car_x=50;
        car_y=250;
    }

    public void setpositionright()
    {
        car_x=200;
        car_y=250;
    }




}



/*

 public void setDisplay()
    {
        position.setText(mView.getX_dir()+","+mView.getY_dir());
        acceleration1.setText(accel_steps*2);
        steering_angle.setText(Double.toString(mCurrAngle));
        velocity.setText(accel_steps*20);
        double rpm1=(double)((accel_steps*20)/6.28);
        engine_rpm.setText(Double.toString(rpm1));
       // mph_time.setText();
        braking_distance.setText(brake_steps);

    }
 */