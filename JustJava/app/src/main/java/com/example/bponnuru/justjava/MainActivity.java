package com.example.bponnuru.justjava;

import java.text.NumberFormat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    private static final int PRICE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private int calculatePrice() {
        return quantity * PRICE;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox whipCream = (CheckBox) findViewById(R.id.whip_cream);
        CheckBox choclate = (CheckBox) findViewById(R.id.chocklate);

        EditText name = (EditText) findViewById(R.id.name);
        String custName = name.getText().toString();
        if (whipCream.isChecked()) {
            price = price + ( quantity * 2 );
        }
        if (choclate.isChecked()) {
            price = price + ( quantity * 3 );
        }
        String summary = getOrderSummary(custName, price);
        displayPrice(summary);
        sendMail(custName, summary);
    }

    private void sendMail(String name, String subject){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.thank_you, name));
        intent.putExtra(Intent.EXTRA_TEXT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0)
            quantity--;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayPrice(String summary) {
        TextView priceView = (TextView) findViewById(R.id.price_text_view);
        priceView.setText(summary);
    }

    public String getOrderSummary(String name, int price) {
        String orderSummary = "";
        orderSummary += getString(R.string.thank_you, name);
        orderSummary += getString(R.string.you_need_to_pay) + NumberFormat.getCurrencyInstance().format(price);
        return orderSummary;
    }
}