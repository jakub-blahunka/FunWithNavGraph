package org.jaku8ka.fun;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    ConstraintLayout tapToStart;
    TextView tap;
    TextView hint;
    TextView redBall, blueBall;
    Boolean red = false, blue = false;
    LinearLayout tappable;
    int countTaps = 0;


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
        tappable = view.findViewById(R.id.tappable);

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
                tapToStart.setClickable(false);
                tappable.setVisibility(View.VISIBLE);
                bounceBalls();
            }
        });

        tappable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTaps++;
                if(countTaps == 11){
                    Navigation.findNavController(view).navigate(R.id.action_GameFragment_to_DefeatFragment);
                }
            }
        });

    }

    private void bounceBalls() {

            Path pathBlue = new Path();
            pathBlue.arcTo(20f, 50f, 900f, 800f, 270f, -250f, true);

            final ObjectAnimator animationBlue = ObjectAnimator.ofFloat(blueBall, blueBall.X, blueBall.Y, pathBlue);
            animationBlue.setDuration(500);
            animationBlue.setRepeatCount(ValueAnimator.INFINITE);
            animationBlue.setRepeatMode(ValueAnimator.REVERSE);
            animationBlue.start();

            blueBall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animationBlue.cancel();
                    blueBall.setText("Tapped");
                    blue = true;
                    if(red && blue) {
                        Navigation.findNavController(view).navigate(R.id.action_GameFragment_to_WinFragment);
                    }
                }
            });

            Path pathRed = new Path();
            pathRed.arcTo(20f, 50f, 1600f, 1550f, -270f, 180f, true);

            final ObjectAnimator animationRed = ObjectAnimator.ofFloat(redBall, redBall.X, redBall.Y, pathRed);
            animationRed.setDuration(1000);
            animationRed.setRepeatCount(ValueAnimator.INFINITE);
            animationRed.setRepeatMode(ValueAnimator.REVERSE);
            animationRed.start();

            redBall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animationRed.cancel();
                    redBall.setText("Tapped");
                    red = true;
                    if(red && blue) {
                        Navigation.findNavController(view).navigate(R.id.action_GameFragment_to_WinFragment);
                    }
                }
            });
        }
}
