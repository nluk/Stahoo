package pl.grupowy.stahoo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_view_operation.*

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.fragments.adapters.SubOperationAdapter
import java.text.SimpleDateFormat


class ViewOperationFragment : BaseFragment() {


    @LayoutRes
    override fun layoutRes(): Int = R.layout.fragment_view_operation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()

        arguments?.get("operationId").run {
            //val operation = TODO("Get operation by id")
            //setUpDisplay(operation)

        }
    }

    private fun setListeners() {
        back_to_list.setOnClickListener { findNavController().navigate(R.id.action_view_back_to_list) }
    }

    private fun setUpDisplay(operation: MainOperation) {
        //operation_cyclicity.text = resources.getStringArray(R.array.operation_cyclic)[operation.cycleType]
        operation_amount.text = operation.amount.toString()
        operation_description.text = operation.description
        operation_category.text = resources.getStringArray(R.array.categories)[operation.category]
        operation_name.text = operation.name
        operation_date.text = SimpleDateFormat("dd-MM-yyyy").format(operation.dateTime)
        val adapter =  SubOperationAdapter(operation.partials,{})
        split_recycler.adapter = adapter
        split_recycler.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()

    }


}
