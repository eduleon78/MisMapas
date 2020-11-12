package com.leonestudios.mismapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButtonSM = findViewById(R.id.imgSambil);
        ImageButton imageButtonLV = findViewById(R.id.imgLavela);
        ImageButton imageButtonPLA = findViewById(R.id.imgPlaya);
        ImageButton imageButtonIGL = findViewById(R.id.imgIglesia);

        imageButtonSM.setOnClickListener(this);
        imageButtonLV.setOnClickListener(this);
        imageButtonPLA.setOnClickListener(this);
        imageButtonIGL.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d("Toque -> ", String.valueOf(view.getId()));
        switch(view.getId()){
            case R.id.imgSambil:
                GoToLocation("Sambil Mall", new LatLng(10.996067868790965, -63.8122308254242));
                break;
            case R.id.imgLavela:
                GoToLocation("La Vela Mall", new LatLng(10.97936386977399, -63.82107138633729));
                break;
            case R.id.imgPlaya:
                GoToLocation("Playa el Agua", new LatLng(11.146276905110751, -63.86449098587037));
                break;
            case R.id.imgIglesia:
                GoToLocation("Iglesia el valle", new LatLng(10.982723703410146, -63.884055018424995));
                break;
            default:
        }

    }


    private void GoToLocation(String name, LatLng location) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("location", location);
        intent.putExtra("name", name);
        startActivity(intent);

    }
}