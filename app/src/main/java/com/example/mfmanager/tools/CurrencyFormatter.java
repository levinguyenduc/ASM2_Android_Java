package com.example.mfmanager.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.mfmanager.MainActivity;

import java.text.NumberFormat;
import java.util.Locale;


public class CurrencyFormatter {

    public static String format(Context context, String number){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        //get the currency code from shared preference
        String currencyCode = prefs.getString(MainActivity.CURRENCY_KEY, "CANADA");

        //format the double value to a string
        NumberFormat format = NumberFormat.getInstance(new Locale(currencyCode));

        double doubleNumber = Double.parseDouble(number);
        return format.format(doubleNumber);
    }
}
