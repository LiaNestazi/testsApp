package com.example.testsapp.singletone

import com.example.testsapp.models.*

class SingletoneTypes private constructor() {

    var current_user = User("","Анастасия","lidzhigoriaeva@gmail.com", "Lia","",1,"","",
        mutableListOf()
    )
    var created_test = Test()

    var questions = mutableListOf<Question>()

    var current_question = Question()

    var question_types: List<QuestionType> = listOf(
        QuestionType(0,
            "Один ответ",
            "Можно выбрать только один вариант из четырех предложенных"),
        QuestionType(1,
            "Множественный ответ",
            "Можно выбрать несколько вариантов из четырех предложенных")
    )
    var test_types: List<TestType> = listOf(
        TestType(0, "Тест",
            "Один участник\nРезультат в виде оценки",
            true),
        TestType(1, "Викторина",
            "Несколько участников\nРезультат в виде турнирной таблицы",
            false)
    )
    var modes: List<TestMode> = listOf(
        TestMode(0, "Блиц",
            "Без возврата к предыдущему вопросу\nУстановка времени на ответ",
            false, true, true, true),
        TestMode(1, "Опрос",
            "С возвратом к предыдущему вопросу\nНеограниченное время на ответ",
            true, false, true, false),
        TestMode(2, "Карточки",
            "Без возврата к предыдущему вопросу\nНеограниченное время на ответ\nОтветы представлены в виде карт",
            false, false, true, true)
    )
    companion object {
        val instance = SingletoneTypes()
    }
}
