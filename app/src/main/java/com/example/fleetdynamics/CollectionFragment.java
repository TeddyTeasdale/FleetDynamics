/**
 package com.example.fleetdynamics;

 import android.content.Intent;
 import android.graphics.Bitmap;
 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.TextView;

 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;
 import androidx.fragment.app.Fragment;

 import java.util.ArrayList;

 import static android.app.Activity.RESULT_OK;

 public class CollectionFragment extends Fragment
 {
 private static final int CAMERA_REQUEST = 123;
 private ImageView imageView;
 private ArrayList<Bitmap> vehiclePhotos = new ArrayList<>();
 int screen = 0;
 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
 {
 View view = inflater.inflate(R.layout.fragment_collection, container, false);
 super.onCreate(savedInstanceState);

 TextView title = view.findViewById(R.id.titleView);
 String screen1 = "";

 if(!(getArguments().getString("screenNumber")==null))
 {
 screen1 = getArguments().getString("screenNumber");
 screen = Integer.parseInt(screen1);
 vehiclePhotos = getArguments().getParcelableArrayList("myArrayList");
 }

 switch(screen)
 {
 case 0:
 title.setText("Vehicle Front Photo");
 startCamera(view);
 break;
 case 1:
 title.setText("Vehicle Back Photo");
 startCamera(view);
 break;
 case 2:
 title.setText("Vehicle Left Side Photo");
 startCamera(view);
 break;
 case 3:
 title.setText("Vehicle Right Side Photo");
 startCamera(view);
 break;
 case 4:
 // start summary activity
 System.out.println(vehiclePhotos.size());
 break;
 }


 return view;
 }
 public void startCamera(View view)
 {
 imageView = (ImageView) view.findViewById(R.id.imageView3);
 Button photoButton = (Button) view.findViewById(R.id.DamageMapButton);
 photoButton.setOnClickListener(new View.OnClickListener()
 {


 //@Override
 public void onClick(View v)
 {
 Intent cameraIntent = new Intent
 (android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
 startActivityForResult(cameraIntent, CAMERA_REQUEST);
 }
 });
 }

 public void onActivityResult(int requestCode, int resultCode, Intent data)
 {
 if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
 {
 Bitmap photo = (Bitmap) data.getExtras().get("data");
 vehiclePhotos.add(photo);
 imageView.setImageBitmap(photo);
 }
 screen++;
 String screen1 = String.valueOf(screen);
 Bundle bundle = new Bundle();
 bundle.putString("screenNumber",screen1);
 bundle.putParcelableArrayList("myArrayList", vehiclePhotos);
 CollectionFragment collection = new CollectionFragment();
 collection.setArguments(bundle);
 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CollectionFragment()).commit();
 }

 }
 **/
