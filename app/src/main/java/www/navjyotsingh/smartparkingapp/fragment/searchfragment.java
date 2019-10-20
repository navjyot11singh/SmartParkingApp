package www.navjyotsingh.smartparkingapp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.navjyotsingh.smartparkingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchfragment extends Fragment {


    public searchfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchfragment, container, false);
    }

}
