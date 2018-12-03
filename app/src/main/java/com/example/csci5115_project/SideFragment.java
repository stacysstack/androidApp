package com.example.csci5115_project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SideFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_multiple_choice,
                getResources().getStringArray(R.array.sides));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        l.setSelection(position);
    }

//    @Override
//    public void onResume(){
//        ListView lv = getListView();
//        ArrayAdapter<String> adapter = lv.getAdapter();
//        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//
//        for()
//
//        super.onResume();
//    }
}
