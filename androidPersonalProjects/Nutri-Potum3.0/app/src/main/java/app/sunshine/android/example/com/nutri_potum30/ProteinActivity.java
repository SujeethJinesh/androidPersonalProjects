package app.sunshine.android.example.com.nutri_potum30;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class ProteinActivity extends FragmentActivity {

    ViewPager viewPager = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.protein_activity);

        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;

      /*  if (i == 0)
        {
            fragment = new DrinkAmountActivity();
        } */
        if (i == 1)
        {
            fragment = new CarbohydrateActivity();
        }
        if (i == 2)
        {
            fragment = new FatActivity();
        }
        if (i == 3)
        {
            fragment = new FiberActivity();
        }
        if (i == 4)
        {
            fragment = new MultivitaminActivity();
        }
        if (i == 5)
        {
            fragment = new PotassiumActivity();
        }
        if (i == 6)
        {
            fragment = new CalciumActivity();
        }
        if (i == 7)
        {
            fragment = new FlavoringActivity();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
