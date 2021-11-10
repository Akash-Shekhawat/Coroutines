package com.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        fibonacciSeries(20)
    }
    println("Fibonacci series of 20 is:")
    Thread.sleep(10000)
}

suspend fun fibonacciSeries(num: Int) {
    var t1 = 0; var t2 = 1; var nextTerm = 0;
    for (i in 1..num) {
        print(" $t1")
        nextTerm = t1 + t2;
        t1 = t2;
        t2 = nextTerm;
        delay(300)
    }
}