package org.example.exercises.singleton

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

class SingletonExercise {

    private var counter: Counter = Counter.getInstance()

    fun useCounter() {
        assertThat(counter.increment(), `is`(1))

        // Now it works because Counter is a Singleton!
        assertThat(AnotherClass().useAnotherCounter(), `is`(2))
    }

    inner class AnotherClass {
        private var anotherCounter: Counter = Counter.getInstance()

        fun useAnotherCounter(): Int {
            return anotherCounter.increment()
        }
    }
}
