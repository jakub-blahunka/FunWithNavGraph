package org.jaku8ka.fun;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button leaderBoard, newGame, profile;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leaderBoard = view.findViewById(R.id.leaderboard_btn);
        newGame = view.findViewById(R.id.newgame_btn);
        profile = view.findViewById(R.id.profile_btn);
        leaderBoard.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_HomeFragment_to_LeaderBoardFragment));
        newGame.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_HomeFragment_to_GameFragment));
    }
}
