package com.example.myresturant.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myresturant.Constants;
import com.example.myresturant.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Button mFindRestaurantsButton;
    private EditText mLocationEditText;
    private TextView mmyRestaurantTextView;
    private String mRecentAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
        mmyRestaurantTextView = (TextView) findViewById(R.id.myRestaurantTextView);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        mEditor = mSharedPreferences.edit();

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Heavy.otf");
        Typeface ostrichFontTwo = Typeface.createFromAsset(getAssets(), "fonts/OstrichSans-Bold.otf");
        mmyRestaurantTextView.setTypeface(ostrichFont);
        mFindRestaurantsButton.setTypeface(ostrichFontTwo);
        mFindRestaurantsButton.setOnClickListener(this);

                    }
            @Override
                public void onClick(View view) {
                if (view == mFindRestaurantsButton) {
                    String location = mLocationEditText.getText().toString();
                    addToSharedPreferences(location);
                    Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);

                }
            }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}





