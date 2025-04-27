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
fun QuizFrequencyChart(quizStats: List<MiniQuizResult>) {
    AndroidView(factory = { context ->
        BarChart(context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, 600)

            val entries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            quizStats.forEachIndexed { index, quiz ->
                entries.add(BarEntry(index.toFloat(), 1f)) // mỗi quiz tương đương 1 lượt làm
                labels.add("C${quiz.categoryId}")
            }

            val dataSet = BarDataSet(entries, "Quiz times").apply {
                color = Color(0xFF2196F3).toArgb()
            }

            data = BarData(dataSet)

            xAxis.valueFormatter = IndexAxisValueFormatter(labels)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            xAxis.setDrawGridLines(false)

            axisRight.isEnabled = false
            description.isEnabled = false
            legend.isEnabled = true

            invalidate()
        }
    })
}