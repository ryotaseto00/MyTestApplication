package com.example.myapplication.database

data class User(
    val id :Long,
    val userName: String,
    val age :Int,
    var online: Boolean = false,
    var photoURL: String = "",
    var waitingVoiceCall: Boolean = false,
    var waitingVideoCall: Boolean = false,
    var waitingSokuden: Boolean = false,
    var selfIntroduction: String = "",
    var nickname: String = "",
    var region: String = "東京",
    var style: String = "普通",
    var marriageHistory: String = "未婚",
    var kaodashi: String = "顔出しNG",
)
