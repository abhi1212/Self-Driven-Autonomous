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


    private Rect mRectSquare1;

    private Rect mRectSquare2;

    private Rect mRectSquare4;

    private Rect mRectSquare5;

    private Rect mRectSquare7;


    private Paint mPaintSquare1;

    private Paint mPaintSquare2;

    private Paint mPaintSquare4;

    private Paint mPaintSquare5;

    private Paint mPaintSquare7;



    Bitmap car_bm;

    Bitmap car_bm1;

    //bitmaps for blue car below

    Bitmap car2_bm;

    Bitmap car2_bm1;

    //bitmaps for yellow car below

    Bitmap car3_bm;

    Bitmap car3_bm1;

    //bitmaps for green car below

    Bitmap car4_bm;

    Bitmap car4_bm1;

    int car_x, car_y;

    int car2_x, car2_y;

    int car3_x, car3_y;

    int car4_x, car4_y;

    int x_dir, y_dir;

    int carHeight, carWidth;    //Car_height is 10 and car_width is 5.

    int carHeight1, carWidth1;    //Car_height is 10 and car_width is 5.

    int carHeight2, carWidth2;    //Car_height is 10 and car_width is 5.

    int carHeight3, carWidth3;    //Car_height is 10 and car_width is 5.

    Button btnAnimation;

    private Views mView;

    Matrix matrix = new Matrix();



    public Views(Context context) {
        super(context);


        init(null); //called from all the constructors

        car3_x = 65; //our locations updated
        car3_y = 465;
        car2_x = 36;
        car2_y = 440;
        car_x = 98;
        car_y = 488;
        car4_x = 8;
        car4_y = 420;
        x_dir = 1; //speed in which coordinates are changed
        y_dir = 1;
    }

    public Views(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        init(attrs);

        car3_x = 65; //our locations updated
        car3_y = 465;
        car2_x = 36;
        car2_y = 440;
        car_x = 98;
        car_y = 488;
        car4_x = 8;
        car4_y = 420;
        x_dir = 1; //speed in which coordinates are changed
        y_dir = 1;
    }

    public Views(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);

        car3_x = 65; //our locations updated
        car3_y = 465;
        car2_x = 36;
        car2_y = 440;
        car_x = 98;
        car_y = 488;
        car4_x = 8;
        car4_y = 420;
        x_dir = 1; //speed in which coordinates are changed
        y_dir = 1;
    }

    @SuppressLint("NewApi")
    public Views(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

        car3_x = 65; //our locations updated
        car3_y = 465;
        car2_x = 36;
        car2_y = 440;
        car_x = 98;
        car_y = 488;
        car4_x = 8;
        car4_y = 420;
        x_dir = 1; //speed in which coordinates are changed
        y_dir = 1;
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

    public void setCar2_x(int car2_x) {
        this.car2_x = car2_x;
    }

    public void setCar2_y(int car2_y) {
        this.car2_y = car2_y;
    }

    public void setCar3_x(int car3_x) {
        this.car3_x = car3_x;
    }

    public void setCar3_y(int car3_y) {
        this.car3_y = car3_y;
    }

    public void setCar4_x(int car4_x) {
        this.car4_x = car4_x;
    }

    public void setCar4_y(int car4_y) {
        this.car4_y = car4_y;
    }

    private void init(@Nullable AttributeSet set) {

        mRectSquare2 = new Rect();
        mPaintSquare2 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mRectSquare1 = new Rect();
        mPaintSquare1 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mRectSquare4 = new Rect();
        mPaintSquare4 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mRectSquare5 = new Rect();
        mPaintSquare5 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mRectSquare7 = new Rect();
        mPaintSquare7 = new Paint(Paint.ANTI_ALIAS_FLAG);


    }

    protected void onDraw(Canvas canvas) {

        //Object rect used for the setup position and size for our square

        //below are coordinate points for corners of the black square

        // System.out.println("Car Height and Car width is "+carHeight+" "+ carWidth);

        //Outermost lane below
        mRectSquare2.left = 0; //x = 0
        mRectSquare2.top = 0; //y = 0
        mRectSquare2.right = 470; //x = 470
        mRectSquare2.bottom =610; //y = 610

        //Second Outermost lane below
        mRectSquare5.left = 30; //x = 30
        mRectSquare5.top = 30; //y = 30
        mRectSquare5.right = 440; //x = 440
        mRectSquare5.bottom = 580; //y = 580

        //third outermost lane (gray color) below
        mRectSquare7.left = 60; // x = 60
        mRectSquare7.top = 60; // y = 60
        mRectSquare7.right = 410; // x = 410
        mRectSquare7.bottom = 550; // y = 550

        //below are coordinate points for corners of the green square

        mRectSquare1.left = 120; // x = 120
        mRectSquare1.top = 120; // y = 120
        mRectSquare1.right = 350; // x = 350
        mRectSquare1.bottom = 490; //  y = 490

        //inner lane below

        mRectSquare4.left = 90; // x = 90
        mRectSquare4.top = 90; // y = 90
        mRectSquare4.right = 380; // x = 380
        mRectSquare4.bottom = 520; //  y = 520

        mPaintSquare2.setColor(Color.BLACK);

        mPaintSquare7.setColor(Color.BLACK);

        mPaintSquare1.setColor(Color.GREEN);

        mPaintSquare4.setColor(Color.GRAY);

        mPaintSquare5.setColor(Color.GRAY);


        canvas.drawRect(mRectSquare2, mPaintSquare2);

        canvas.drawRect(mRectSquare5, mPaintSquare5);

        canvas.drawRect(mRectSquare7, mPaintSquare7);

        canvas.drawRect(mRectSquare4, mPaintSquare4);

        canvas.drawRect(mRectSquare1, mPaintSquare1);


        car_bm = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        car_bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.car);

        car2_bm = BitmapFactory.decodeResource(getResources(), R.drawable.car2);
        car2_bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.car2);

        car3_bm = BitmapFactory.decodeResource(getResources(), R.drawable.car3);
        car3_bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.car3);

        car4_bm = BitmapFactory.decodeResource(getResources(), R.drawable.car4);
        car4_bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.car4);

        BitmapFactory.Options option = new BitmapFactory.Options(); //how dimensions of image is found
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.car, option);
        carHeight = option.outHeight;
        carWidth = option.outWidth;

        BitmapFactory.Options option1 = new BitmapFactory.Options(); //how dimensions of image is found
        option1.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.car2, option1);
        carHeight1 = option1.outHeight;
        carWidth1 = option1.outWidth;

        BitmapFactory.Options option2 = new BitmapFactory.Options(); //how dimensions of image is found
        option2.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.car3, option2);
        carHeight2 = option2.outHeight;
        carWidth2 = option2.outWidth;

        BitmapFactory.Options option3 = new BitmapFactory.Options(); //how dimensions of image is found
        option3.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.car4, option1);
        carHeight3 = option1.outHeight;
        carWidth3 = option1.outWidth;


        canvas.drawBitmap(car2_bm, car2_x, car2_y, null);
        canvas.drawBitmap(car3_bm, car3_x, car3_y, null);
        canvas.drawBitmap(car4_bm, car4_x, car4_y, null);

