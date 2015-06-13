package com.robertsolutions.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = "MyActivity";

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //You should place your menu items in to menu.
        //onCreateOptionsMenu >> For this method to be called, you must have first called
        setHasOptionsMenu(true);

    }

    public View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_main, container, false);


        String[] forecastArray = {
                "Today - Sunny - 30º/33º",
                "Tomorrow - Sunny - 30º/33º",
                "Monday - Sunny - 30º/33º",
                "Tuesday - Rain - 30º/33º",
                "Wednesday - Foggy - 30º/33º",
                "Thursday - Cloudy - 30º/33º",
                "Friday - Heavy Rain - 30º/33º",
                "Saturday - Sunny - 30º/33º",
                "Sunday - Sunny - 30º/33º",
        };
        List<String> weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray)
        );

        ArrayAdapter mForecastAdapter = new ArrayAdapter<String>(
                //The current context
                getActivity(),
                //ID of list item layout
                R.layout.list_item_forecast,
                //ID of the textview to populate
                R.id.list_item_forecast_textview,
                //Forecast data
                weekForecast);

        ListView mListView = (ListView) rootView.findViewById(R.id.list_item_forecast);

        mListView.setAdapter(mForecastAdapter);


        return rootView;
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.forecast_fragment, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return true;

    }


}
