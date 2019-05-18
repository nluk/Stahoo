package pl.grupowy.stahoo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_add_edit_operation.*

import pl.grupowy.stahoo.R


class AddEditOperationFragment : BaseFragment() {

    @LayoutRes
    override fun layoutRes(): Int = R.layout.fragment_add_edit_operation


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
       cancel.setOnClickListener { findNavController().navigate(R.id.action_addedit_operation_back_to_list) }
    }


}
