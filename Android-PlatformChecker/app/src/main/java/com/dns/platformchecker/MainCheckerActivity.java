package com.dns.platformchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

import life.sabujak.roundedbutton.RoundedButton;

public class MainCheckerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoundedButton emulationCheckButton1 = (RoundedButton) findViewById(R.id.checkEmulationStatus1);
        emulationCheckButton1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String isEmulator = checkIfDeviceIsEmulator1();
                System.out.println("isEmulator returns = "+isEmulator);

                if(isEmulator.trim().equals("yes"))
                {
                    StyleableToast.makeText(getApplicationContext(), "You failed!! Emulator Detected!", Toast.LENGTH_LONG, R.style.redColor2).show();
                }
                else if(isEmulator.trim().equals("no")) {
                    StyleableToast.makeText(getApplicationContext(), "Congratulations!! No Emulator Detected!", Toast.LENGTH_LONG, R.style.greenColor2).show();
                } else{
                    StyleableToast.makeText(getApplicationContext(), "Something went wrong!!", Toast.LENGTH_LONG, R.style.redColor2).show();
                }
            }
        });

        RoundedButton emulationCheckButton2 = (RoundedButton) findViewById(R.id.checkEmulationStatus2);
        emulationCheckButton2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


            }
        });

        RoundedButton rootCheckButton = (RoundedButton) findViewById(R.id.checkRootStatus);
        rootCheckButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });
    }

    public String checkIfDeviceIsEmulator1() {
        //Normal function String returnType & No arguments

        if(Build.FINGERPRINT.contains("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MODEL.contains("sdk")
                || Build.MODEL.contains("x86")
                || Build.MODEL.contains("unknown")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.FINGERPRINT.contains("test-keys")
                || Build.PRODUCT.contains("vbox86p")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT))
        {

            return "yes";
        }else{
            return "no";

        }

    }

}
