package org.example.exercises.factory.abstract

interface GameFactory {

    enum class GameType {
        MOUNTAIN
    }

    fun createTerrain(): Terrain
    fun createVegetation(): Vegetation
    fun createGame(difficulty: Difficulty): Game

    companion object {
        fun getFactory(gameType: GameType): GameFactory {
            return when (gameType) {
                GameType.MOUNTAIN -> MountainFactory()
            }
        }
    }
}
