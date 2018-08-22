package com.example.ojonugwa.yfc;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EditorActivity extends AppCompatActivity {

    Context context = this;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd / MM / yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.UK);

    /** EditText field to enter the member's firstname */
    private EditText mFisrtnameEditText;

    /** EditText field to enter the member's lastname */
    private EditText mlastnameEditText;

    private EditText mDOB;

    private Spinner mFacultySpinner;

    /**
     * Gender of the Member. The possible values are:
     * 1 for male, 2 for female.
     */
    private int mGender = 0;

    private String mFaculty = "Agriculture";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        initViews();

        datePicker();

        setupFacultySpinner();
    }

    /**
     * initViews is called from onCreate to init the member variable views
     */
    private void initViews() {
        mFacultySpinner = findViewById(R.id.spinner_faculty);

        mDOB = findViewById(R.id.editDate);

    }

    private void setupFacultySpinner(){
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_faculty_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mFacultySpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mFacultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.faculty_agriculture))) {
                        mFaculty = "Agriuclture";
                    } else if (selection.equals(getString(R.string.faculty_arts_n_humanities))) {
                        mFaculty = "Arts and Humanities";
                    } else {
                        mFaculty = "Unknown";
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 0; // Unknown
            }
        });

    }

    private void setupDepartmentSpinner(){

    }


    private void datePicker() {

        // init - set date to current date
        long currentdate = System.currentTimeMillis();
        String dateString = sdf.format(currentdate);
        mDOB.setHint(dateString);

        // set calendar date and update editDate
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }

        };

// onclick - popup datepicker
        mDOB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateDate() {
        mDOB.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Do nothing for now
//                // TODO (5) Create a description variable and assign to it the value in the edit text
//                String description = mEditText.getText().toString();
//                // TODO (6) Create a priority variable and assign the value returned by getPriorityFromViews()
//                int priority = getPriorityFromViews();
//                // TODO (7) Create a date variable and assign to it the current Date
//                Date date = new Date();
//
//                // TODO (8) Create taskEntry variable using the variables defined above
//                TaskEntry taskEntry = new TaskEntry(description, priority, date);
//
//                // TODO (9) Use the taskDao in the AppDatabase variable to insert the taskEntry
//                mDb.taskDao().insertTask(taskEntry);
                // TODO (10) call finish() to come back to MainActivity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
