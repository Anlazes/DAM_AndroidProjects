package com.example.toni.p03_math;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class JuegoFragment extends Fragment {

    MediaPlayer mediaPlayer;


    public JuegoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //mediaPlayer.create(getActivity().getApplicationContext(), R.raw.hyperfun);
        //mediaPlayer.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_juego, container, false);


    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
