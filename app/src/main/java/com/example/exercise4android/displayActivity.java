    package com.example.exercise4android;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.graphics.Color;
    import android.os.Bundle;
    import android.widget.TextView;

    public class displayActivity extends AppCompatActivity {

        private TextView details;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.details);

            details = findViewById(R.id.txtDisplay);

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            complaintForm C2 = (complaintForm) extras.getSerializable("object");




            details.setText("*********COMPLAINT FORM*******" +
                    "**********\n"+"Name of Complainer:    "+C2.getSuffix()+ " "+C2.getFirstname()+" "+C2.getLastname()+"\nEmployment status:    "+C2.getEmpstatus()+"\nDesignation:    "+C2.getDesignation()+"\nStreet no:    "+C2.getStreetNo()+"\nStreet Name:    "+C2.getStreetName()+"\nProvince:    "+
                    C2.getEmpstatus()+"\nCity:    "+C2.getCity()+"\nCountry:    "+C2.getCountry()+"\nPostal code:    "+C2.getPostalcode()+"\nEmail:    "+C2.getEmailid()+"\nCountry Code:    "+C2.getCountryCode()
            +"\nCell Number:    "+C2.getCellNumber()+"\nComplaint Issue Date:    "+C2.getIssuedate()+"\nIssues:    "+C2.getIssuetype()+"\nSeverity:    "+C2.getSevirty()+"\nDetailed Description:    "+C2.getDetailedDesc());
            details.setTextColor(Color.BLACK);
            details.setTextSize(18);





        }
    }
