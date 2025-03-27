package org.example.exercises.builder

class Cat private constructor(
    name: String = "",
    weight: Int = 0,
    cuteLevel: Int = 100,
    dangerLevel: Int? = null
) {

    class Builder {
        private var name: String = ""
        private var weight: Int = 0
        private var cuteLevel: Int = 100
        private var dangerLevel: Int? = null

        fun name(value: String): Builder {
            name = value
            return this
        }
        fun weight(value: Int): Builder {
            weight = value
            return this
        }
        fun cuteLevel(value: Int): Builder {
            cuteLevel = value
            return this
        }
        fun dangerLevel(value: Int?): Builder {
            dangerLevel = value
            return this
        }
        fun build(): Cat {
            return Cat(name, weight, cuteLevel, dangerLevel)
        }
    }

    init {
        // This is an antipattern
        check(name.isNotBlank()) { "A Cat must have a name" }
        check(weight > 0) { "The Cat's weight cannot be zero or less" }
        // If Cat constructor was a no parameters constructor, the check methods would be written inside the builder functions
        println("Cat created with name $name, weight $weight, cute level $cuteLevel and danger level $dangerLevel")
    }
}
