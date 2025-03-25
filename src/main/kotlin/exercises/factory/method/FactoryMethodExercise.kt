package org.example.exercises.factory.method

class FactoryMethodExercise {

    private var order: ArrayList<Pizza> = arrayListOf()

    fun createTableOrder() {
        order.add(CheesePizza(Size.MEDIUM))
        order.add(SalamiPizza(Size.SMALL))
        order.add(VeggiePizza(Size.LARGE))

        order.forEach { pizza ->
            pizza.bake()
        }
    }
}
