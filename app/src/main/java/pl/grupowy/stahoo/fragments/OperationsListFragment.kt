package pl.grupowy.stahoo.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_year_select.*
import kotlinx.android.synthetic.main.fragment_operations_list.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.application.App
import pl.grupowy.stahoo.database.repositories.OperationRepository
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.fragments.adapters.OperationsListAdapter
import pl.grupowy.stahoo.fragments.dialogs.MonthSelectorDialog
import pl.grupowy.stahoo.fragments.dialogs.OperationActionDialog
import pl.grupowy.stahoo.network.response.users.UserOperationsResponse
import pl.grupowy.stahoo.network.services.OperationsService
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class OperationsListFragment : BaseFragment() {

    val operationsList: MutableList<MainOperation> = ArrayList<MainOperation>()
    var operationMonth: Int = 0
    var operationYear: Int = 0
    var operationsListAdapter: OperationsListAdapter? = null

    @Inject
    lateinit var operationsService: OperationsService

    @Inject
    lateinit var operationRepository: OperationRepository

    @LayoutRes
    override fun layoutRes(): Int = R.layout.fragment_operations_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun setAdapter() {

        val adapterOnClick = object : OperationsListAdapter.ClickCallback {
            override fun onItemClick(position: Int) {
                val operation = operationsList[position]
                OperationActionDialog(context!!,
                    deleteAction = {
                        //TODO("Add operation deleting")
                    },
                    editAction = {
                        findNavController().navigate(R.id.action_add_or_edit_operation, Bundle().apply {
                            putInt("operationId", operation.id)
                        })
                    },
                    viewAction = {
                        findNavController().navigate(R.id.action_view_operation, Bundle().apply {
                            putInt("operationId", operation.id)
                        })
                    }
                ).show()
            }
        }
        operationsListAdapter = OperationsListAdapter(operationsList, adapterOnClick)
        operations_recycler.adapter = operationsListAdapter
        operations_recycler.layoutManager = LinearLayoutManager(context)
    }

    private fun init() {

        fetchData()
        setListeners()
        setAdapter()
        getInitialYearAndMonth()
        refresh()
    }

    @SuppressLint("CheckResult")
    private fun fetchData() {
        if (App.store!!.authUserId == 0) {
            return
        }

        operationsService.getUserOperations(App.store!!.authUserId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ saveOperationsInDb(it) }, { it.printStackTrace() })
    }

    private fun saveOperationsInDb(operations: List<UserOperationsResponse>) {
        if (operations.isNotEmpty()) {
            operations.forEach {
                val operation = MainOperation().apply {
                    id = it.id
                    costOwnerId = it.fromUser
                    amount = it.amount
                    name = it.name
                    description = it.description
                    category = it.category
                    isDivided = it.partials.isNotEmpty()
                    isCyclical = it.cycleType > 0
//                    dateTime = SimpleDateFormat("dd-MM-yyyy").parse(it.dateTime)
                }
                operationRepository.save(operation)
            }
        }
    }

    private fun setListeners() {
        operations_month_selector.setOnClickListener {
            getMonthFromDialog()
        }
        operations_year_selector.setOnClickListener {
            getYearFromDialog()
        }
        add_operation_fab.setOnClickListener {
            findNavController().navigate(R.id.action_add_or_edit_operation)
        }

        operations_recycler.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 && add_operation_fab.visibility == View.VISIBLE) {
                        add_operation_fab.hide()
                    } else if (dy < 0 && add_operation_fab.visibility != View.VISIBLE) {
                        add_operation_fab.show()
                    }
                }
            }
        )
    }

    private fun fetchDataFromDB() {
        //TODO("Dodać wyciąganie z bazy na podstawie daty")
//        operationsList.addAll(DB.operationsFromDate(operationMonth, operationYear))
//        operationsList.addAll(operationRepository.findByMonthAndYear(Date()))
        operationsList.addAll(operationRepository.findAll())
        operationsListAdapter?.notifyDataSetChanged()
    }

    private fun getInitialYearAndMonth() {
        val calendar = Calendar.getInstance()
        operationMonth = calendar[Calendar.MONTH]
        operationYear = calendar[Calendar.YEAR]
    }

    private fun displayDate() {
        operations_month_selector.text = resources.getStringArray(R.array.months_array)[operationMonth]
        operations_year_selector.text = operationYear.toString()
    }

    private fun getYearFromDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_year_select, null)
        AlertDialog.Builder(context!!)
            .setTitle(R.string.select_year)
            .setView(dialogView)
            .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.cancel() }
            .setPositiveButton(R.string.select) { dialog, _ ->
                operationYear = (dialog as AlertDialog).operation_year_value.text.toString().toInt()

            }
            .create().show()
    }

    private fun getMonthFromDialog() {
        MonthSelectorDialog(context!!, object : MonthSelectorDialog.OnMonthSelectedHandler {
            override fun onMonthSelected(whichMonth: Int) {
                operations_month_selector.text = resources.getStringArray(R.array.months_array)[whichMonth]
                operationMonth = whichMonth
            }
        }).show()
    }

    private fun refresh() {
        displayDate()
        fetchDataFromDB()
        operationsListAdapter?.notifyDataSetChanged()
    }


}
