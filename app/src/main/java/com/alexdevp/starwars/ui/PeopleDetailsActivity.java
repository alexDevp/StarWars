package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.People;

public class PeopleDetailsActivity extends AppCompatActivity {

    private TextView text_view_name;
    private TextView text_view_height;
    private TextView text_view_mass;
    private TextView text_view_hair_color;
    private TextView text_view_skin_color;
    private TextView text_view_eye_color;
    private TextView text_view_birth_year;
    private TextView text_view_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_details);
        findViews();
        People people = (People) getIntent().getExtras().get("People");
        setContents(people);
    }

    private void findViews() {
        this.text_view_name = findViewById(R.id.text_view_name_value);
        this.text_view_height = findViewById(R.id.text_view_height_value);
        this.text_view_mass = findViewById(R.id.text_view_mass_value);
        this.text_view_hair_color = findViewById(R.id.text_view_hair_color_value);
        this.text_view_skin_color = findViewById(R.id.text_view_skin_color_value);
        this.text_view_eye_color = findViewById(R.id.text_view_eye_color_value);
        this.text_view_birth_year = findViewById(R.id.text_view_birth_year_value);
        this.text_view_gender = findViewById(R.id.text_view_gender_value);
    }

    private void setContents(People people) {
        this.text_view_name.setText(people.getName());
        this.text_view_height.setText(people.getHeight());
        this.text_view_mass.setText(people.getMass());
        this.text_view_hair_color.setText(people.getHair_color());
        this.text_view_skin_color.setText(people.getSkin_color());
        this.text_view_eye_color.setText(people.getEye_color());
        this.text_view_birth_year.setText(people.getBirth_year());
        this.text_view_gender.setText(people.getGender());
    }
}