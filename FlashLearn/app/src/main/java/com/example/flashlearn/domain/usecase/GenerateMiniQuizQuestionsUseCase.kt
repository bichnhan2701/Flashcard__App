package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.model.MiniQuizQuestion
import javax.inject.Inject

class GenerateMiniQuizQuestionsUseCase @Inject constructor() {
    operator fun invoke(flashcards: List<Flashcard>, questionCount: Int = 10): List<MiniQuizQuestion> {
        val questions = mutableListOf<MiniQuizQuestion>()
        val shuffledFlashcards = flashcards.shuffled().take(questionCount)

        for (flashcard in shuffledFlashcards) {
            val correctAnswer = flashcard.term
            val definition = flashcard.definition

            // Lấy 3 đáp án sai
            val incorrectOptions = flashcards
                .filter { it.term != correctAnswer }
                .shuffled()
                .take(3)
                .map { it.term }

            // Trộn đáp án
            val allOptions = (incorrectOptions + correctAnswer).shuffled()

            questions.add(
                MiniQuizQuestion(
                    flashcardId = flashcard.id,
                    definition = definition,
                    options = allOptions,
                    correctAnswer = correctAnswer
                )
            )
        }

        return questions
    }
}