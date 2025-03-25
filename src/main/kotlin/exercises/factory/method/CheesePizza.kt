package org.example.exercises.factory.method

class CheesePizza(private var size: Size): Pizza() {
    override fun bake() {
        println("Cooking a cheese pizza of size $size")
    }
}
