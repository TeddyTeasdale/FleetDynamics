
package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class DeliveryyActivity extends AppCompatActivity {

    Button cancel, clear, save;
    Bitmap bit;
    SignatureView SignatureView;
    String view;
    Dialog dis;
    private static final String IMAGE_DIRECTORY = "/signdemo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryy);

        SignatureView = (SignatureView) findViewById(R.id.delsignature);
        clear = (Button) findViewById(R.id.delclear);
        save = (Button) findViewById(R.id.delieverysave);
        cancel = (Button) findViewById(R.id.deliverycancel);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignatureView.clearCanvas();

            }
        });

        //cancel button will cancel the signature action
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("tag", "cancelled");
                dis.dismiss();
                recreate();

            }
        });


        //this button will save the signature as image
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bit = SignatureView.getSignatureBitmap();
                view = saveImage(bit);
            }
        });
    }





    private String saveImage(Bitmap mybit) {
        ByteArrayOutputStream delivery = new ByteArrayOutputStream();
        mybit.compress(Bitmap.CompressFormat.JPEG, 90, delivery);
        File pic = new File(
                Environment.getExternalStorageState() + IMAGE_DIRECTORY);
        if (!pic.exists()) {
            pic.mkdirs();
            Log.d("hello", pic.toString());
        }

        try {
            File pc = new File(pic, Calendar.getInstance().getTimeInMillis() + "jpg");
            pc.createNewFile();
            FileOutputStream pi = new FileOutputStream(pc);
            pi.write(delivery.toByteArray());
            MediaScannerConnection.scanFile(DeliveryyActivity.this,
                    new String[]{pc.getPath()},
                    new String[]{"image/jpeg"}, null);
            pi.close();
            Log.d("TAG", "File is saved" + pc.getAbsolutePath());
            return pc.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }


}