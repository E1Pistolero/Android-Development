package com.example.milly.practicewithpolar;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startBT,settingsBT, helpBT, exitBT;
    private BluetoothAdapter mBluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBT = (Button) findViewById(R.id.bt_start);
        settingsBT = (Button) findViewById(R.id.bt_settings);
        helpBT = (Button) findViewById(R.id.bt_help);
        exitBT = (Button) findViewById(R.id.bt_exit);




        //Checks if BLE is supported by device and lets user if it is not
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, "BLE is not supported", Toast.LENGTH_SHORT).show();
            finish();
        }
        // Initializes Bluetooth adapter.
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        // Checks if device has a Bluetooth
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "No Bluetooth", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }




        //Start activity that checks bluetooth status ans shows heart rate
        startBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent1 = new Intent();
//                String action = intent1.getAction();
//                if(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED.equals(action)){
//                    Intent intent = new Intent(getBaseContext(), Start_Activity.class);
//                    startActivity(intent);
//
//                }else{
//                    Toast.makeText(getApplicationContext(),"BLE is not connected", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getBaseContext(), ScanBluetoothActivity.class);
//                    startActivity(intent);
//                }



            }
        });
        //Seting activity
        settingsBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ScanBluetoothActivity.class);
                startActivity(intent);
            }
        });

        //Help - opens the Polar website help page for H6 and H7 heart rate monitors
        helpBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Help_Activity.class);
                startActivity(intent);
            }
        });
        //Exit
        exitBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();

        //Checks if device has a Bluetooth and if bluetooth is off
        //and only in that case it sends request to user to turn on
        //bletooth on device.
        if (mBluetoothAdapter != null && !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }





}
