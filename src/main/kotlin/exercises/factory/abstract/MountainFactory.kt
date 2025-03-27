package org.example.exercises.factory.abstract

class MountainFactory : GameFactory {
    override fun createTerrain(): Terrain {
        return Mountain()
    }

    override fun createVegetation(): Vegetation {
        return Grass()
    }

    override fun createGame(difficulty: Difficulty): Game {
        return Game(createTerrain(), createVegetation(), difficulty)
    }

}
