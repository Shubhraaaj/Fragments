package com.example.shubhraj.fragmentcommunication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        InputFragment.OnFragmentInteractionListener, OutputFragment.OnFragmentInteractionListener
{
    private String inputTextView, outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTextView = "";
        outputTextView = "";
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        InputFragment inputFragment = new InputFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text","First Fragment");
        inputFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.list_container,inputFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {
        inputTextView = uri.toString();
        if(inputTextView.length()!=0)
        {
            FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            OutputFragment outputFragment = new OutputFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("text", inputTextView);
            outputFragment.setArguments(bundle1);
            fragmentTransaction1.replace(R.id.list_container,outputFragment);
            fragmentTransaction1.addToBackStack(null);
            fragmentTransaction1.commit();
        }
    }

    @Override
    public void onFragmentInteractions(Uri uri) {
        outputTextView = uri.toString();
        if(outputTextView.length()!=0)
        {
            FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            InputFragment inputFragment = new InputFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("text", outputTextView);
            inputFragment.setArguments(bundle1);
            fragmentTransaction1.replace(R.id.list_container,inputFragment);
            fragmentTransaction1.addToBackStack(null);
            fragmentTransaction1.commit();
        }
    }
}
