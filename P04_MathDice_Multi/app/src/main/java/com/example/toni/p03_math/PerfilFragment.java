package com.example.toni.p03_math;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PerfilFragment extends Fragment {

    PerfilFragmentListener mCallback;

    // Container Activity must implement this interface
    public interface PerfilFragmentListener {
        public void onClick(View v);
    }


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (PerfilFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " debe implementar OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      return inflater.inflate(R.layout.activity_perfil, container, false);
    }

    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final EditText edit_nom = (EditText)getActivity().findViewById(R.id.edit_nom);
        final EditText edit_edad = (EditText)getActivity().findViewById(R.id.edit_edad);

        Button boton = (Button) getActivity().findViewById(R.id.bot_jugar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                intent.putExtra("nombre", edit_nom.getText().toString());
                intent.putExtra("edad", edit_edad.getText().toString());
                startActivity(intent);
                getActivity().finish();

                mCallback.onClick(v);


            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback=null;
    }

}
