package pl.grupowy.stahoo.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import kotlinx.android.synthetic.main.fragment_operations_list.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.fragments.adapters.OperationsListAdapter

class OperationsListFragment : BaseFragment() {

    var operationsList : MutableList<MainOperation> = ArrayList<MainOperation>()
    val operationsAdapter : OperationsListAdapter = OperationsListAdapter(operationsList)
    var operationMonth : Int = 0
    var operationYear : Int = 0


    @LayoutRes
    override fun layoutRes(): Int = R.layout.fragment_operations_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setListeners()
    }

    private fun init() {
        //TODO("Pobrac obecny rok,miesiac, pobrac dane")
        operations_recycler.adapter = operationsAdapter
        //getYearAndMonth()
        fetchDataFromDB()

    }

    private fun setListeners() {
        operations_month_selector.setOnClickListener{
            selectMonth()
            fetchDataFromDB()
        }
        operations_year_selector.setOnClickListener{
            selectYear()
            fetchDataFromDB()
        }
    }

    private fun selectYear() {
        TODO("Dialog wyboru roku") //To change body of created functions use File | Settings | File Templates.
    }

    private fun selectMonth() {
        TODO("Dialog wyboru miesiaca")
    }

    private fun fetchDataFromDB() {
        //TODO("Dodać wyciąganie z bazy na podstawie daty")
        //operationsList.addAll(DB.operationsFromDate(operationMonth,operationYear))
        //operationsAdapter.notifyDataSetChanged()
    }





}
