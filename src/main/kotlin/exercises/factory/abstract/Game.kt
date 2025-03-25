package org.example.exercises.factory.abstract

class Game {
    private var terrain: Terrain = Mountain()
    private var vegetation: Vegetation = Grass()
    private var difficulty: Difficulty = Difficulty.EASY

    fun play() {
        println("Play game with terrain ${terrain.getDescription()}, vegetation ${vegetation.getDescription()} and difficulty $difficulty")
    }
}
