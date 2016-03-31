package com.opro.ken.animation_drawable;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    private ImageView m_img_duke;
    private AnimationDrawable m_fram_animation;
    private TextView m_time_tv1;
    private Button m_btn_start_stop;
    private Handler m_handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initanimation();

    }

    private void initview() {
        m_img_duke = (ImageView)findViewById(R.id.animation_duke);
        m_time_tv1 = (TextView)findViewById(R.id.time_tv1);
    }

    private void initanimation() {
        m_img_duke.setBackgroundResource(R.drawable.animation_drawable);
        m_fram_animation=(AnimationDrawable)m_img_duke.getBackground();

    }

    public void click(View view){
    switch (view.getId()){
        case R.id.btn_Start:
            m_fram_animation.start();
            break;
        case R.id.btn_Stop:
            m_fram_animation.stop();
            break;
        case R.id.btn_5Sec:
            animation5Sec();
        break;

    }
    }

    public void animation5Sec(){
        int delaymillis = 5 * 1000;
        Runnable task = new Task();
        boolean result = m_handler.postDelayed(task,delaymillis);

        m_time_tv1.setText(result?"交付成功":"交付失敗");
        m_fram_animation.start();
    }
    private class Task implements Runnable {
        @Override
        public void run(){
            m_fram_animation.stop();
            m_time_tv1.setText("時間到");
        }
    }
}
