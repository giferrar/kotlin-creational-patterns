package org.example

import org.example.exercises.builder.Cat
import org.example.exercises.factory.abstract.AbstractFactoryExercise
import org.example.exercises.factory.method.FactoryMethodExercise
import org.example.exercises.prototype.PrototypeExercise
import org.example.exercises.singleton.SingletonExercise
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat


fun main() {
    // Solution to Exercise 1
    Person("John", "Doe") // Please note how optional parameters help reduce method overloading
    Person("Bob", "Doe", 25)
    // Problem: according to the printed message, Moe is not employed, because the init block is part of the primary constructor and is executed before the secondary constructor
    Person("Moe", "Doe", 40, true)
}

class Person(name: String, surname: String, age: Int = 18) {

    private var employed: Boolean = false

    constructor(name: String, surname: String, age: Int, employed: Boolean) : this(name, surname, age) {
        this.employed = employed
    }

    init {
        println("Person created with name $name $surname and age $age. $name is ${if (employed) "" else "not "}employed")
    }
}