//        ImageView img1 = (ImageView)findViewById(R.drawable.car);
//        matrix.postRotate(-90);
//        Bitmap rotatedBitmap = Bitmap.createBitmap(car_bm, 0, 0, carWidth, carHeight, matrix, true );


        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        Bitmap bmpBowRotated = Bitmap.createBitmap(car_bm, 0, 0, car_bm.getWidth(), car_bm.getHeight(), matrix, false);

        Matrix matrix3 = new Matrix();
        matrix3.postRotate(90);
        Bitmap bmpBowRotated3 = Bitmap.createBitmap(car3_bm, 0, 0, car3_bm.getWidth(), car3_bm.getHeight(), matrix3, false);


        //code below shows car moving from 1st to 2nd lane, and staying in 2nd lane
        //Condition for Lane 1.

        if(car_x>=90 && car_x<=115-carHeight) //
        {


            if(car_y<(115-carHeight) && car_y>=90) // Rotate right
            {
                canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
                car_x = car_x + x_dir;

            }

            else if(car_y>=(115-carHeight) && car_y<490+carHeight) //Go Up more to take a right
            {
                canvas.drawBitmap(car_bm, car_x, car_y, null);
                car_y = car_y - y_dir;

            }

            else if(car_y>=490+carHeight && car_y<=520)            //Upper left //commented
            {

                canvas.drawBitmap(car_bm, car_x, car_y, null);
                car_y = car_y - y_dir;

            }

        }




        if(car_x>115-carHeight && car_x<=(350))          //Upper right lane
        {
            if(car_y<=120 && car_y>=90) {      //Use + also carheight if needed

                canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
                car_x = car_x + x_dir;
            }
            else if (car_y>=490+carHeight && car_y<=520)
            {
                canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
                car_x = car_x - x_dir;

            }

        }


        if(car_x>=350 && car_x<=380)            //Going Down use  car height if u need to go moe right
        {
            if(car_y<=120 && car_y>=90) {

                canvas.drawBitmap(car_bm, car_x, car_y, null);
                car_y = car_y + y_dir;
            }

            else if(car_y>=120 && car_y<490+carHeight)
            {
                canvas.drawBitmap(car_bm, car_x, car_y, null);
                car_y = car_y + y_dir;

            }


            else if(car_y>=490 && car_y<520)
            {
                canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
                car_x = car_x - x_dir;

            }
        }



        //Lane 2


        // Left Lane


        if(car3_x>=60 && car3_x<=85-carHeight) //
        {


            if(car3_y<(85-carHeight) && car3_y>=60) // Rotate right
            {
                canvas.drawBitmap(bmpBowRotated3, car3_x, car3_y, null);
                car3_x = car3_x + x_dir;

            }

            else if(car3_y>=(85-carHeight) && car3_y<520+carHeight) //Go Up more to take a right
            {
                canvas.drawBitmap(car3_bm, car3_x, car3_y, null);
                car3_y = car3_y - y_dir;

            }

            else if(car3_y>=520+carHeight && car3_y<=550)            //Upper left //commented
            {

                canvas.drawBitmap(car3_bm, car3_x, car3_y, null);
                car3_y = car3_y - y_dir;

            }

        }


        //middle lane

        if(car3_x>85-carHeight && car3_x<(380))          //Upper right lane
        {
            if(car3_y<=90 && car3_y>=60) {      //Use + also carheight if needed

                canvas.drawBitmap(bmpBowRotated3, car3_x, car3_y, null);
                car3_x = car3_x + x_dir;
            }
            else if (car3_y>=520+carHeight && car3_y<=550)
            {
                canvas.drawBitmap(bmpBowRotated3, car3_x, car3_y, null);
                car3_x = car3_x - x_dir;

            }

        }


        if(car3_x>=380 && car3_x<=410)            //Going Down use  car height if u need to go moe right
        {
            if(car3_y<=90 && car3_y>=60) {

                canvas.drawBitmap(car3_bm, car3_x, car3_y, null);
                car3_y = car3_y + y_dir;
            }

            else if(car3_y>=90 && car3_y<520+carHeight)
            {
                canvas.drawBitmap(car3_bm, car3_x, car3_y, null);
                car3_y = car3_y + y_dir;

            }


            else if(car3_y>=520 && car3_y<550)
            {
                canvas.drawBitmap(bmpBowRotated3, car3_x, car3_y, null);
                car3_x = car3_x - x_dir;

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