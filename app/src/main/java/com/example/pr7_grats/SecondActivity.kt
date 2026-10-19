package com.example.pr7_grats

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Инициализируем элементы интерфейса
        val tvReceivedText: TextView = findViewById(R.id.tvReceivedData)
        val btnBack: Button = findViewById(R.id.btnBackToMain)

        // Достаем переданные данные из Intent по тем же ключам, что и записывали
        val receivedApproach = intent.getStringExtra("USER_APPROACH")
        val receivedExercise = intent.getStringExtra("USER_EXERCISE")


        // Если данные пришли, выводим их. \n делает перенос строки для красоты.
        // Если данные не пришли (null), показываем сообщение об ошибке
        tvReceivedText.text = "Упражнение: $receivedExercise\nКоличество подходов: $receivedApproach" ?: "Данные не были переданы"


        // Обработчик нажатия на кнопку "Назад"
        btnBack.setOnClickListener {
            // Закрывает текущую активити и возвращает на предыдущий экран
            finish()
        }
    }
}