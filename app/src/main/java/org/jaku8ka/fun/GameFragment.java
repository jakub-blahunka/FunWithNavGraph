package org.jaku8ka.fun;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    ConstraintLayout tapToStart;
    TextView tap;
    TextView hint;
    TextView redBall, blueBall;
    Boolean play = false;


    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tapToStart = view.findViewById(R.id.tap_to_start);
        tap = view.findViewById(R.id.tv_start);
        hint = view.findViewById(R.id.tap);
        redBall = view.findViewById(R.id.red_ball);
        blueBall = view.findViewById(R.id.blue_ball);

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.fadeout);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tap.startAnimation(animation);
        tapToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hint.setVisibility(View.GONE);
                tap.clearAnimation();
                tap.setVisibility(View.GONE);
                play = true;
            }
        });
        bounceBalls();
    }

    private void bounceBalls() {

        Animation animationRed = AnimationUtils.loadAnimation(getContext(), R.anim.red);
        animationRed.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        redBall.startAnimation(animationRed);

        Animation animationBlue = AnimationUtils.loadAnimation(getContext(), R.anim.blue);
        animationBlue.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        blueBall.startAnimation(animationBlue);

        redBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redBall.clearAnimation();
                redBall.setText("Tapped");
            }
        });

        blueBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueBall.clearAnimation();
                blueBall.setText("Tapped");
            }
        });
    }

}
