package org.example.exercises.factory.abstract

class AbstractFactoryExercise {

    fun playGame() {
        val game = Game(Mountain(), Grass(), Difficulty.EASY)
        game.play()
    }
}
