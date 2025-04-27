package com.example.flashlearn.ui.component

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.example.flashlearn.domain.model.CategoryProgress
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.util.ArrayList

@Composable
fun CategoryProgressChart(categories: List<CategoryProgress>) {
    AndroidView(
        factory = { context ->
            BarChart(context).apply {
                layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, 600)
                description.isEnabled = false
                legend.isEnabled = true
                axisRight.isEnabled = false
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.granularity = 1f
                xAxis.setCenterAxisLabels(true)
            }
        },
        update = { chart ->
            val entries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            categories.forEachIndexed { index, category ->
                val remembered = category.rememberedCards.toFloat()
                val total = category.totalCards.toFloat()
                val remaining = (total - remembered).coerceAtLeast(0f)

                entries.add(BarEntry(index.toFloat(), floatArrayOf(remembered, remaining)))
                labels.add(category.categoryName)
            }

            val dataSet = BarDataSet(entries, "").apply {
                setColors(
                    Color(0xFF76D67A).toArgb(), // Đã nhớ - Xanh lá
                    Color(0xFFEAB866).toArgb()  // Chưa nhớ - Cam
                )
                stackLabels = arrayOf("Remembered", "Not remembered")
            }

            val barData = BarData(dataSet).apply {
                barWidth = 0.6f
            }

            chart.data = barData

            chart.xAxis.apply {
                valueFormatter = IndexAxisValueFormatter(labels)
                position = XAxis.XAxisPosition.BOTTOM
                granularity = 1f
                setDrawGridLines(false)
            }

            chart.axisLeft.axisMinimum = 0f
            chart.axisRight.isEnabled = false
            chart.description.isEnabled = false
            chart.legend.isEnabled = true

            chart.invalidate()
        }
    )
}