package app.sunshine.android.example.com.nutri_potum30;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by lab on 1/11/2016.
 */
public class DrinkAmountActivity extends FragmentActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drinkAmountSliderStart();
    }

    private static SeekBar drinkAmountSlider;
    private static TextView drinkAmountSliderText;

    public void drinkAmountSliderStart()
    {
        drinkAmountSlider = (SeekBar) findViewById(R.id.drinkAmountSlider);
        drinkAmountSliderText = (TextView) findViewById(R.id.drinkAmountText);
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
