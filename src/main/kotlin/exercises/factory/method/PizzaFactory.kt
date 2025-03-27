package org.example.exercises.factory.method

class PizzaFactory {

    enum class PizzaKind {
        CHEESE, SALAMI, VEGGIE
    }

    fun getSmallPizza(kind: PizzaKind): Pizza {
        return when (kind) {
            PizzaKind.CHEESE -> CheesePizza(Size.SMALL)
            PizzaKind.SALAMI -> SalamiPizza(Size.SMALL)
            PizzaKind.VEGGIE -> VeggiePizza(Size.SMALL)
        }
    }

    fun getMediumPizza(kind: PizzaKind): Pizza {
        return when (kind) {
            PizzaKind.CHEESE -> CheesePizza(Size.MEDIUM)
            PizzaKind.SALAMI -> SalamiPizza(Size.MEDIUM)
            PizzaKind.VEGGIE -> VeggiePizza(Size.MEDIUM)
        }
    }

    fun getLargePizza(kind: PizzaKind): Pizza {
        return when (kind) {
            PizzaKind.CHEESE -> CheesePizza(Size.LARGE)
            PizzaKind.SALAMI -> SalamiPizza(Size.LARGE)
            PizzaKind.VEGGIE -> VeggiePizza(Size.LARGE)
        }
    }
}
