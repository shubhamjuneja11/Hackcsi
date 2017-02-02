package probeginners.hackcsi.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import classes.DonateBookInfo;
import probeginners.hackcsi.Constants;
import probeginners.hackcsi.Models.DoneDonateAdapter;
import probeginners.hackcsi.R;


public class DonateFragment extends Fragment {
    DonateBookInfo data;
    Firebase firebase;
    EditText b_name, b_author, b_mrp, b_year, y_name, y_address, y_phone;
    Button button;
    Firebase f;
    public DonateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Constants.fun();
        // Inflate the layout for this fragment
        f=new Firebase(Constants.requests);
        View v = inflater.inflate(R.layout.fragment_donate, container, false);


        button=(Button)v.findViewById(R.id.button);
        firebase = new Firebase(Constants.requests);
        b_name = (EditText) v.findViewById(R.id.b_name);
        b_author = (EditText) v.findViewById(R.id.b_author);
        b_mrp = (EditText) v.findViewById(R.id.b_mrp);
        b_year = (EditText) v.findViewById(R.id.b_year);
        y_name = (EditText) v.findViewById(R.id.y_name);
        y_address = (EditText) v.findViewById(R.id.y_address);
        y_phone = (EditText) v.findViewById(R.id.y_phone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donate(view);
            }
        });

        return v;
    }

    public void donate(View view) {
        data = new DonateBookInfo(getstring(b_year), getstring(b_name), getstring(b_author), getstring(y_address),
                getstring(b_name), getstring(y_phone), getstring(b_mrp),"PENDING");
        firebase.push().setValue(data);

        Toast.makeText(getContext(), "Submitted successfully", Toast.LENGTH_SHORT).show();


    }

    public String getstring(EditText s) {
        return s.getText().toString();
    }
}

