package pl.grupowy.stahoo.fragments

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation

class OperationsListFragment : BaseFragment(), OperationHandlerFragment.OperationStatusListener {

    override fun layoutRes(): Int = R.layout.fragment_operations_list

    override fun onStatusChanged(mainOperation: MainOperation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
