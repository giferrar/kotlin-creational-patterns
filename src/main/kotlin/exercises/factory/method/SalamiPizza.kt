package org.example.exercises.factory.method

class SalamiPizza(private var size: Size): Pizza() {
    override fun bake() {
        println("Cooking a salami pizza of size $size")
    }
}
