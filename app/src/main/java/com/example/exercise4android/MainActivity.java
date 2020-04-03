package com.example.exercise4android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView detailDescription;



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
        detailDescription = findViewById(R.id.txtdescription);
        submit = findViewById(R.id.btnSubmit);

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
                String DetailDescription = detailDescription.getText().toString();

                Intent mIntent = new Intent(MainActivity.this, displayActivity.class);
                Bundle extras = new Bundle();

                extras.putString("SuFix",selectedItem);
                extras.putString("firstName",firstName);
                extras.putString("lastName",lastName);
                extras.putString("empStatus",selectedempItem);
                extras.putString("Desgs",selecteddesgItem);
                extras.putString("StreetNo",StreetNo);
                extras.putString("StreetName",StreetName);
                extras.putString("Province",Province);
                extras.putString("City",City);
                extras.putString("Country",Country);
                extras.putString("Postalcode",Postalcode);
                extras.putString("Email",Email);
                extras.putString("Countrycode",Countrycode);
                extras.putString("Cellnumber",Cellnumber);
                extras.putString("Issues",selectedissueItem);
                extras.putString("DetailDescription",DetailDescription);
                mIntent.putExtras(extras);
                startActivity(mIntent);
             

            }
        });



    }


}
