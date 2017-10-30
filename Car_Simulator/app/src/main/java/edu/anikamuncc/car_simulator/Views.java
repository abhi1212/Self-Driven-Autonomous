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
import android.view.View;
import android.widget.Button;

import static edu.anikamuncc.car_simulator.MainActivity.decide;

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

    int carHeight, carWidth;

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
        x_dir = 8;
        y_dir = 8;
    }

    public Views(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);

        car_x = 50; //our locations updated
        car_y = 500;
        x_dir = 8;
        y_dir = 8;
    }

    @SuppressLint("NewApi")
    public Views(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

        car_x = 50; //our locations updated
        car_y = 500;
        x_dir = 8;
        y_dir = 8;
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

        mRectSquare2.left = 0;
        mRectSquare2.top = 0;
        mRectSquare2.right = 470 + mRectSquare2.left;
        mRectSquare2.bottom = mRectSquare2.top + 610;

        mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = 380 + mRectSquare.left;
        mRectSquare.bottom = mRectSquare.top + 510;

        mRectSquare1.left = 110;
        mRectSquare1.top = 110;
        mRectSquare1.right = 330 + mRectSquare.left;
        mRectSquare1.bottom = mRectSquare.top + 470;

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


        if (car_x <= 50) {

            canvas.drawBitmap(car_bm, car_x, car_y, null);
            car_y = car_y - y_dir;

        }

        if (car_y <= 50) {

            canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
            car_x = car_x + x_dir;

        }

        if (car_x >= 450-(carHeight+24)) {

            canvas.drawBitmap(car_bm, car_x, car_y, null);
            car_y = car_y + y_dir;
        }


        if (car_y >= 600-(carWidth+50)) {

            canvas.drawBitmap(bmpBowRotated, car_x, car_y, null);
            car_x = car_x - x_dir;
        }

        if(decide==0) {
            invalidate(); //allows us to draw the Bitmap map again and again
            //clears everything is done in this method at the very end, Android then repeats itself
            //the x and y coordinates remember there values so they can be incremented
        }
    }




    public  void inval()
    {
         invalidate();

    }


}




