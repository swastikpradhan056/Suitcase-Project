package com.example.landingpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpPage extends AppCompatActivity {
    EditText email_signup, password_signup, confirm_password_signup;
    Button signup_button;
    TextView login_link;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        email_signup = findViewById(R.id.email);
        password_signup = findViewById(R.id.password);
        confirm_password_signup = findViewById(R.id.confirm_password);
        signup_button = findViewById(R.id.sign_up);
        login_link = findViewById(R.id.login);


        firebaseAuth = FirebaseAuth.getInstance();

        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_signup.getText().toString().trim();
                String password = password_signup.getText().toString().trim();
                String confirm_password = confirm_password_signup.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(SignUpPage.this, "Please enter your email!", Toast.LENGTH_SHORT).show();
                }
                if (password.isEmpty()) {
                    Toast.makeText(SignUpPage.this, "Please enter your password!", Toast.LENGTH_SHORT).show();
                }
                if (confirm_password.isEmpty()) {
                    Toast.makeText(SignUpPage.this, "Please confirm your password!", Toast.LENGTH_SHORT).show();
                }
                if (password.equals(confirm_password)){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                                startActivity(intent);
                                Toast.makeText(SignUpPage.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(SignUpPage.this, "Failed to create account!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}