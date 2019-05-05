package pl.grupowy.stahoo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation


class OperationHandlerFragment : Fragment() {
    private var listener: OperationStatusListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operation_handler, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OperationStatusListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OperationStatusListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OperationStatusListener {
        // TODO: Update argument type and name
        fun onStatusChanged(mainOperation: MainOperation)
    }

}
