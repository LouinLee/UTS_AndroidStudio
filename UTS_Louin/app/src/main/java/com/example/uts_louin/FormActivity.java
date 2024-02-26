package com.example.uts_louin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText editName, editStudentID, editMajor, editYear, editCampus;
    private Spinner spinnerStatus;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initializeViews();
        setupSpinner();
        setupSubmitButton();
    }

    private void initializeViews() {
        editName = findViewById(R.id.editName);
        editStudentID = findViewById(R.id.editStudentID);
        editMajor = findViewById(R.id.editMajor);
        editYear = findViewById(R.id.editYear);
        editCampus = findViewById(R.id.editCampus);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        submitButton = findViewById(R.id.submit_button);
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);
    }

    private void setupSubmitButton() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmitButton();
            }
        });
    }

    private void handleSubmitButton() {
        String name = editName.getText().toString();
        String studentID = editStudentID.getText().toString();
        String major = editMajor.getText().toString();
        String year = editYear.getText().toString();
        String campus = editCampus.getText().toString();
        String status = spinnerStatus.getSelectedItem().toString();

        String message = "Name: " + name + "\nStudent ID: " + studentID + "\nMajor: " + major + "\nYear: " + year + "\nStatus: " + status + "\nCampus: " + campus;

        // Inflate the custom layout
        View toastLayout = getLayoutInflater().inflate(R.layout.custom_toast, null);

        // Set the text of the TextView in the custom layout
        TextView textView = toastLayout.findViewById(R.id.custom_toast_text);
        textView.setText(message);

        // Create and show the Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();

        // Create an Intent for starting MainActivity
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        // Start MainActivity
        startActivity(intent);
        // Optionally, finish this activity if you don't want it to remain in the back stack
        finish();
    }
}
