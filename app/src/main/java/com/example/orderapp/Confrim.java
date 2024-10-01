package com.example.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Confrim extends AppCompatActivity {
    private HashMap<String, String> bakery;
    private HashMap<String, String> icecream;
    private HashMap<String, String> drink;

    private String selectedBakery;
    private String selectedIceCream;
    private String selectedDrink;

    TextView BakeryName, IcecreamName, DrinkName;
    ImageView BakeryImage, IcecreamImage, DrinkImage;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confrim);

        Intent intent = getIntent();
        selectedBakery = intent.getStringExtra("bakery");
        selectedIceCream = intent.getStringExtra("icecream");
        selectedDrink = intent.getStringExtra("drink");

        bakery = new HashMap<String, String>();
        icecream = new HashMap<String, String>();
        drink = new HashMap<String, String>();
        bakery.put("CupCake", "https://i.imgur.com/xNV4xG0.png");
        bakery.put("Donut", "https://i.imgur.com/4dbtjd3.png");
        bakery.put("Croissant", "https://i.imgur.com/Ga8eQqe.png");
        bakery.put("Brownies", "Washington DC");
        icecream.put("Strawberry", "https://i.imgur.com/ooOiif6.png");
        icecream.put("Chocolate", "https://i.imgur.com/ooOiif6.png");
        icecream.put("Vanilla", "https://i.imgur.com/jbzpA92.png");
        icecream.put("Mint", "https://i.imgur.com/NHohsZl.png");
        drink.put("MilkShake", "https://i.imgur.com/PvKHs18.png");
        drink.put("Juice", "https://i.imgur.com/81B88Jl.png");
        drink.put("Coffee", "https://i.imgur.com/jmQDPRP.png");
        drink.put("Tea", "https://i.imgur.com/P9sS7t8.png");

        BakeryName = findViewById(R.id.BakeryName);
        IcecreamName = findViewById(R.id.IcecreamName);
        DrinkName = findViewById(R.id.DrinkName);

        BakeryName.setText(selectedBakery);
        IcecreamName.setText(selectedIceCream);
        DrinkName.setText(selectedDrink);

        BakeryImage = findViewById(R.id.imageView);
        IcecreamImage = findViewById(R.id.imageView2);
        DrinkImage = findViewById(R.id.imageView3);
        Glide.with(this).load(bakery.get(selectedBakery)).into(BakeryImage);
        Glide.with(this).load(icecream.get(selectedIceCream)).into(IcecreamImage);
        Glide.with(this).load(drink.get(selectedDrink)).into(DrinkImage);

        System.out.println(selectedBakery);
        System.out.println(selectedIceCream);
        System.out.println(selectedDrink);

        System.out.println(bakery.get(selectedBakery));
        System.out.println(icecream.get(selectedIceCream));
        System.out.println(drink.get(selectedDrink));

        back = findViewById(R.id.button);
        back.setOnClickListener(view -> {
            Intent intent1 = new Intent(Confrim.this, MainActivity.class);
            startActivity(intent1);
        });

    }
}