package app.android.example.com.nutri_potum40;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager = null;

    private final static int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        createButtonMethod();
        recordsButtonMethod();
        settingsButtonMethod();

        viewPager = (ViewPager) getWindow().getDecorView().findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }

    @Override
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

    public void createButtonMethod()
    {
        setContentView(R.layout.button_page);
        Button createButton = (Button) findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DrinkAmountActivity.class));
            }
        });
    }

    public void recordsButtonMethod()
    {
        setContentView(R.layout.button_page);
        Button createButton = (Button) findViewById(R.id.recordsButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecordsActivity.class));
            }
        });
    }

    public void settingsButtonMethod()
    {
        setContentView(R.layout.button_page);
        Button createButton = (Button) findViewById(R.id.settingsButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    public void syncButtonMethod(View view)
    {
        setContentView(R.layout.button_page);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(mBluetoothAdapter == null)
        {
            Toast.makeText(MainActivity.this, "Your phone does not support bluetooth.", Toast.LENGTH_SHORT).show();
        }

        if (!mBluetoothAdapter.isEnabled()) {

            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

}



class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;

        if (i == 0)
        {
            fragment = new ButtonPageActivity();
        }
        if (i == 1)
        {
            fragment = new DrinkAmountActivity();
        }
        if (i == 2)
        {
            fragment = new CarbohydrateActivity();
        }
        if (i == 3)
        {
            fragment = new FatActivity();
        }
        if (i == 4)
        {
            fragment = new FiberActivity();
        }
        if (i == 5)
        {
            fragment = new MultivitaminActivity();
        }
        if (i == 6)
        {
            fragment = new PotassiumActivity();
        }
        if (i == 7)
        {
            fragment = new CalciumActivity();
        }
        if (i == 8)
        {
            fragment = new FlavoringActivity();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 9;
    }
}