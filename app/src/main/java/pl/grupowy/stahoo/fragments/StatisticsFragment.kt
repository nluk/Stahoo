package pl.grupowy.stahoo.fragments

import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_statistics.*
import pl.grupowy.stahoo.R

class StatisticsFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_statistics
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getStatisticsData()
    }

    private fun getStatisticsData() {
       // TODO("get statistics from db")
        val dataList : MutableList<BarEntry> = ArrayList(12)
        for (i in 0..11){
          //TODO("Average spending from DB")  dataList.add(BarEntry(i*1.0f,DB.averageSpendingsForMonth(i)))
            dataList.add(BarEntry(i*1.0f,(i+1)*100.0f))
        }

        val barDataSet = BarDataSet(dataList,"Spendings")
        val monthLabels = resources.getStringArray(R.array.months_array)

        val barData = BarData(barDataSet)
        barData.barWidth = 0.5f
        chart.data = barData
        //chart.setFitBars(true) // make the x-axis fit exactly all bars
        chart.xAxis.valueFormatter = IndexAxisValueFormatter(monthLabels)
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        chart.xAxis.labelRotationAngle = -90.0f;
        chart.xAxis.axisMinimum = -1.0f
        chart.xAxis.axisMaximum = 12.0f
        chart.xAxis.setLabelCount(13)

        chart.invalidate(); // refresh
    }

}
