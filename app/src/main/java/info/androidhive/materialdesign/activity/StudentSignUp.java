package info.androidhive.materialdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import info.androidhive.materialdesign.R;

public class StudentSignUp extends AppCompatActivity {

    Spinner year, setion, group;
    EditText name, phone;
    String Uname, Uphone, Uyear, Usection, Ugroup;
    String Name, Group, Phone, Year, Section;
    public static final String DEFAULT = "default";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);


        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        Name = sharedPreferences.getString("Name", DEFAULT);
        Phone = sharedPreferences.getString("Phone", DEFAULT);
        Group = sharedPreferences.getString("Group", DEFAULT);
        Section = sharedPreferences.getString("Section", DEFAULT);
        Year = sharedPreferences.getString("Year", DEFAULT);
        if (Name.equals(DEFAULT) || Phone.equals(DEFAULT) || Group.equals(DEFAULT) || Section.equals(DEFAULT) || Year.equals(DEFAULT)) {
            year = (Spinner) findViewById(R.id.spinner_year);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
            year.setAdapter(adapter);
            year.setPrompt("YEAR");

            group = (Spinner) findViewById(R.id.spinner_group);
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.group, android.R.layout.simple_spinner_item);
            group.setAdapter(adapter2);
            group.setPrompt("GROUP");

            setion = (Spinner) findViewById(R.id.spinner_Section);
            ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.section, android.R.layout.simple_spinner_item);
            setion.setAdapter(adapter3);
            setion.setPrompt("SECTION_NUMBER");

            name = (EditText) findViewById(R.id.name);
            phone = (EditText) findViewById(R.id.phone);
        } else {
            Intent intent = new Intent(this,StudentTabs.class);
            startActivity(intent);
        }


    }

    public void go(View view) {

        Uname = name.getText().toString();
        Uphone = phone.getText().toString();
        Ugroup = group.getSelectedItem().toString();
        Uyear = year.getSelectedItem().toString();
        Usection = setion.getSelectedItem().toString();
        if (Uname.equals("")) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
        } else if (Uphone.equals("")) {
            Toast.makeText(this, "Enter Phone ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, Ugroup + Usection + Uyear + "", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name", Uname);
            editor.putString("Phone", Uphone);
            editor.putString("Group", Ugroup);
            editor.putString("Section", Usection);
            editor.putString("Year", Uyear);
            editor.commit();


            Intent intent = new Intent(this, StudentTabs.class);
            startActivity(intent);
        }
    }
}