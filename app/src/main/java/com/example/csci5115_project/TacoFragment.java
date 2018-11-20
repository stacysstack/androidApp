package com.example.csci5115_project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TacoFragment extends ListFragment {

    private ListView lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_multiple_choice,
                getResources().getStringArray(R.array.tacos));
        setListAdapter(adapter);
//        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        l.setSelection(position);
    }

}
