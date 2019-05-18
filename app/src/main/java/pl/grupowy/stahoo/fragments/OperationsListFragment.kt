package pl.grupowy.stahoo.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.dialog_year_select.*
import kotlinx.android.synthetic.main.dialog_year_select.view.*
import kotlinx.android.synthetic.main.fragment_operations_list.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.fragments.adapters.OperationsListAdapter
import java.util.*
import kotlin.collections.ArrayList

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
        getYearAndMonth()
        displayDate()
        fetchDataFromDB()

    }

    private fun setListeners() {
        operations_month_selector.setOnClickListener{
            AlertDialog.Builder(context!!)
                .setTitle(R.string.select_month)
                .setItems(R.array.months_array) {
                        dialog, which ->
                    operationMonth = which
                    displayDate()
                }
                .setNegativeButton(R.string.cancel) { dialog, id -> dialog.cancel() }
                .create().show()
            fetchDataFromDB()
        }
        operations_year_selector.setOnClickListener{
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_year_select,null)
            AlertDialog.Builder(context!!)
                .setTitle(R.string.select_year)
                .setView(dialogView)
                .setNegativeButton(R.string.cancel) { dialog, id -> dialog.cancel() }
                .setPositiveButton(R.string.select) { dialog, id ->
                    operationYear =  (dialog as AlertDialog).operation_year_value.text.toString().toInt()
                    displayDate()
                }
                .create().show()
            fetchDataFromDB()
        }
        add_operation_fab.setOnClickListener {
            findNavController().navigate(R.id.action_add_or_edit_operation)
        }
    }



    private fun fetchDataFromDB() {
        //TODO("Dodać wyciąganie z bazy na podstawie daty")
        //operationsList.addAll(DB.operationsFromDate(operationMonth,operationYear))
        //operationsAdapter.notifyDataSetChanged()
    }

    private fun getYearAndMonth(){
        val calendar =  Calendar.getInstance()
        operationMonth = calendar[Calendar.MONTH]
        operationYear = calendar[Calendar.YEAR]
        displayDate()
    }

    private fun displayDate() {
        operations_month_selector.text = resources.getStringArray(R.array.months_array)[operationMonth]
        operations_year_selector.text = operationYear.toString()
    }


}
