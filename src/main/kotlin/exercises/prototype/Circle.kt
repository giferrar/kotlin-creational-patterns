package org.example.exercises.prototype

class Circle(val radius: Double = 0.0): Shape {

    override fun area(): Double {
        return Math.PI * radius * radius
    }
}
