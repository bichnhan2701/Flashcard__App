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
    AndroidView(factory = { context ->
        BarChart(context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, 600)

            val rememberedEntries = ArrayList<BarEntry>()
            val remainingEntries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            categories.forEachIndexed { index, category ->
                rememberedEntries.add(BarEntry(index.toFloat(), category.rememberedCards.toFloat()))
                remainingEntries.add(BarEntry(index.toFloat(), (category.totalCards - category.rememberedCards).toFloat()))
                labels.add(category.categoryName)
            }

            val dataSet1 = BarDataSet(rememberedEntries, "Đã nhớ").apply {
                color = Color(0xFF4CAF50).toArgb()
            }
            val dataSet2 = BarDataSet(remainingEntries, "Chưa nhớ").apply {
                color = Color(0xFFFF5722).toArgb()
            }
            val barData = BarData(dataSet1, dataSet2)
            barData.barWidth = 0.4f

            // Gán dữ liệu vào biểu đồ trước khi gọi groupBars
            data = barData
            // Gọi groupBars sau khi đã gán dữ liệu vào biểu đồ
            groupBars(0f, 0.2f, 0.05f)
            // Cấu hình trục X
            xAxis.valueFormatter = IndexAxisValueFormatter(labels)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            xAxis.setCenterAxisLabels(true)
            xAxis.axisMinimum = 0f
            // Tắt trục Y bên phải
            axisRight.isEnabled = false
            // Hiển thị legend
            legend.isEnabled = true
            description.isEnabled = false
            // Cập nhật lại biểu đồ
            invalidate()
        }
    })
}
