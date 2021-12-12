package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class UserAnswers(
    val firstQuestion: String,
    val secondQuestion: String,
    val thirdQuestions: String,
    val fourthQuestion: String
) : Parcelable {

}