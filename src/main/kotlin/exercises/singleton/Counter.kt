package org.example.exercises.singleton

class Counter {
    private var count: Int = 0

    fun increment(): Int {
        count++
        println("Actual value of count: $count")
        return count
    }

}
