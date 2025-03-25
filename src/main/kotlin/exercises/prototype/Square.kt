package org.example.exercises.prototype

class Square(val side: Double = 0.0): Shape {

    override fun area(): Double {
        return side * side
    }
}
