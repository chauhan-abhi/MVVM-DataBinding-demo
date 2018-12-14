package com.androidabhi.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    private val movieNames: List<String> = listOf(
        "Harry Potter", "LOTR", "The Hobbit", "Inception", "Maze Runner", "Hunger Games",
        "Iron Man", "Avengers", "DeadPool", "X-Men"
    )

    // This should be private as Mutable Live Data value should
    // only be changed inside this class
    private val _currentRandomMovieName = MutableLiveData<String>()
    val currentRandomMovieName: LiveData<String>
        get() = _currentRandomMovieName

    init {
        _currentRandomMovieName.value = movieNames.first()

    }

    fun getRandomMovieName(): String {
        val random = Random()
        return movieNames[random.nextInt(movieNames.size)]
    }

    fun changeCurrentRandomMovieName() {
        _currentRandomMovieName.value = getRandomMovieName()
    }
}