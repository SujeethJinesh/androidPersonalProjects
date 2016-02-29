package app.android.example.com.nutri_potum40;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by lab on 1/16/2016.
 */
public class ButtonPageActivity extends Fragment {

    private final static int REQUEST_ENABLE_BT = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.button_page, container, false);

//        createButtonMethod();
//        recordsButtonMethod();
//        settingsButtonMethod();

        return view;
    }

    public void createButtonMethod()
    {
        Button createButton = (Button) getView().findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DrinkAmountActivity.class));
            }
        });
    }

    public void recordsButtonMethod()
    {
        Button createButton = (Button) getView().findViewById(R.id.recordsButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RecordsActivity.class));
            }
        });
    }

    public void settingsButtonMethod()
    {
        Button createButton = (Button) getView().findViewById(R.id.settingsButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });
    }

    public void syncButtonMethod(View view)
    {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(mBluetoothAdapter == null)
        {
            Toast.makeText(getActivity(), "Your phone does not support bluetooth.", Toast.LENGTH_SHORT).show();
        }

        if (!mBluetoothAdapter.isEnabled()) {

            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }
}
