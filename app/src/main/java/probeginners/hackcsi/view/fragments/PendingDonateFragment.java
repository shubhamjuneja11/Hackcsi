package probeginners.hackcsi.view.fragments;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.Firebase;

import classes.DonateBookInfo;
import probeginners.hackcsi.Constants;
import probeginners.hackcsi.Models.Completedonateadapter;
import probeginners.hackcsi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingDonateFragment extends Fragment {
Completedonateadapter<DonateBookInfo> adapter;
ListView listView;
    Firebase f;
    public PendingDonateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Constants.fun();
        f=new Firebase(Constants.requests);
        View view= inflater.inflate(R.layout.fragment_pending_donate, container, false);
        listView=(ListView)view.findViewById(R.id.pendinglist);
        adapter=new Completedonateadapter<>(f.limit(50), DonateBookInfo.class,R.layout.row_layout ,getActivity());
        listView.setAdapter(adapter);
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(adapter.getCount() - 1);
                Log.e("key","123456   "+adapter.getCount());

            }
        });
        return view;
    }

}
