package com.example.takeiteasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView choosecoffee, choosecake;
    RadioButton porciya1, porciya2, yourasdress, anotheradress;
    CheckBox sugar, milk, sirop;
    Button order;

    String coffee, cake, zakaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choosecoffee = findViewById(R.id.choosecoffee);
        registerForContextMenu(choosecoffee);
        choosecake = findViewById(R.id.choosecake);
        registerForContextMenu(choosecake);

        porciya1 = findViewById(R.id.porciya1);
        porciya2 = findViewById(R.id.porciya2);

        yourasdress = findViewById(R.id.youradress);
        anotheradress = findViewById(R.id.anotheradress);

        sugar = findViewById(R.id.sugar);
        milk = findViewById(R.id.milk);
        sirop= findViewById(R.id.sirop);

        order = findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (porciya1.isChecked()){
                    cake = "one porciya";
                }else if (porciya2.isChecked()){
                    cake = "two porciya";
                }
                if (yourasdress.isChecked()){
                    zakaz= "your adress";
                }else if (anotheradress.isChecked()){
                    zakaz = "another adress";
                }
                if (sugar.isChecked()){
                    coffee= "sugar";
                }
                if (sirop.isChecked()){
                    coffee= "sirop";
                }
                if (milk.isChecked()){
                    coffee= "milk";
                }
                String result = "coffee: " + choosecoffee.getText()+"\n"+
                        "cake: "+ choosecake.getText()+"\n"+
                        "coffee details: "+ coffee+ "\n"+
                        "cake porci: "+ cake + "\n"+
                        "order: "+ zakaz;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }

        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == choosecoffee){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.coffeemenu, menu);
        }
        if (v == choosecake){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.cakesmenu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.coffeeLatte:
                choosecoffee.setText("Latte");
                break;
            case R.id.coffeeExpresso:
                choosecoffee.setText("Expresso");
                break;
            case R.id.coffeeCappiccino:
                choosecoffee.setText("Cappiccino");
                break;
            case R.id.coffeeAmericano:
                choosecoffee.setText("Americano");
                break;

            case R.id.cakePound:
                choosecake.setText("Pound");
                break;
            case R.id.cakeBiscuit:
                choosecake.setText("Biscuit");
                break;
            case R.id.cakeCupcake:
                choosecake.setText("Cupcake");
                break;
            case R.id.cakeChococake:
                choosecake.setText("Chococake");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.korzinka:
                Toast.makeText(this, "your orders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ourmenu:
                Toast.makeText(this, "our menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.acc:
                Toast.makeText(this, "my acc", Toast.LENGTH_SHORT).show();
                break;
            case R.id.map:
                Toast.makeText(this, "map", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}