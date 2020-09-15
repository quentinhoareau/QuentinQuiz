package com.example.quentinquiz

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz.*
import java.net.IDN

class QuizActivity : AppCompatActivity() {

    var quizs = ArrayList<Quiz>()
    var numberOfGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizs.add(Quiz("Qui a conçus cette application ?", "Michel","Quentin","Personne",2))
        quizs.add(Quiz("Quelle est la couleur du chien bleu de Quentin ?", "Noir","Blanc","Bleu",3))

        this.showQuestion(quizs.get(currentQuizIndex))
    }

    fun showQuestion(quiz: Quiz){
        txtQuestion.setText(quiz.question)
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
    }

    fun handleAnwser(anwserID: Int){
       val quiz = quizs.get(currentQuizIndex)

        if(quiz.isCorrect(anwserID)){
            numberOfGoodAnswers++
            Toast.makeText(this,"+1",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,"+0",Toast.LENGTH_SHORT).show()
        }
        currentQuizIndex++

        if(currentQuizIndex >= quizs.size){
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie terminé")
            alert.setMessage("Tu as eu: "+ numberOfGoodAnswers + " bonne(s) réponse(s).")
            alert.setPositiveButton("Ok"){dialogInterface: DialogInterface?, i: Int ->  finish() }

            alert.show()
        }else{
            showQuestion(quizs.get(currentQuizIndex))
        }

    }

    fun onClickAnswerOne(view: View){
        handleAnwser(1)
    }

    fun onClickAnswerTwo(view: View){
        handleAnwser(2)
    }

    fun onClickAnswerThree(view: View){
        handleAnwser(3)
    }
}