package com.example.fleetdynamics;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class DeliveryFragment extends Fragment
{


    Button cancel, clear, save;
    Bitmap bit;
    SignatureView SignatureView;
    String View;
    Dialog dis;
    private static final String IMAGE_DIRECTORY = "/signdemo";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);


        SignatureView = (SignatureView) view.findViewById(R.id.delsignature);
        clear = (Button) view.findViewById(R.id.delclear);
        save = (Button) view.findViewById(R.id.delieverysave);
        cancel = (Button) view.findViewById(R.id.deliverycancel);


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

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JobSummaryFragment()).commit();

            }
        });


        //this button will save the signature as image
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // bit = SignatureView.getSignatureBitmap();
                // View = saveImage(bit);
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });


        return view;
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
            MediaScannerConnection.scanFile(getContext(),
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
