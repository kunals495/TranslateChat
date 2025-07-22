package com.example.translatechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.translatechat.Adapter.FragmentAdapter;
import com.example.translatechat.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;


    FirebaseTranslator englishGermanTranslator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        mAuth = FirebaseAuth.getInstance();
        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.settings:
                //Toast.makeText(this, "Setting is Clicked", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent2);
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent intent= new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
