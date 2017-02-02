package probeginners.hackcsi.view.fragments;


import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import classes.PurchaseInfo;
import probeginners.hackcsi.Constants;
import probeginners.hackcsi.Models.BooksVol;
import probeginners.hackcsi.Models.Items;
import probeginners.hackcsi.NavActivity;
import probeginners.hackcsi.R;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PurchaseFragment extends Fragment implements View.OnClickListener{

    String API_KEY = "AIzaSyDsHdOSEaViNIqMuzrAeDISzDN9cVvZBe8";
    BooksVol bv;
    RecyclerView rv;
    Firebase f;
    String name,author,mrp;
    EditText search;
    Button btnSearch;
    ArrayList<Items> items;

    public PurchaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_purchase, container, false);
        search = (EditText) v.findViewById(R.id.search);
        btnSearch = (Button) v.findViewById(R.id.btnsearch);

        Constants.fun();
        f = new Firebase(Constants.purchase);

        rv = (RecyclerView) v.findViewById(R.id.rv);

            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (search.getText() != null) {
                        getInfo(search.getText().toString());
                        // Setting Dialog Title

                    }

                }

            });




        return v;
    }

    private void getInfo(String cat) {
        String myurl = "https://www.googleapis.com/books/v1/volumes?q="+cat+"&key=" + API_KEY;
        //flowers+inauthor:keyes
        //Log.d(TAG, "getTrainInfo: "+myurl);
        new loadUrlDataTask().execute(myurl);
    }

    @Override
    public void onClick(View view) {
        Log.e("abcd","ff");
        int itemPosition = rv.getChildLayoutPosition(view);
        name=items.get(itemPosition).getVolumeInfo().getTitle();
        author=items.get(itemPosition).getVolumeInfo().getAuthors().get(0);
        mrp=String.valueOf(400);
       int points=Integer.valueOf(mrp);
        int p = Integer.valueOf(points);
        if (p < NavActivity.points)
            Toast.makeText(getContext(), "You dont have sufficient points", Toast.LENGTH_SHORT).show();
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

        name=((TextView)rv.findViewById(R.id.b_name)).getText().toString();
        author=((TextView)rv.findViewById(R.id.b_author)).getText().toString();
        mrp=((TextView)rv.findViewById(R.id.b_mrp)).getText().toString();
        alertDialog.setTitle("Confirm Purchase");

        // Setting Dialog Message
        alertDialog.setMessage("Click Ok to purchase the book?");

        // Setting Icon to Dialog


        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                // Write your code here to invoke YES event
                Toast.makeText(getContext().getApplicationContext(), "Purchased", Toast.LENGTH_SHORT).show();
                f.push().setValue(new PurchaseInfo(name,author,mrp));
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,	int which) {
                // Write your code here to invoke NO event
                    /*Toast.makeText(getContext().getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                    dialog.cancel();*/
            }
        });

        // Showing Alert Message
        alertDialog.show();


    }

    class loadUrlDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection httpURLConnection = null;

            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                httpURLConnection = (HttpURLConnection) url.openConnection();

            } catch (IOException e) {
                e.printStackTrace();

            }


            try {
                InputStreamReader ir = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader br = new BufferedReader(ir);
                StringBuilder sb = new StringBuilder();
                String str = null;
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
                return sb.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String list) {
            super.onPostExecute(list);

            final Gson gson = new Gson();

            bv = gson.fromJson(list, BooksVol.class);

            int listsize = bv.getItems().size();
            for (int i = 0; i < listsize; i++) {

            }
            Log.d(TAG, "onPostExecute: " + bv.getTotalItems());
            Log.d(TAG, "onPostExecute: " + bv.getItems().get(1).getVolumeInfo().getPageCount());
           // Log.d(TAG, "onPostExecute: "+bv.getItems().get(0).getSaleInfo().getRetailPrice().getAmount());
            Log.d(TAG, "onPostExecute: "+bv.getItems().get(3).getVolumeInfo().getImageLinks().getThumbnail());

            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            Adapter adapter = new Adapter();

            rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }

        class Holder extends RecyclerView.ViewHolder {

            ImageView imgView;
            TextView tvTitle, tvDescription, tvAuthors, tvPageCount, tvGenres, tvSaleability, tvMRP, tvCountry, tvPublisher;

            public Holder(View v) {
                super(v);
                imgView = (ImageView) v.findViewById(R.id.imgView1);
                tvTitle = (TextView) v.findViewById(R.id.title1);
                tvDescription = (TextView) v.findViewById(R.id.description);
                tvAuthors = (TextView) v.findViewById(R.id.author);
                tvPageCount = (TextView) v.findViewById(R.id.pageCount);
                tvGenres = (TextView) v.findViewById(R.id.genres);
                tvSaleability = (TextView) v.findViewById(R.id.saleability);
                tvMRP = (TextView) v.findViewById(R.id.mrp);
                tvCountry = (TextView) v.findViewById(R.id.country);
                tvPublisher = (TextView) v.findViewById(R.id.publisher);
            }
        }

        class Adapter extends RecyclerView.Adapter<Holder> {

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater li = getActivity().getLayoutInflater();
                View itemView = li.inflate(R.layout.recycler_layout, parent, false);
                itemView.setOnClickListener(PurchaseFragment.this);
                return new Holder(itemView);
            }

            @Override
            public void onBindViewHolder(final Holder holder, int position) {

                 items = bv.getItems();

                if(items.get(position).getVolumeInfo().getAuthors()!=null){
                    holder.tvAuthors.setText(items.get(position).getVolumeInfo().getAuthors().get(0));
                }else
                holder.tvDescription.setText(items.get(position).getVolumeInfo().getDescription());
                holder.tvPageCount.setText(String.valueOf(items.get(position).getVolumeInfo().getPageCount()));
                if(items.get(position).getSaleInfo().getSaleability()=="FOR_SALE"){
                holder.tvMRP.setText(String.valueOf(items.get(position).getSaleInfo().getRetailPrice().getAmount()) + " INR");
                }
                holder.tvCountry.setText(items.get(position).getAccessInfo().getCountry());
                holder.tvSaleability.setText(items.get(position).getSaleInfo().getSaleability());
                holder.tvTitle.setText(items.get(position).getVolumeInfo().getTitle());

                String url;
                if(items.get(position).getVolumeInfo().getImageLinks().getThumbnail()==null){
                    url = "https://d13yacurqjgara.cloudfront.net/users/39185/screenshots/3259335/rabbit_1x.jpg";
                }else{
                    url = items.get(position).getVolumeInfo().getImageLinks().getThumbnail();
                }
                Glide.with(getActivity()).load(url).centerCrop().into(holder.imgView);
                holder.tvPublisher.setText(items.get(position).getVolumeInfo().getPublisher());
                if(items.get(position).getVolumeInfo().getCategories()!=null) {
                    holder.tvGenres.setText(items.get(position).getVolumeInfo().getCategories().get(0));
                }else{

                }

            }

            @Override
            public int getItemCount() {
                return bv.getItems().size();
            }
        }
    }
    double getPoints(double mrp){
        return (1.0)*mrp/10;
    }
}
