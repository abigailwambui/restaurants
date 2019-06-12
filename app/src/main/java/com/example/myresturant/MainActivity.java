package com.example.myresturant;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity {
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.myRestaurantTextView) TextView mMyRestaurantTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Heavy.otf");
        Typeface ostrichFontTwo = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Bold.otf");
        mMyRestaurantTextView.setTypeface(ostrichFont);
        mFindRestaurantsButton.setTypeface(ostrichFontTwo);
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
