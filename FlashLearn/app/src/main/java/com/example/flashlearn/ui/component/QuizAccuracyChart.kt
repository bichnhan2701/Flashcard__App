package com.example.flashlearn.ui.component

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.example.flashlearn.domain.model.MiniQuizResult
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.util.ArrayList

@Composable
fun QuizAccuracyChart(quizStats: List<MiniQuizResult>) {
    AndroidView(factory = { context ->
        BarChart(context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, 600)

            val entries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            quizStats.forEachIndexed { index, quiz ->
                val accuracy = if (quiz.totalQuestions > 0)
                    quiz.correctAnswers.toFloat() / quiz.totalQuestions
                else 0f

                entries.add(BarEntry(index.toFloat(), accuracy * 100)) // phần trăm
                labels.add("C${quiz.categoryId}")
            }

            val dataSet = BarDataSet(entries, "Correct rate (%)").apply {
                color = Color(0xFF9C27B0).toArgb()
            }

            val barData = BarData(dataSet)
            barData.barWidth = 0.5f

            data = barData

            xAxis.apply {
                valueFormatter = IndexAxisValueFormatter(labels)
                position = XAxis.XAxisPosition.BOTTOM
                granularity = 1f
                setDrawGridLines(false)
            }

            axisLeft.axisMaximum = 100f
            axisRight.isEnabled = false
            description.isEnabled = false
            legend.isEnabled = true

            invalidate()
        }
    })
}
