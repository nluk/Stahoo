package pl.grupowy.stahoo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation


class OperationsListFragment : Fragment(),OperationHandlerFragment.OperationStatusListener {
    override fun onStatusChanged(mainOperation: MainOperation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        return inflater.inflate(R.layout.fragment_operations_list, container, false)
    }


}
