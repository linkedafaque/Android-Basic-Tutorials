package com.example.afaqueahmad.relativelayoutjavacode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout main;
    Button login;
    EditText usernameValue, passwordValue;
    TextView message, username, password;
    LayoutParams messageDimensions, usernameDimensions, usernameValueDimensions, passwordDimensions, passwordValueDimensions, loginDimensions;
    int messageId = 1, usernameValueId = 2, passwordValueId = 3, usernameId = 4, passwordId = 5, loginId = 6;
    int paddingValue = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The View for the app is available here
        // setContentView(R.layout.activity_main);
        // View of the app is available in this main object
        // Hence setContentView(main);

        init();
        setContentView(main);
    }


    private void init() {
        createMainRelLayout();

        createMessageTextView();
        main.addView(message);

        createUserNameTextView();
        main.addView(username);

        createUserNameEditText();
        main.addView(usernameValue);

        createPasswordTextView();
        main.addView(password);

        createPasswordEditText();
        main.addView(passwordValue);

        createLoginButton();
        main.addView(login);
    }


    private void createMainRelLayout() {
        main = new RelativeLayout(this);
        LayoutParams mainDimensions = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        main.setLayoutParams(mainDimensions);
    }


    private void createMessageTextView() {
        message = new TextView(this);
        messageDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        message.setText("Please Login First");
        message.setLayoutParams(messageDimensions);
        message.setId(messageId);
        messageDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        message.setPadding(paddingValue, 500, paddingValue, paddingValue);
    }


    private void createUserNameTextView() {
        username = new TextView(this);
        usernameDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        usernameDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        usernameDimensions.addRule(RelativeLayout.BELOW, messageId);
        username.setText("User Name");
        username.setId(usernameId);
        username.setLayoutParams(usernameDimensions);
        username.setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
    }


    private void createUserNameEditText() {
        usernameValue = new EditText(this);
        usernameValueDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        usernameValueDimensions.addRule(RelativeLayout.RIGHT_OF, usernameId);
        usernameValueDimensions.addRule(RelativeLayout.BELOW, messageId);
        usernameValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        usernameValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE, usernameId);
        usernameValue.setId(usernameValueId);
        usernameValue.setLayoutParams(usernameValueDimensions);
    }

    private void createPasswordTextView() {
        password = new TextView(this);
        passwordDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        passwordDimensions.addRule(RelativeLayout.BELOW, usernameValueId);
        passwordDimensions.addRule(RelativeLayout.ALIGN_RIGHT, usernameId);
        password.setId(passwordId);
        password.setText("Password");
        password.setLayoutParams(passwordDimensions);
        password.setGravity(Gravity.RIGHT);
        password.setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
    }


    private void createPasswordEditText() {
        passwordValue = new EditText(this);
        passwordValueDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordValueDimensions.addRule(RelativeLayout.RIGHT_OF, passwordId);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        passwordValueDimensions.addRule(RelativeLayout.BELOW, usernameValueId);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE, passwordId);
        passwordValue.setId(passwordValueId);
        passwordValue.setLayoutParams(passwordValueDimensions);
    }

    private void createLoginButton() {
        login = new Button(this);
        loginDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        login.setText("Login");
        loginDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        loginDimensions.addRule(RelativeLayout.BELOW, passwordValueId);
        login.setLayoutParams(loginDimensions);
    }
}
