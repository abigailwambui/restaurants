package com.example.myresturant;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button mFindRestaurantsButton;
    private EditText mLocationEditText;
    private TextView mmyRestaurantTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
        mmyRestaurantTextView = (TextView) findViewById(R.id.myRestaurantTextView);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Heavy.otf");
        Typeface ostrichFontTwo = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Bold.otf");
        mmyRestaurantTextView.setTypeface(ostrichFont);
        mFindRestaurantsButton.setTypeface(ostrichFontTwo);
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String location = mLocationEditText.getText().toString();
                    Log.v("Zipcode:", location);
                    Intent intent =  new Intent(MainActivity.this, RestaurantsActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }
            });




    }
}
