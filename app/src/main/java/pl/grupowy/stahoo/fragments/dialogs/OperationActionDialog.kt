package pl.grupowy.stahoo.fragments.dialogs

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.dialog_operation_actions.*
import kotlinx.android.synthetic.main.dialog_operation_actions.view.*

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation

typealias ActionHandler = () -> Unit

class OperationActionDialog(context : Context, val deleteAction: ActionHandler, val editAction : ActionHandler, val viewAction : ActionHandler) : AlertDialog(context){
    var dialogView : View  = LayoutInflater.from(context).inflate(R.layout.dialog_operation_actions,null)
    val dialog : AlertDialog = AlertDialog.Builder(context)
        .setTitle(R.string.operation_actions)
        .setView(dialogView)
        .create()

    init {
        setListeners()
    }

    override fun show() {
        dialog.show()
    }

    private fun setListeners() {
        dialogView.edit_operation.setOnClickListener {
            editAction()
            dialog.dismiss()
        }
        dialogView.view_operation.setOnClickListener {
           viewAction()
            dialog.dismiss()
        }
        dialogView.delete_operation.setOnClickListener {
            deleteAction()
            dialog.dismiss()
        }
    }

    interface DeleteAction{
        fun deleteOperation(operation : MainOperation)
    }
}