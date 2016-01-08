package com.example.toni.p03_math;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;



public class StaticFragment extends Fragment {

    StaticFragmentListener mCallback;

    // Container Activity must implement this interface
    public interface StaticFragmentListener {
        public void onListSelected(int position);
    }


    public StaticFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (StaticFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " debe implementar OnHeadlineSelectedListener");
        }
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
        String[] listaNombres = new String[]{"PERFIL", "JUGAR", "INSTRUCCIONES", "INFO"};
        Integer[] listaIconos = new Integer[]{R.drawable.ic_face_black_24dp, R.drawable.ic_play_circle_outline_black_24dp,
                R.drawable.ic_library_books_black_24dp, R.drawable.ic_info_black_24dp};

        //creamos el adapter personalizado con los arrays creados
        CustomAdapter adapter = new CustomAdapter(getActivity(), listaNombres, listaIconos);
        ListView lista = (ListView) getActivity().findViewById(R.id.listview);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new customListener());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback=null;
    }

    private class customListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onListSelected(position);
        }
    }
}
