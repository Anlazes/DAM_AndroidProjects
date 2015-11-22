package com.example.toni.p03_math;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



public class StaticFragment extends Fragment {


    public StaticFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.lista_main, container, false);

    }

    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //se generan arrays de string e integer con los nombres y los iconos
        final String[] listaNombres = new String[]{"PERFIL", "JUGAR", "INSTRUCCIONES", "INFO"};
        final Integer[] listaIconos = new Integer[]{R.drawable.ic_face_black_24dp, R.drawable.ic_play_circle_outline_black_24dp,
                R.drawable.ic_library_books_black_24dp, R.drawable.ic_info_black_24dp};


        //creamos el adapter personalizado con los arrays creados
        CustomAdapter adapter = new CustomAdapter(this.getActivity(), listaNombres, listaIconos);
        ListView lista = (ListView) getActivity().findViewById(R.id.listview);
        lista.setAdapter(adapter);
    }
}
