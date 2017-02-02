package probeginners.hackcsi.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import probeginners.hackcsi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonateFragment extends Fragment {


    EditText b_name, b_author, b_mrp, b_year, y_name, y_address, y_phone;

    public DonateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_donate, container, false);

        b_name = (EditText) v.findViewById(R.id.b_name);
        b_author = (EditText) v.findViewById(R.id.b_author);
        b_mrp = (EditText) v.findViewById(R.id.b_mrp);
        b_year = (EditText) v.findViewById(R.id.b_year);
        y_name = (EditText) v.findViewById(R.id.y_name);
        y_address = (EditText) v.findViewById(R.id.y_address);
        y_phone = (EditText) v.findViewById(R.id.y_phone);

        return v;
    }

}
