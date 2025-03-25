package org.example.exercises.singleton

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

class SingletonExercise {

    private var counter: Counter = Counter()

    fun useCounter() {
        assertThat(counter.increment(), `is`(1))

        // This is not working because Counter is not a Singleton!
        assertThat(AnotherClass().useAnotherCounter(), `is`(2))
    }

    inner class AnotherClass {
        private var anotherCounter: Counter = Counter()

        fun useAnotherCounter(): Int {
            return anotherCounter.increment()
        }
    }
}
