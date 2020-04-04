package com.example.exercise4android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private String[] suffixarray;
    private String[] empstatusarray;
    private String[] designationarray;
    private String[] issuearray;
    private Spinner suffixsp;
    private Spinner empStatusSp;
    private Spinner designation;
    private Spinner issue;
    private TextView firstname;
    private TextView lastname;
    private TextView streetNo;
    private TextView streetName;
    private TextView province;
    private TextView city;
    private TextView country;
    private TextView postalcode;
    private TextView email;
    private TextView countrycode;
    private  TextView cellnumber;
    private TextView Datetxt;
    private RatingBar ratingbar;
    private TextView detailDescription;
    private Button CLear;



    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        suffixarray = getResources().getStringArray(R.array.suffix);
        empstatusarray = getResources().getStringArray(R.array.employment);
        designationarray = getResources().getStringArray(R.array.designation);
        issuearray = getResources().getStringArray(R.array.issue);
        suffixsp = findViewById(R.id.suffix);
        empStatusSp = findViewById(R.id.spEmpStatus);
        designation = findViewById(R.id.spDesignation);
        issue = findViewById(R.id.spIssue);
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        streetNo = findViewById(R.id.st_no);
        streetName = findViewById(R.id.streetname);
        province = findViewById(R.id.txtProvince);
        city = findViewById(R.id.txtCity);
        country = findViewById(R.id.txtCountry);
        postalcode = findViewById(R.id.txtPostalCode);
        email = findViewById(R.id.txt_Email);
        countrycode = findViewById(R.id.txtCountrycode);
        cellnumber = findViewById(R.id.txtCellNo);
        Datetxt = findViewById(R.id.txtdate);
        detailDescription = findViewById(R.id.txtdescription);
        submit = findViewById(R.id.btnSubmit);
        ratingbar = findViewById(R.id.ratingBar);
        CLear = findViewById(R.id.btnClear);

        ArrayAdapter<String>mStringArrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, suffixarray);

        suffixsp.setAdapter(mStringArrayAdapter);
        suffixsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, suffixarray[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String>eStringArrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, empstatusarray);

        empStatusSp.setAdapter(eStringArrayAdapter);
        empStatusSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, empstatusarray[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String>sStringArrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, designationarray);

        designation.setAdapter(sStringArrayAdapter);
        designation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, designationarray[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String>iStringArrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, issuearray);

        issue.setAdapter(iStringArrayAdapter);
        issue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, issuearray[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        final Calendar myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                Datetxt.setText(sdf.format(myCalendar.getTime()));

            }

        };

        Datetxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(final RatingBar ratingBar, final float rating, final boolean fromUser) {
                setCurrentRating(rating);
            }
        });








        submit.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {





                String selectedItem=suffixsp.getSelectedItem().toString();
                String selectedempItem=empStatusSp.getSelectedItem().toString();
                String selecteddesgItem=designation.getSelectedItem().toString();
                String selectedissueItem=designation.getSelectedItem().toString();
                String firstName = firstname.getText().toString();
                String lastName = lastname.getText().toString();
                String StreetNo = streetNo.getText().toString();
                String StreetName = streetName.getText().toString();
                String Province = province.getText().toString();
                String City = city.getText().toString();
                String Country = country.getText().toString();
                String Postalcode = postalcode.getText().toString();
                String Email = email.getText().toString();
                String Countrycode = countrycode.getText().toString();
                String Cellnumber = cellnumber.getText().toString();
                String selecteddate = Datetxt.getText().toString();
                String DetailDescription = detailDescription.getText().toString();


                if(firstname.getText().toString().matches("") )
                {
                   firstname.setError("enter firstname");
                }else if(lastname.getText().toString().matches(""))
                {

                    lastname.setError("enter lastname");
                }else if (streetNo.getText().toString().matches(""))
                {
                    streetNo.setError("enter streetNo");
                }else if(streetName.getText().toString().matches(""))
                {
                    streetName.setError("enter streetName");

                } else if(province.getText().toString().matches(""))
                {
                    province.setError("enter province");

                }else if(city.getText().toString().matches(""))
                {
                    city.setError("enter city");

                }else if(country.getText().toString().matches(""))
                {
                    country.setError("enter country");

                }else if(postalcode.getText().toString().matches(""))
                {
                    postalcode.setError("enter postalcode");

                }else if(email.getText().toString().matches(""))
                {
                    email.setError("enter email");

                }else if(countrycode.getText().toString().matches(""))
                {
                    countrycode.setError("enter country code");

                }else if(cellnumber.getText().toString().matches(""))
                {
                    cellnumber.setError("enter cell number");

                }else{


                        Intent mIntent = new Intent(MainActivity.this, displayActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("SuFix", selectedItem);
                        extras.putString("firstName", firstName);
                        extras.putString("lastName", lastName);
                        extras.putString("empStatus", selectedempItem);
                        extras.putString("Desgs", selecteddesgItem);
                        extras.putString("StreetNo", StreetNo);
                        extras.putString("StreetName", StreetName);
                        extras.putString("Province", Province);
                        extras.putString("City", City);
                        extras.putString("Country", Country);
                        extras.putString("Postalcode", Postalcode);
                        extras.putString("Email", Email);
                        extras.putString("Countrycode", Countrycode);
                        extras.putString("Cellnumber", Cellnumber);
                        extras.putString("pickedDate", selecteddate);
                        extras.putString("Issues", selectedissueItem);
                        extras.putString("DetailDescription", DetailDescription);
                        extras.putFloat("rating", ratingbar.getRating());
                        mIntent.putExtras(extras);
                        startActivity(mIntent);


                    }
             

            }
        });


        CLear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstname.setText("");
                lastname.setText("");
                streetNo.setText("");
                streetName.setText("");
                province.setText("");
                city.setText("");
                country.setText("");
                postalcode.setText("");
                email.setText("");
                countrycode.setText("");
                cellnumber.setText("");
                Datetxt.setText("");
                detailDescription.setText("");





            }
        });




    }

    private void setCurrentRating(float rating) {
        LayerDrawable drawable = (LayerDrawable)ratingbar.getProgressDrawable();
        if(drawable!=null) {
            switch (Math.round(rating)) {
                case 1:
                    drawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.cyan),PorterDuff.Mode.SRC_ATOP);
                    break;
                case 2:
                    drawable.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    break;
                case 3:
                    drawable.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                    break;
                case 4:
                    drawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.orange),PorterDuff.Mode.SRC_ATOP);
                    break;
                case 5:
                    drawable.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
            }

        }
    }


}
