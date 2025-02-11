package com.example.shophine.rakshak;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by shophine on 6/1/18.
 */


public class Date implements DatePickerDialog.OnDateSetListener{

    Context ctx;
    private DateCallback dateCallback;
    private String date,month,year;
    public String finalDate;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public Date() {
    }

    public Date(Context ctx, DateCallback dateCallback)
    {
        this.ctx=ctx;
        this.dateCallback = dateCallback;
        preferences = ctx.getSharedPreferences("date",Context.MODE_PRIVATE);
        editor = preferences.edit();

    }
    @Override
    public void onDateSet(DatePicker view, int y, int m, int d) {
        switch(m){
            case 0 : month="Jan";
                     break;
            case 1 : month="Feb";
                break;
            case 2 : month="Mar";
                break;
            case 3 : month="Apr";
                break;
            case 4 : month="May";
                break;
            case 5 : month="Jun";
                break;
            case 6 : month="Jul";
                break;
            case 7 : month="Aug";
                break;
            case 8 : month="Sep";
                break;
            case 9 : month="Oct";
                break;
            case 10 : month="Nov";
                break;
            case 11 : month="Dec";
                break;
            default: month=" ";
        }
        year = String.valueOf(y);
        date = String.valueOf(d);
        finalDate = month+"  "+date+", "+year;
        //Toast.makeText(ctx,"Date selected successfully :"+ finalDate,Toast.LENGTH_LONG).show();
        editor.putString("finalDate",finalDate);
        editor.commit();
        dateCallback.onDateSet(finalDate);
    }
    public String getFinalDate(){
        return finalDate;
    }
}

