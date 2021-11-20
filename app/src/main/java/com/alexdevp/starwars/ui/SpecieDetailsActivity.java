package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Specie;

public class SpecieDetailsActivity extends AppCompatActivity {

    private TextView text_view_name;
    private TextView text_view_classification;
    private TextView text_view_designation;
    private TextView text_view_average_height;
    private TextView text_view_skin_colors;
    private TextView text_view_hair_colors;
    private TextView text_view_eye_colors;
    private TextView text_view_average_lifespan;
    private TextView text_view_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specie_details);
        findViews();
        Specie specie = (Specie) getIntent().getExtras().get("Specie");
        setContents(specie);
    }

    private void findViews() {
        this.text_view_name = findViewById(R.id.text_view_name_value);
        this.text_view_classification = findViewById(R.id.text_view_classification_value);
        this.text_view_designation = findViewById(R.id.text_view_designation_value);
        this.text_view_average_height = findViewById(R.id.text_view_average_height_value);
        this.text_view_skin_colors = findViewById(R.id.text_view_skin_colors_value);
        this.text_view_hair_colors = findViewById(R.id.text_view_hair_colors_value);
        this.text_view_eye_colors = findViewById(R.id.text_view_eye_colors_value);
        this.text_view_average_lifespan = findViewById(R.id.text_view_average_lifespan_value);
        this.text_view_language = findViewById(R.id.text_view_language_value);
    }

    private void setContents(Specie specie) {
        this.text_view_name.setText(specie.getName());
        this.text_view_classification.setText(specie.getClassification());
        this.text_view_designation.setText(specie.getDesignation());
        this.text_view_average_height.setText(specie.getAverage_height());
        this.text_view_skin_colors.setText(specie.getSkin_colors());
        this.text_view_hair_colors.setText(specie.getHair_colors());
        this.text_view_eye_colors.setText(specie.getEye_colors());
        this.text_view_average_lifespan.setText(specie.getAverage_lifespan());
        this.text_view_language.setText(specie.getLanguage());

    }
}