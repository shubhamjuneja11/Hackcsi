package probeginners.hackcsi;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import probeginners.hackcsi.view.fragments.DoneDonateFragment;
import probeginners.hackcsi.view.fragments.DonePurchasedFragment;
import probeginners.hackcsi.view.fragments.PendingDonateFragment;
import probeginners.hackcsi.view.fragments.PendingPurchasedFragment;

public class DonatedActivity extends AppCompatActivity {



    private TabLayout tabLayout;
    private ViewPager viewPager;
    EditText b_name, b_author, b_mrp, b_year, y_name, y_address, y_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donated);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        b_name = (EditText) findViewById(R.id.b_name);
        b_author = (EditText) findViewById(R.id.b_author);
        b_mrp = (EditText) findViewById(R.id.b_mrp);
        b_year = (EditText) findViewById(R.id.b_year);
        y_name = (EditText) findViewById(R.id.y_name);
        y_address = (EditText) findViewById(R.id.y_address);
        y_phone = (EditText) findViewById(R.id.y_phone);
    }




    private void setupViewPager(ViewPager viewPager) {
        DonatedActivity.ViewPagerAdapter adapter = new DonatedActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new PendingDonateFragment(), "PENDING");
        adapter.addFrag(new DoneDonateFragment(), "DONE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
