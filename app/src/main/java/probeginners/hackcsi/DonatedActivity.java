package probeginners.hackcsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DonatedActivity extends AppCompatActivity {


    EditText b_name, b_author, b_mrp, b_year, y_name, y_address, y_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donated);

        b_name = (EditText) findViewById(R.id.b_name);
        b_author = (EditText) findViewById(R.id.b_author);
        b_mrp = (EditText) findViewById(R.id.b_mrp);
        b_year = (EditText) findViewById(R.id.b_year);
        y_name = (EditText) findViewById(R.id.y_name);
        y_address = (EditText) findViewById(R.id.y_address);
        y_phone = (EditText) findViewById(R.id.y_phone);
    }
}
