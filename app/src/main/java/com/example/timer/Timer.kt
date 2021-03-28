package com.example.timer

class Timer() {
    var hour:Int = 0
    var minute:Int = 0
    var second:Int = 0
    constructor(h:Int, m:Int, s:Int): this(){
        this.hour = h
        this.minute = m
        this.second = s
    }

    fun add(){
        if(this.second == 60){
            minute++
            second = 0
        }
        if(this.minute == 60){
            hour++
            minute = 0
            second = 0
        }
        second++
    }

    fun getTime():String{
        var res= ""

        if(this.hour < 10) res += "0${this.hour}" else res += this.hour
        res += ":"
        if(this.minute < 10) res += "0${this.minute}" else res += this.minute
        res += ":"
        if(this.second < 10) res += "0${this.second}" else res += this.second

        return res
    }
}