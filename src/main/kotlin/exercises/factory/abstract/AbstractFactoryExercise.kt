package org.example.exercises.factory.abstract

class AbstractFactoryExercise {

    fun playGame(gameType: GameFactory.GameType, difficulty: Difficulty) {
        val game = GameFactory.getFactory(gameType).createGame(difficulty)
        game.play()
    }
}
