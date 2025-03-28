package org.example.exercises.singleton

class Counter private constructor() {
    private var count: Int = 0

    companion object {
        @Volatile
        private var instance: Counter? = null

        fun getInstance(): Counter {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Counter()
                    }
                }
            }
            return instance!!
        }
    }

    fun increment(): Int {
        count++
        println("Actual value of count: $count")
        return count
    }

}
