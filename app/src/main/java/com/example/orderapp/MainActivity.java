package com.example.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    String[] Bakerys = {"CupCake", "Donut", "Croissant", "Brownies"};
    String[] Ice_Creams = {"Strawberry", "Chocolate", "Vanilla", "Mint"};
    String[] Drinks = {"MilkShake", "Juice", "Coffee", "Tea"};


    AutoCompleteTextView Bakery, IceCream, Drink;
    ArrayAdapter<String> adapterItems;
    Button confirm;

    private int objectCount = 0;
    private String selectedBakery = "";
    private String selectedIceCream = "";
    private String selectedDrink = "";

    ArrayList<MyOrder> objects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirm = findViewById(R.id.confirm_button);

        Bakery = findViewById(R.id.Bakery);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_order, Bakerys);
        Bakery.setAdapter(adapterItems);
        Bakery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedBakery = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedBakery, Toast.LENGTH_SHORT).show();
            }
        });

        IceCream = findViewById(R.id.Icecream);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_order, Ice_Creams);
        IceCream.setAdapter(adapterItems);
        IceCream.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIceCream = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedIceCream, Toast.LENGTH_SHORT).show();
            }
        });

        Drink = findViewById(R.id.Drink);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_order, Drinks);
        Drink.setAdapter(adapterItems);
        Drink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedDrink = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedDrink, Toast.LENGTH_SHORT).show();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectCount++;
                MyOrder newOrder = new MyOrder(selectedBakery, selectedIceCream,selectedDrink);
                objects.add(newOrder);
                Intent confirm = new Intent(MainActivity.this, Confrim.class);
                confirm.putExtra("bakery", selectedBakery);
                confirm.putExtra("icecream", selectedIceCream);
                confirm.putExtra("drink", selectedDrink);
                startActivity(confirm);
            }
        });
    }
}