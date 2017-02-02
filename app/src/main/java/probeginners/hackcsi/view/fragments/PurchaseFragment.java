package probeginners.hackcsi.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import probeginners.hackcsi.Models.BooksVol;
import probeginners.hackcsi.Models.Items;
import probeginners.hackcsi.R;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PurchaseFragment extends Fragment {

    String API_KEY = "AIzaSyDsHdOSEaViNIqMuzrAeDISzDN9cVvZBe8";
    BooksVol bv;
    RecyclerView rv;


    public PurchaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_purchase, container, false);


        rv = (RecyclerView) v.findViewById(R.id.rv);

        getInfo();


        return v;
    }

    private void getInfo() {
        String myurl = "https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=" + API_KEY;
        //Log.d(TAG, "getTrainInfo: "+myurl);
        new loadUrlDataTask().execute(myurl);
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

                return new Holder(itemView);
            }

            @Override
            public void onBindViewHolder(final Holder holder, int position) {

                ArrayList<Items> items = bv.getItems();

                holder.tvAuthors.setText(items.get(position).getVolumeInfo().getAuthors().get(0));
                holder.tvDescription.setText(items.get(position).getVolumeInfo().getDescription());
                holder.tvPageCount.setText(String.valueOf(items.get(position).getVolumeInfo().getPageCount()));
               // holder.tvMRP.setText(items.get(position).getSaleInfo().getRetailPrice().getAmount().toString() + " INR");
                holder.tvCountry.setText(items.get(position).getAccessInfo().getCountry());
                holder.tvSaleability.setText(items.get(position).getSaleInfo().getSaleability());
                holder.tvTitle.setText(items.get(position).getVolumeInfo().getTitle());
               //holder.imgView.setImageURI(Uri.parse(items.get(position).getVolumeInfo().getImageLinks().getThumbnail()));
//                try {
//                    holder.imgView.setImageBitmap(BitmapFactory.decodeStream(new URL(items.get(position).getVolumeInfo().getImageLinks().getThumbnail()).openConnection().getInputStream()));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                holder.tvPublisher.setText(items.get(position).getVolumeInfo().getPublisher());

            }

            @Override
            public int getItemCount() {
                return bv.getItems().size();
            }
        }
    }
}
