package org.example.exercises.prototype

class PrototypeExercise {

    fun createClones() {
        val circle = Circle(1.0)
        val clonedCircle = cloneShape(circle)
        println("The area of the cloned circle is ${clonedCircle.area()}")

        val square = Square(1.0)
        val clonedSquare = cloneShape(square)
        println("The area of the cloned square is ${clonedSquare.area()}")
    }

    // Merge the two functions in 3 steps.
    // Step 1: extract the common code in a generic function
    // Step 2: modify the signature and return of the two functions to match the generic function
    // Step 3: call the generic function
    private fun cloneShape(shape: Shape): Shape {
        // Here we do some important operations
        return shape.clone()
    }

}
