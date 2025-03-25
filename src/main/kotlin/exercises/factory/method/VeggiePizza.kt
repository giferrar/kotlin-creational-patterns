package org.example.exercises.factory.method

class VeggiePizza(private var size: Size): Pizza() {
    override fun bake() {
        println("Cooking a veggie pizza of size $size")
    }
}
