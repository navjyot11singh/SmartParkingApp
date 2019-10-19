package www.navjyotsingh.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ParkingDescription extends AppCompatActivity implements View.OnClickListener {
    private TextView txt_booknow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_description);
        init();
    }

    private void init() {
        txt_booknow = findViewById(R.id.txt_booknow);
        txt_booknow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.txt_booknow){
            startActivity(new Intent(this,ParkingMapsActivity.class));
        }
    }
}
