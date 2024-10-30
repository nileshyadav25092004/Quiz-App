package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList<QuestionModel>()
        Firebase.firestore.collection("quiz")
            .get().addOnSuccessListener { doct ->
                for (i in duct.document) {
                    var questionModel = 1.toObject(QuestionModel::class.java)
                    list.add(questionModel!!)
                }
                binding.question.setText(list.get(0).question)
                binding.option1.setText(list.get(0).option1)
                binding.option2.setText(list.get(0).option2)
                binding.option3.setText(list.get(0).option3)
                binding.option4.setText(list.get(0).option4)
            }
        list.add(
            QuestionModel(
                "Who is Prime Minister of India ?",
                "Rahul",
                "Modi",
                "Yogi",
                "Akhilesh",
                ans = "Modi"
            )
        )
        list.add(
            QuestionModel(
                "Who is President of India ?",
                "Indra Gandhi",
                "Jawaharlal nehru",
                "Droupadi Murmu",
                "Ram Nath kovind",
                ans = "Droupadi Murmu"
            )
        )
        list.add(
            QuestionModel(
                "what is  Captial of India ?",
                "Lucknow",
                "Kolkata",
                "Mumbai",
                "Delhi",
                ans = "Delhi"
            )
        )
        list.add(
            QuestionModel(
                "What is National Animal of India ?",
                "Cow",
                "Lion",
                "Tiger",
                "Elephant",
                ans = "Lion"
            )
        )
        list.add(
            QuestionModel(
                "what is National Bird of India ?",
                "Pigeon",
                "Crow",
                "Parrot",
                "Peacock",
                ans = "Peacock"
            )
        )

             binding.question.setText(list.get(0).question)
             binding.option1.setText(list.get(0).option1)
             binding.option2.setText(list.get(0).option2)
             binding.option3.setText(list.get(0).option3)
             binding.option4.setText(list.get(0).option4)

        binding.option1.setOnClickListener {
            NextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            NextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            NextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            NextData(binding.option4.text.toString())
        }

    }

    private fun NextData(i: String) {
        if (count < list.size) {
            if (list.get(count).ans.equals(i)) {
                score++
            }
        }

        count++
        if (count >= list.size) {
            val intent = Intent(this,ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            finish()
        } else {
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }

    }

}
