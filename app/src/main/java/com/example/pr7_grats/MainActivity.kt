package com.example.pr7_grats

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализируем элементы интерфейса по их ID из XML
        val editInputField: EditText = findViewById(R.id.etInputField)
        val editInputField2: EditText = findViewById(R.id.etInputField2)
        val btnSendData: Button = findViewById(R.id.btnSendData)

        // Устанавливаем слушатель нажатий на кнопку
        btnSendData.setOnClickListener {
            // Получаем текст из первого поля и удаляем лишние пробелы по краям
            val userExercise = editInputField.text.toString().trim()
            // ИСПРАВЛЕНО: Получаем текст из ВТОРОГО поля (раньше стояло editInputField)
            val userApproach = editInputField2.text.toString().trim()

            // Проверяем, не пустые ли оба поля.
            // Используем || (логическое ИЛИ), это стандартный синтаксис Kotlin
            if (userExercise.isEmpty() || userApproach.isEmpty()) {
                Toast.makeText(this, "Внимание! Поля ввода не должны быть пустыми!", Toast.LENGTH_SHORT).show()
            } else {
                // Создаем Intent для перехода во вторую активити
                val intent = Intent(this, SecondActivity::class.java)

                // Кладем данные в Intent с помощью ключей ("USER_EXERCISE" и "USER_APPROACH")
                intent.putExtra("USER_EXERCISE", userExercise)
                intent.putExtra("USER_APPROACH", userApproach)

                // Запускаем вторую активити
                startActivity(intent)
            }
        }
    }
}