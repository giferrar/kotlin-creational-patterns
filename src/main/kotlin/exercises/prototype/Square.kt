package org.example.exercises.prototype

data class Square(val side: Double = 0.0): Shape {

    override fun area(): Double {
        return side * side
    }

    override fun clone(): Shape = copy()
}
