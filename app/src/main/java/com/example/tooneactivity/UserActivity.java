package com.example.tooneactivity;import android.content.Intent;import android.os.Bundle;import android.view.View;import android.widget.Button;import android.widget.EditText;import android.widget.Toast;import androidx.appcompat.app.AppCompatActivity;public class UserActivity extends AppCompatActivity {    EditText name, email, address,userid,detailsid;    Button savebtn;    DaoSession daoSession;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.add_user);        daoSession= ((MyApplication) getApplication()).getDaoSession();        name = findViewById(R.id.editTextTextPersonName);        email = findViewById(R.id.editTextTextPersonName2);        address = findViewById(R.id.editTextTextPersonName3);        userid = findViewById(R.id.editTextTextPersonName4);        detailsid = findViewById(R.id.editTextTextPersonName5);        savebtn = findViewById(R.id.button);        savebtn.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                String profileIdString = detailsid.getText().toString();                long profileIdLong = Long.parseLong(profileIdString);                String emailString = email.getText().toString();                String addressString = address.getText().toString();                Profile profile = new Profile(profileIdLong, emailString, addressString);                if (name.getText().toString().trim().length() == 0|| email.getText().toString().trim().length() == 0 || address.getText().toString().trim().length() == 0 ) {                    Toast.makeText(getApplicationContext(), "please fill the details", Toast.LENGTH_SHORT).show();                    return;                }                if (!isValidName(name.getText().toString())) {                    Toast.makeText(getApplicationContext(), "Invalid name", Toast.LENGTH_SHORT).show();                    return;                }                if (!isValidEmail(emailString)) {                    // Invalid email address, show an error message or take appropriate action                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();                    return;                }                daoSession.getProfileDao().insert(profile);                User user = new User();                String userIdString = userid.getText().toString();                long userIdLong = Long.parseLong(userIdString);                user.setId(userIdLong);                user.setName(name.getText().toString().trim());                user.setProfile(profile);                daoSession.getUserDao().insert(user);                Intent i = new Intent(getApplicationContext(), MainActivity.class);                startActivity(i);            }            public boolean isValidEmail(CharSequence email) {                if (email == null) {                    return false;                } else {                    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();                }            }            private boolean isValidName(String name) {                if (name == null || name.trim().isEmpty()) {                    return false; // name is empty or contains only whitespace                }                if (name.length() > 50) {                    return false; // name is too long                }                String regex = "^[a-zA-Z ]+$"; // regular expression for letters and spaces only                return name.matches(regex);            }        });    }    }