package com.example.flashlearn.ui.component

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.example.flashlearn.domain.model.MiniQuizResult
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun LearningTrendChart(quizStats: List<MiniQuizResult>) {
    AndroidView(factory = { context ->
        com.github.mikephil.charting.charts.LineChart(context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, 600)

            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val grouped = quizStats.groupBy {
                dateFormat.format(Date(it.timestamp))
            }

            val labels = mutableListOf<String>()
            val entries = grouped.entries
                .sortedBy { it.key }
                .mapIndexed { index, (date, quizzes) ->
                    labels.add(date)
                    val totalCorrect = quizzes.sumOf { it.correctAnswers }
                    Entry(index.toFloat(), totalCorrect.toFloat())  // Sử dụng Entry ở đây
                }

            val dataSet = LineDataSet(entries, "Total correct answers").apply {
                color = Color(0xFF03A9F4).toArgb()
                circleRadius = 5f
                setCircleColor(Color(0xFF0288D1).toArgb())
                lineWidth = 2f
                valueTextSize = 10f
            }

            data = LineData(dataSet)

            xAxis.valueFormatter = IndexAxisValueFormatter(labels)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            axisRight.isEnabled = false
            description.isEnabled = false

            invalidate()
        }
    })
}