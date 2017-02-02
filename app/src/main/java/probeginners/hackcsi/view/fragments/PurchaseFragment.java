package probeginners.hackcsi.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import probeginners.hackcsi.Models.BooksVol;
import probeginners.hackcsi.R;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PurchaseFragment extends Fragment {
    Button info;
    String API_KEY="AIzaSyDsHdOSEaViNIqMuzrAeDISzDN9cVvZBe8";


    public PurchaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_purchase, container, false);

        getInfo();


        return v;
    }

    private void getInfo() {
        String myurl = "https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key="+API_KEY;
        //Log.d(TAG, "getTrainInfo: "+myurl);
        new loadUrlDataTask().execute(myurl);
    }

    class loadUrlDataTask extends AsyncTask<String,Void,String> {

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
                while((str=br.readLine())!=null){
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

            BooksVol bv = gson.fromJson(list,BooksVol.class);
            Log.d(TAG, "onPostExecute: "+bv.getTotalItems());
            Log.d(TAG, "onPostExecute: "+bv.getItems().get(1).getVolumeInfo().getPageCount());
            //Log.d(TAG, "onPostExecute: "+bv.getItems().get(0).getAccessInfo().getWebReaderLink().toString());

        }
    }
}
