package pl.grupowy.stahoo.fragments

import android.content.Context
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation

class OperationHandlerFragment : BaseFragment() {
    private var listener: OperationStatusListener? = null

    override fun layoutRes(): Int = R.layout.fragment_operation_handler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OperationStatusListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OperationStatusListener")
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
