package com.example.gazprom;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Fr_NoticeIdea extends Fragment {

    private GestureDetectorCompat SwipeDetector;

    RelativeLayout notice_layout;
    ImageView noticeImage;

    private static final int SWIPE_MIN_DISTANCE = 130;
    private static final int SWIPE_MAX_DISTANCE = 300;
    private static final int SWIPE_MIN_VELOCITY = 200;

    int iterator = 1;
    int[] pictures = {R.drawable.test_notice_1, R.drawable.test_notice_2,
        R.drawable.test_notice_3, R.drawable.test_notice_4};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.noticeidea_fr, container, false);

        SwipeDetector = new GestureDetectorCompat(getActivity(), new MyGestureListener());

        notice_layout = v.findViewById(R.id.notice_layout);
        noticeImage = v.findViewById(R.id.notice_image);

        notice_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return SwipeDetector.onTouchEvent(event);
            }
        });

        return v;
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)
                return false;
            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                iterator = (iterator + 1) % pictures.length;
                noticeImage.setImageResource(pictures[iterator]);
            }
            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                iterator = (iterator + 1) % pictures.length;
                noticeImage.setImageResource(pictures[iterator]);
            }
                return false;
        }
    }
}
