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
        return cloneShape(circle) as Circle
    }

    private fun cloneSquare(square: Square): Square {
        return cloneShape(square) as Square
    }

    // Merge the two functions in 3 steps.
    // Step 1: extract the common code in a generic function
    private fun cloneShape(shape: Shape): Shape {
        // Here we do some important operations
        return shape.clone()
    }

}
