package com.example.shophine.rakshak;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Prabhu Sivanandam on 19-May-17.
 */

public class PickerDialog extends DialogFragment {

    DateCallback dateCallback;

    SharedPreferences preferences;
    String date=null;
    SharedPreferences.Editor editor;
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        dateCallback = (DateCallback) bundle.getSerializable("callback");
        Date dateSettings=new Date(getActivity(), dateCallback);
        //preferences=getActivity().getSharedPreferences("date", Context.MODE_PRIVATE);
        //date = preferences.getString("finalDate",null);
        //Toast.makeText(getContext(),""+date,Toast.LENGTH_LONG).show();
        Calendar calendar= Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog=new DatePickerDialog(getActivity(),dateSettings,year,month,day);
        return dialog;
    }
}
