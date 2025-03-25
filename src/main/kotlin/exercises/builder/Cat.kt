package org.example.exercises.builder

class Cat private constructor() {
    var name: String = ""
    var weight: Int = 0
    var cuteLevel: Int = 100
    var dangerLevel: Int? = null

    class Builder {
        private var cat = Cat()

        fun name(value: String): Builder {
            cat.name = value
            return this
        }
        fun weight(value: Int): Builder {
            cat.weight = value
            return this
        }
        fun cuteLevel(value: Int): Builder {
            cat.cuteLevel = value
            return this
        }
        fun dangerLevel(value: Int?): Builder {
            cat.dangerLevel = value
            return this
        }
        fun build(): Cat {
            return cat
        }
    }

    init {
        println("Cat created with name $name, weight $weight, cute level $cuteLevel and danger level $dangerLevel")
    }
}
