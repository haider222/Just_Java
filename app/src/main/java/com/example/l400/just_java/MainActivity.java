package com.example.l400.just_java;

import android.annotation.TargetApi;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
     //   displayprice(quantity * 5);
     //  int price =  calculatePrice(quantity);
       // displayMessagePrice("Totall : " +price +"$"+ " \nThank you!");
        String summary = createOrderSummary(quantity);
        displayMessage(summary);

    }
    public void displayQuantity(int number){
        TextView textView = (TextView)findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }
    @TargetApi(Build.VERSION_CODES.N)
    public void displayprice(int number){
        TextView price = (TextView)findViewById(R.id.order_summary_text_view);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
         quantity = quantity - 1;
        displayQuantity(quantity);


    }
    public void displayMessage(String message){
        TextView ordersummarytextview = (TextView)findViewById(R.id.order_summary_text_view);
        ordersummarytextview.setText(message);
    }
    private int calculatePrice(int quantity){
      int price = quantity * 5;
        return price;
    }
    public String createOrderSummary(int price){
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkboxx);
        boolean ch = checkBox.isChecked();

        return "Name : kaptain kunal\n"+"Add wipped cream? "+ch + "\nQuantity : " + price +" \nTotal : " +"$"+price *5+"\nThank you!";
    }
}
