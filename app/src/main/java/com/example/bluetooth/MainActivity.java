package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b11,b22,b33;
    BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ba=BluetoothAdapter.getDefaultAdapter();

        b11=findViewById(R.id.enable);
        b22=findViewById(R.id.desable);
        b33=findViewById(R.id.discover);



        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(i,5);
            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.disable();
            }
        });

        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                d.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,3000);
                startActivityForResult(d,5);
            }
        });

    }
}
