package com.owais.databindingbexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.owais.databindingbexercise.databinding.ActivityAddBinding;
import com.owais.databindingbexercise.db.Contact;

public class AddActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail,editTextCountry;
    private Button buttonSubmit;
    private ActivityAddBinding activityAddBinding;
    private AddActivityClickHandler addActivityClickHandler;
    private Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add);
        contact=new Contact();
        activityAddBinding= DataBindingUtil.setContentView(this,R.layout.activity_add);
        activityAddBinding.setContact(contact);
        addActivityClickHandler=new AddActivityClickHandler(this);
        activityAddBinding.setMyHandler(addActivityClickHandler);

        editTextName=findViewById(R.id.name);
        editTextEmail=findViewById(R.id.email);
        editTextCountry=findViewById(R.id.country);
        buttonSubmit=findViewById(R.id.submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editTextName.getText().toString();
                String email=editTextEmail.getText().toString();
                String country=editTextCountry.getText().toString();

                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(AddActivity.this, "plz enter your name ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(AddActivity.this, "plz enter your email ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(country)) {
                    Toast.makeText(AddActivity.this, "plz enter your country ", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent returnIntent = new Intent();
                returnIntent.putExtra("name",name);
                returnIntent.putExtra("email",email);
                returnIntent.putExtra("country",country);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });
    }

    public class AddActivityClickHandler{
        Context context;

        public AddActivityClickHandler(Context context) {
            this.context = context;
        }

        public void submitClicked(View view){
            if(TextUtils.isEmpty(contact.getName())) {
                Toast.makeText(AddActivity.this, "plz enter your name ", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(contact.getEmail())) {
                Toast.makeText(AddActivity.this, "plz enter your email ", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent returnIntent = new Intent();
            returnIntent.putExtra("name",contact.getName());
            returnIntent.putExtra("email",contact.getEmail());
            returnIntent.putExtra("country",contact.getCountry());
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }
    }
}
