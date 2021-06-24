package com.example.myapplication.database

data class User(
    val id :Long,
    var userName: String,
    var age :Int,
    var region: String,
){
    var online: Boolean = false
    var photoURL: String = ""
    var waitingVoiceCall: Boolean = false
    var waitingVideoCall: Boolean = false
    var waitingSokuden: Boolean = false
    var selfIntroduction: String = "初めまして。"
    var style: String = "普通"
    var marriageHistory: String = "未婚"
    var kaodashi: String = "顔出しNG"
}
