package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.PendingIntent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    View view1,view2,view3;
    Random ran=new Random();
    public  static final String TAG ="ASYNC";
    private int position=0;
    ImageView img[]=new ImageView[4];
    View view[]=new View[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img[0]=findViewById(R.id.Picked);
        img[1]=findViewById(R.id.Onway);
        img[2]=findViewById(R.id.Delievered);
        img[3]=findViewById(R.id.Done);
        view[0]=findViewById(R.id.view1);
        view[1]=findViewById(R.id.view2);
        view[2]=findViewById(R.id.view3);
        Count c=new Count();
        c.execute(4);
    }
    class Count extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG,"doInBackground : started");
            int n=integers[0];
            for(int i=0;i<n;i++)
            {
                // wait1sec();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            Log.d(TAG,"doInBackground : ended");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d(TAG, String.valueOf(img[position]));
            img[position].setBackgroundResource(R.drawable.cooking);
            if(position<3) {
                view[position].setBackgroundColor(Color.rgb(171, 71, 188));
            }
            position++;
        }

    }
}
