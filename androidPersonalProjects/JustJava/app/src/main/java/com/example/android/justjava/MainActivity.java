package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, boolean hasChocolateTopping, boolean hasWhipCream) {
        int price = quantity * 5;

        if (hasChocolateTopping) {

            price = price + quantity * 2;

        }

        if (hasWhipCream)
        {
            price = price + quantity;
        }
        return price;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhipCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateToppingCheckBox = (CheckBox) findViewById(R.id.chocolate_topping_checkbox);
        boolean hasChocolateTopping = chocolateToppingCheckBox.isChecked();
        EditText name = (EditText) findViewById(R.id.name);
        String customerName = name.getText().toString();
        String priceMessage = createOrderSummary(calculatePrice(quantity, hasChocolateTopping, hasWhipCream), hasWhipCream, hasChocolateTopping, customerName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + customerName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    public void increment(View view)
    {
        if (quantity + 1 == 101)
        {
            Context context = getApplicationContext();
            CharSequence text = "You can't order more than 100 coffees.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else if (quantity < 100)
            quantity = quantity + 1;

        display(quantity);

    }

    public void decrement(View view)
    {
        if (quantity - 1 == 0)
        {
            Toast.makeText(this, "You can't order 0 coffees.", Toast.LENGTH_SHORT).show();

        }

        if (quantity > 1)
            quantity = quantity - 1;

        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolateTopping, String customerName)
    {
        String priceMessage = "ORDER SUMMARY\n\n";
        priceMessage +=  "Name = " + customerName;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate topping? " + addChocolateTopping;
        priceMessage += "\nQuantity = " + quantity;
        priceMessage += "\nTotal = $" + price;
        priceMessage += "\nThank You";

        return priceMessage;
    }
}