package com.akirachix.totosteps.activity

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.totosteps.R
import com.akirachix.totosteps.databinding.ActivityDevelopmentalMilestonesScreenSixBinding

class DevelopmentalMilestonesScreenSix : AppCompatActivity() {
    lateinit var binding: ActivityDevelopmentalMilestonesScreenSixBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDevelopmentalMilestonesScreenSixBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnBackFour.setOnClickListener {
            finish()
        }

        binding.btnNextFour.setOnClickListener {
            // Handle next navigation or submission
            if (allQuestionsAnswered()) {
                var intent = Intent(this, ViewMilestoneAssessmentResults::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show()
            }
        }

        // Update progress bar as questions are answered
        updateProgressBar()
        setupRadioGroupListeners()
    }
    fun setupRadioGroupListeners() {

        val radioGroups = listOf(
            findViewById<RadioGroup>(R.id.radioGroup1),
            findViewById<RadioGroup>(R.id.radioGroup2),
            findViewById<RadioGroup>(R.id.radioGroup3)

        )

        for (radioGroup in radioGroups) {
            radioGroup.setOnCheckedChangeListener { _, _ ->
                updateProgressBar()
            }
        }
    }

    fun allQuestionsAnswered(): Boolean {
        val radioGroup1: RadioGroup = findViewById(R.id.radioGroup1)
        val radioGroup2: RadioGroup = findViewById(R.id.radioGroup2)
        val radioGroup3: RadioGroup = findViewById(R.id.radioGroup3)


        return radioGroup1.checkedRadioButtonId != -1 &&
                radioGroup2.checkedRadioButtonId != -1 &&
                radioGroup3.checkedRadioButtonId != -1

    }

    fun updateProgressBar() {
        // Update progress based on answered questions
        val totalQuestions = 3
        val answeredQuestions = listOf(R.id.radioGroup1, R.id.radioGroup2, R.id.radioGroup3)
            .count { findViewById<RadioGroup>(it).checkedRadioButtonId != -1 }

        val progress = (answeredQuestions.toFloat() / totalQuestions * 100).toInt()
        binding.progressBar.progress = progress
    }
}





