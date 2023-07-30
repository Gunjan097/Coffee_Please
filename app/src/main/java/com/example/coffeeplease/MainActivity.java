package com.example.coffeeplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numberOfCoffee=0;
    public void increase(View view){
        numberOfCoffee+=1;
        display(numberOfCoffee);
    }
    public void decrease(View view){
        if(numberOfCoffee!=0){
        numberOfCoffee-=1;
        display(numberOfCoffee);}
    }
    public void SubmitOrder(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasCheckedWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        boolean hasCheckedChocolate = chocolateCheckBox.isChecked();
        EditText nameFiled = (EditText) findViewById(R.id.name_field);
        String name = nameFiled.getText().toString();
    display(numberOfCoffee);
    int price=calculatePrice();
    displayPrice(createSummary(name,price, hasCheckedWhippedCream,hasCheckedChocolate));
    }

    public int calculatePrice(){
        return numberOfCoffee*5;
    }

    public String createSummary(String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage="Name:"+name;
        priceMessage+="\nQuantity:"+numberOfCoffee;
        priceMessage+="\nWhipped cream:"+addWhippedCream;
        priceMessage+="\nChocolate:"+addChocolate;
        priceMessage+="\nTotal: $"+price;
        priceMessage+="\nThank You!";
        return priceMessage;
    }

    public void display(int number){
        TextView quantityTextView=(TextView) findViewById(R.id.quantity) ;
        quantityTextView.setText(" "+number);
    }
    public void displayPrice(String message){
        TextView priceTextView=(TextView) findViewById(R.id.price);
        priceTextView.setText(message);
    }
}