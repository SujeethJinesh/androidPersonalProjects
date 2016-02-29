package app.android.example.com.nutri_potum40;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by lab on 1/12/2016.
 */
public class DrinkAmountActivity extends Fragment {

    private static SeekBar drinkAmountSlider;
    private static TextView drinkAmountSliderText;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.drink_amount_layout, container, false);

        //drinkAmountSliderStart();

        return view;
    }

    public void drinkAmountSliderStart()
    {

//        drinkAmountSlider = (SeekBar) getView().findViewById(R.id.drinkAmountSlider);
//        drinkAmountSliderText = (TextView) getView().findViewById(R.id.drinkAmountText);

        drinkAmountSliderText.setText("Drink Amount: " + 8.0 + " oz.");

        drinkAmountSlider.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int drinkAmountValue;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        drinkAmountValue = progress;
                        drinkAmountSliderText.setText("Drink Amount: " + (int) ((int) (progress*6.0/100)*4.0 + 8.0) + " oz.");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}
