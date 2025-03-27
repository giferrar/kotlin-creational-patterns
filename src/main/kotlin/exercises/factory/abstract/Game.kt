package org.example.exercises.factory.abstract

class Game (private val terrain: Terrain, private val vegetation: Vegetation, private val difficulty: Difficulty) {

    fun play() {
        println("Play game with terrain ${terrain.getDescription()}, vegetation ${vegetation.getDescription()} and difficulty $difficulty")
    }
}
