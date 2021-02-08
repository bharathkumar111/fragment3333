package com.example.fragment333;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.depak,"plant1"));
        slideModels.add(new SlideModel(R.drawable.dhavan,"plant1"));


        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGWQcQYGP7kZwN-LyRoc4Hcldrs0NEqQo-0w&usqp=CAU",""));
        imageSlider.setImageList(slideModels,true);


        firstFragment = (Button)findViewById(R.id.firstFragment);
        secondFragment = (Button) findViewById(R.id.secondFragment);


        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                load(new FirstFragment());
            }
        });

        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                load(new SecondFragment());
            }
        });

    }

    private void load(Fragment fragment) {

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}