package com.example.myapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDesc extends AppCompatActivity {

    TextView title,description,brand,price;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_desc);

        img = findViewById(R.id.imageView);
        description = findViewById(R.id.description);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        brand = findViewById(R.id.brand);

        Intent i = getIntent();
        Products P = i.getParcelableExtra("data");
        String name = P.getPname();

        Picasso.get().load(P.getPimg()).into(img);

       // System.out.println("hi"+name);

        title.setText(P.Pname);

        String des = P.desc;
        description.setText(des);
        price.setText((int) P.price);
        brand.setText(P.brand);
    }
}
