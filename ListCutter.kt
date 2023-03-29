package com.example.lab1_borisova

class ListCutter {

    // Cоздаем неизменяемый список и наполняем его 10 случайными числами от 1 до 100
    private val list: List<Int> = List(10) {(1..100).random()}

    // Функция, которая возвращает список в виде строки
    fun getList(): String{
        return list.joinToString()
    }

    // Функция, которая возвращает новый список с ограничением
    fun cut(limit: Int): List<Int> {
        val limitedlist = mutableListOf<Int>()
        list.forEach{
            if (it < limit)
                limitedlist.add(it)
        }
        return limitedlist
    }

}