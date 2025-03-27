package org.example.exercises.factory.method

class FactoryMethodExercise {

    private var order: ArrayList<Pizza> = arrayListOf()

    fun createTableOrder() {
        // We abstract from the enum Size by creating one method for every possible size
        // Now this method is independent of the different classes implementing the Pizza interface
        order.add(PizzaFactory().getMediumPizza(PizzaFactory.PizzaKind.CHEESE))
        order.add(PizzaFactory().getSmallPizza(PizzaFactory.PizzaKind.SALAMI))
        order.add(PizzaFactory().getLargePizza(PizzaFactory.PizzaKind.VEGGIE))

        order.forEach { pizza ->
            pizza.bake()
        }
    }
}
