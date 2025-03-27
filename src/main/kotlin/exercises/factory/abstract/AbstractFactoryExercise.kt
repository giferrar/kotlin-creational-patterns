package org.example.exercises.factory.abstract

class AbstractFactoryExercise {

    fun playGame() {
        val game = GameFactory.getFactory(GameFactory.GameType.MOUNTAIN).createGame(Difficulty.EASY)
        game.play()
    }
}
