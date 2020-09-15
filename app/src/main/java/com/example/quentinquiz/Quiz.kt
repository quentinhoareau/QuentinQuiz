package com.example.quentinquiz

class Quiz (var question : String, var answer1 : String, var answer2 : String, var answer3 : String, var correctAnswerNum : Int) {
    fun isCorrect(answerNum: Int) : Boolean{
        var rep : Boolean = false
        if (answerNum == correctAnswerNum ){
            rep = true;
        }
        return rep;
    }
}