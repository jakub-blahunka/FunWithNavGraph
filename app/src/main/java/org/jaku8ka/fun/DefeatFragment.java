package org.jaku8ka.fun;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DefeatFragment extends Fragment {

    TextView tapToRetry;
    ConstraintLayout tap;


    public DefeatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_defeat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tapToRetry = view.findViewById(R.id.tap_to_retry_TV);
        tap = view.findViewById(R.id.tap_to_retry);

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
        tapToRetry.startAnimation(animation);

        tap.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_DefeatFragment_to_GameFragment));
    }
}
