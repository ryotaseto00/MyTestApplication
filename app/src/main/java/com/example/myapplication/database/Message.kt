package com.example.myapplication.database

data class Message(
    val id: Long,
    val fromUserId: Long,
){
    var content: String = ""
    val toUserId: Long = 0L
}
