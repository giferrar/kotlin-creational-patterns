package org.example.exercises.factory.abstract

class DesertFactory : GameFactory {
    override fun createTerrain(): Terrain {
        return Dune()
    }

    override fun createVegetation(): Vegetation {
        return Cactus()
    }

    override fun createGame(difficulty: Difficulty): Game {
        return Game(createTerrain(), createVegetation(), difficulty)
    }

}
