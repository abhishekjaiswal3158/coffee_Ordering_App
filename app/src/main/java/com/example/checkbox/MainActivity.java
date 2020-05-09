package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=2;
    int price=10;
    boolean check1=false;boolean check2=false;
    public void checkBox1(View view){
        if(check1==false){
        check1=true;}
        else if(check1==true){
            check1=false;}
        calculatePrice();
        displayPrice(price);

    }

    public void checkBox2(View view){
        if(check2==false){
            check2=true;}
       else if(check2==true){
            check2=false;}
        calculatePrice();
        displayPrice(price);
    }

    public void increment(View view){
        if(quantity==100){
            Toast.makeText(this,"you can not order more than 100 cup of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        calculatePrice();
        displayQuantity(quantity);
        displayPrice(price);
    }
    public void decrement(View view){

        if(quantity==1){
            Toast.makeText(this,"you can not order less than 1 cup of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        calculatePrice();
        displayQuantity(quantity);
        displayPrice(price);
    }
    public void calculatePrice(){
        if(check1==true && check2==true){
            price=5*quantity+1*quantity+2*quantity;
        }
        else if(check1==false && check2==true){
            price=5*quantity+2*quantity;
        }
        else if(check1==true && check2==false){
            price=5*quantity+1*quantity;
        }
        else{
            price=5*quantity;
        }
    }
    private void displayPrice(int pri){
        TextView p=(TextView) findViewById(R.id.summary);

        p.setText("$" +pri);
    }
    private void displayQuantity(int q){
        TextView a=(TextView) findViewById(R.id.quant);
         a.setText(""+ q);
    }
    public void orderSum(View view){
        TextView o=(TextView) findViewById(R.id.summary);
        EditText name= (EditText) findViewById(R.id.plain_text_input);
        Editable name1= (Editable) name.getText();
        String message="  NAME:"+name1+"\n Add whipped cream?"+check1+"\n Add chocolate?"+check2+"\n Quantity:"+quantity+"\n Total price:"+price+"\n Thank you!";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,message);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

}
