package org.example.exercises.prototype

class PrototypeExercise {

    fun createClones() {
        val circle = Circle(1.0)
        val clonedCircle = cloneCircle(circle)
        println("The area of the cloned circle is ${clonedCircle.area()}")

        val square = Square(1.0)
        val clonedSquare = cloneSquare(square)
        println("The area of the cloned square is ${clonedSquare.area()}")
    }

    private fun cloneCircle(circle: Circle): Circle {
        // Here we do some important operations
        return Circle(circle.radius)
    }

    private fun cloneSquare(square: Square): Square {
        // Here we do some important operations
        return Square(square.side)
    }

}
