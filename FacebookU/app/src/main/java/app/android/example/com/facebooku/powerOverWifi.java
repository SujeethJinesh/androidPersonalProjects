package app.android.example.com.facebooku;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.android.example.com.facebooku.R;

/**
 * Created by lab on 1/10/2016.
 */
public class powerOverWifi extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.power_over_wifi, container, false);
    }
}
