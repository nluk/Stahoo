package pl.grupowy.stahoo.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.annotation.LayoutRes
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dialog_year_select.*
import kotlinx.android.synthetic.main.fragment_add_edit_operation.*

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.fragments.adapters.SubOperationAdapter
import pl.grupowy.stahoo.models.SubOperation
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class AddEditOperationFragment : BaseFragment(),DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.run {
            if(parent.id==operation_categories.id) operation.category = position
            //else if(parent.id == operation_cyclicity.id) operation.cycleType = position
        }
    }


    @LayoutRes
    override fun layoutRes(): Int = R.layout.fragment_add_edit_operation


    val editMode = arguments?.getInt("operationId") != null
    var operation = MainOperation()

    val subOperations : MutableList<SubOperation> = ArrayList()
    val subOperationAdapter = SubOperationAdapter(subOperations,
        onSubOperationClick = {subOperation ->
            //TODO("Add edit suboperation dialog")
        })


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        checkFragmentMode()
        setupFields()
        setAdapters()
    }

    private fun setupFields() {
        operation_date.setText(SimpleDateFormat("dd-MM-yyyy").format(operation.dateTime))
        operation_amount.setText(operation.amount.toString())
        //operation_cyclicity.setSelection(operation.cycleType)
        operation_categories.setSelection(operation.category)
        operation_description.setText(operation.description)
        subOperations.addAll(operation.partials)
    }

    private fun checkFragmentMode() {
        setButtonText()
        getEvent()
    }



    private fun getEvent() {
        //TODO("Get operation by id")
        /*if (editMode) {
         operation = DB.getOperationByID(arguments?.getInt("operationId"))
         setupFields()
        }*/
    }

    private fun setAdapters() {
        split_recycler.adapter = subOperationAdapter
        split_recycler.layoutManager = LinearLayoutManager(context)

        val categoriesAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.categories))
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        operation_categories.adapter = categoriesAdapter
        operation_categories.onItemSelectedListener = this

        val cycleTypeAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.operation_cyclic))
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        operation_cyclicity.adapter = cycleTypeAdapter
        operation_cyclicity.onItemSelectedListener = this
    }

    private fun setButtonText() {
        if(editMode) add_save_operation.setText(R.string.save)
        else add_save_operation.setText(R.string.add)
    }


    private fun gatherData(){
        operation.apply {
            amount = operation_amount.text.toString().toDouble()
            partials = subOperations
            name = operation_name.text.toString()
            description = operation_description.text.toString()
            category = operation_categories.selectedItemPosition
            dateTime = SimpleDateFormat("dd-MM-yyyy").parse(operation_date.text.toString())
        }
    }


    private fun setListeners() {
       cancel.setOnClickListener { findNavController().navigate(R.id.action_addedit_operation_back_to_list) }
        if (editMode) add_save_operation.setOnClickListener { saveOperationChanges() }
        else add_save_operation.setOnClickListener { addOperation() }
        add_split.setOnClickListener{
            //TODO("Add split dialog")
        }
        operation_date.setOnClickListener {
            val calendar =  Calendar.getInstance()
            val currentMonth = calendar[Calendar.MONTH]
            val currentYear = calendar[Calendar.YEAR]
            val currentDay = calendar[Calendar.DAY_OF_MONTH]
            DatePickerDialog(context,R.style.AppTheme,this,currentYear,currentMonth,currentDay).show()
        }

    }

    private fun addOperation() {

        //TODO("Add operation logic")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        operation.dateTime = Calendar.getInstance().apply {
            set(Calendar.YEAR,year)
            set(Calendar.MONTH,month)
            set(Calendar.DAY_OF_MONTH,dayOfMonth)
        }.time

        operation_date.setText(SimpleDateFormat("dd-MM-yyyy").format(operation.dateTime))
    }

    private fun saveOperationChanges(){
        //TODO("Save operation changes")
    }


}
