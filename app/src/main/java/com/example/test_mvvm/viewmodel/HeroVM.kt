package com.example.test_mvvm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.test_mvvm.R
import com.example.test_mvvm.model.Hero

class HeroVM: ViewModel() {

    private val heroes = listOf(
        Hero("Петр 1",
            "Российский царь и первый император. " +
                        "Провел масштабные реформы, создал регулярную армию и флот, " +
                        "основа Санкт-Петербург.",
            "1672-1725",
            R.drawable.peter_1_oval),
        Hero("Карл 12",
            "Король Швеции и талантливый полководец. " +
                        "Возглавлял шведскую армию в годы Северной войны " +
                        "и долгое время успешно противостоял Росиии.",
            "1682-1718",
            R.drawable.karl_12_oval)
    )

    var Index by mutableStateOf(0)
        private set

    val currentHero: Hero
        get() = heroes[Index]


    fun nextHero(){
        if(Index >= heroes.size - 1)
            Index = 0
        else
            Index++
    }
}