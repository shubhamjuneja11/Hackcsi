package probeginners.hackcsi.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import probeginners.hackcsi.DonatedActivity;
import probeginners.hackcsi.PurchasedActivity;
import probeginners.hackcsi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DPFragment extends Fragment {

    Button DONATED, PURCHASE;

    public DPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_d, container, false);

        DONATED = (Button) v.findViewById(R.id.DONATED);
        PURCHASE = (Button) v.findViewById(R.id.PURCHASE);

        DONATED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DonatedActivity.class);
                getActivity().startActivity(i);
            }
        });

        PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PurchasedActivity.class);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}
