package com.example.lab1_borisova

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Объявляем элементы интерфейса
    private lateinit var userInput : EditText
    private lateinit var generatedList: TextView
    private lateinit var listtext: TextView
    private lateinit var counttext: TextView
    private lateinit var listresult: TextView
    private lateinit var countresult: TextView
    private lateinit var resetbutton: Button

    // Объявляем объект внешнего класса
    private lateinit var cutter: ListCutter

    // Запуск приложения с этой функции
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализируем поля
        userInput = findViewById(R.id.userinput);
        generatedList = findViewById(R.id.generatedlist)
        counttext = findViewById(R.id.counttext)
        listtext = findViewById(R.id.listtext)
        listresult = findViewById(R.id.listresult)
        countresult = findViewById(R.id.countresult)
        resetbutton = findViewById(R.id.resetbutton)

        // Создаем экземпляр объекта и выводим на экран сгенерированный массив
        cutter = ListCutter()
        generatedList.setText(cutter.getList()) // он не будет меняться, пока работает программа

    }

    // Функция, которая висит на кнопке "начать"
    fun start(view: View){

        // Создаем пока пустой список
        val list: List<Int>
        // Берем значение из поля EditText
        val inputText = userInput.getText().toString()
        if(!(inputText.isEmpty())) {
            val limit = Integer.parseInt(inputText)
            // Запускаем функцию на объекте внешнего класса и на выходе получаем список элементов
            list = cutter.cut(limit)

            // Берем длину списка и выводим в текстовое поле
            counttext.setText("Количество чисел, меньше вашего:")
            countresult.setText(Integer.toString(list.size))

            // Преобразуем список в строку и выводим в текстовое поле
            listtext.setText("Список этих чисел:")
            listresult.setText(list.joinToString())

            // Показываем кнопку сброса
            resetbutton.visibility = View.VISIBLE
        }
        else { counttext.setText("Введите число от 1 до 100")}
    }

    // Функция, которая висит на кнопке "сбросить"
    fun reset(view: View){
        userInput.getText().clear()
        val fields = listOf<TextView>(counttext, countresult, listtext, listresult)
        fields.forEach{
            it.setText("")
        }
        resetbutton.visibility = View.INVISIBLE
    }
}

