package com.example.shophine.rakshak;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CropPrice extends Fragment {

    TextView textView,predictedPrice;
    EditText editText;
    ProgressDialog progressDialog;
    Button btn,btn2;
    SharedPreferences preferences;
    List<String> cList,coList,rList;
    List<Centres> centresList;
    List<Commodity> commoditiesList;
    List<Region> regionList;
    String d,centre,commodity,price,region,country,centreCategory="AGARTALA",commodityCategory="Milk",regionCategory;
    Spinner regionSpinner,commoditySpinner,centerSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        centresList=new ArrayList<>();
        cList = new ArrayList<>();
        coList = new ArrayList<>();
        rList = new ArrayList<>();
        commoditiesList = new ArrayList<>();




        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.crop_price, container, false);

        textView = (TextView)view.findViewById(R.id.dateDisplay);
        predictedPrice = (TextView)view.findViewById(R.id.predictedPrice);
        regionSpinner = (Spinner)view.findViewById(R.id.region);
        commoditySpinner = (Spinner)view.findViewById(R.id.commodity);
        centerSpinner = (Spinner)view.findViewById(R.id.center);
        editText = (EditText) view.findViewById(R.id.dateDisplay);
        btn2 = (Button) view.findViewById(R.id.post);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d = editText.getText().toString();
                region = regionCategory;
                commodity = commodityCategory;
                price = "0";
                centre = centreCategory;
                country = "India";
                PriceEntity entity = new PriceEntity(d, centre, commodity, price, region, country);
                RestClientImplementation.getPrediction(entity, new PriceEntity.PriceEntityInterface() {
                    @Override
                    public void onPredicted(String predictedValue, VolleyError error) {
                        if (error == null) {

                            predictedPrice.setText(predictedValue);
                            Toast.makeText(getContext(), predictedValue, Toast.LENGTH_LONG).show();
                        }
                    }
                }, getActivity());
            }
        });
        final CenterMiniEntity centerMiniEntity = new CenterMiniEntity();
        RestClientImplementation.getLocation(centerMiniEntity, new CenterMiniEntity.RestClientInterface() {
            @Override
            public void onInitialize(CenterMiniEntity centres, VolleyError error) {
                if(error == null){
                    centresList = centres.getResponse();
                    //Toast.makeText(Home.this,centresList.get(0).getName(),Toast.LENGTH_LONG).show();
                    for(Centres item: centresList){
                        cList.add(item.getName());
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,cList);
                        centerSpinner.setAdapter(dataAdapter);
                    }
                }
            }
        },getActivity());
        centerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                centreCategory = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final CommodityMiniEntity commodityMiniEntity = new CommodityMiniEntity();
        RestClientImplementation.getCommodity(commodityMiniEntity, new CommodityMiniEntity.RestClientInterface() {
            @Override
            public void onInitialize(CommodityMiniEntity commodity, VolleyError error) {
                if(error==null){
                    commoditiesList = commodity.getResponse();
                    for(Commodity item:commoditiesList){
                        coList.add(item.getName());
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,coList);
                    commoditySpinner.setAdapter(dataAdapter);
                }
            }
        },getActivity());
        commoditySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                commodityCategory = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final RegionMiniEntity regionMiniEntity = new RegionMiniEntity();
        RestClientImplementation.getRegion(regionMiniEntity, new RegionMiniEntity.RestClientInterface() {
            @Override
            public void onInitialize(RegionMiniEntity region, VolleyError error) {
                if(error==null){
                    regionList = region.getResponse();
                    for (Region item:regionList){
                        rList.add(item.getName());
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,rList);
                    regionSpinner.setAdapter(dataAdapter);
                }
            }
        },getActivity());
        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                regionCategory = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
    //spinner starts

    //commoditySpinner
    //region Spinn


    //spinner over

}

