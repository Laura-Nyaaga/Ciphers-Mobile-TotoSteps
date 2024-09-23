package com.akirachix.totosteps.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.widget.RadioButton

import com.akirachix.totosteps.databinding.ActivityAssessmentOptionsBinding

class AssessmentOptionsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAssessmentOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssessmentOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backArrow.setOnClickListener {
            finish()
        }
        val btnProceed = binding.btnProceed
        val assessmentOptionsGroup = binding.rgOptions

        btnProceed.setOnClickListener {
            val selectedOptionId = assessmentOptionsGroup.checkedRadioButtonId

            // Check if any option is selected
            if (selectedOptionId != -1) {
                val selectedOption = findViewById<RadioButton>(selectedOptionId)

                if (selectedOption.text == "Questionnaire") {
                    proceedToQuestionnaire() // Call method to proceed to Questionnaire screen
                } else if (selectedOption.text == "Image Upload") {
                    proceedToImageUpload() // Call method to proceed to Image Upload screen
                }
//                val selectedOption: RadioButton = findViewById(selectedOptionId)

            } else {
                // Show message to select an assessment option
                Toast.makeText(this, "Please select the assessment option", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun proceedToImageUpload() {
        val intent = Intent(this, ParentsAgreementActivity::class.java)
        startActivity(intent)
        Toast.makeText(this, "Proceeding to Image Upload", Toast.LENGTH_SHORT).show()
    }

    fun proceedToQuestionnaire() {
        val intent = Intent(this, DevelopmentalMilestonesScreenOne::class.java)
        startActivity(intent)
        Toast.makeText(this, "Proceeding to Questionnaire", Toast.LENGTH_SHORT).show()
    }
}

