package probeginners.hackcsi.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import probeginners.hackcsi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonePurchasedFragment extends Fragment {


    public DonePurchasedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_done_purchased, container, false);
    }

}