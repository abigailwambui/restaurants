package com.example.myresturant;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private Button mFindRestaurantsButton;
    private EditText mLocationEditText;
    private TextView mMyResturantTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mMyResturantTextView = (TextView) findViewById(R.id.myResturantTextView );
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Heavy.otf");
        Typeface ostrichFontButton = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Bold.otf");
        mMyResturantTextView.setTypeface(ostrichFont);
        mFindRestaurantsButton.setTypeface(ostrichFont);
        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String location = mLocationEditText.getText().toString();
                    Intent intent =  new Intent(MainActivity.this, ResturantsActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }
            });




    }
}
