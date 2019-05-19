package pl.grupowy.stahoo.fragments.dialogs

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.dialog_add_split.*
import kotlinx.android.synthetic.main.dialog_add_split.view.*
import kotlinx.android.synthetic.main.dialog_invite_friend.view.*
import kotlinx.android.synthetic.main.dialog_operation_actions.*
import kotlinx.android.synthetic.main.dialog_operation_actions.view.*

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.models.SubOperation

typealias NewSplitCallback = (newSplit : SubOperation)->Unit

class AddSplitDialog(context : Context,val newSplitCallback: NewSplitCallback) : AlertDialog(context){
    var dialogView : View  = LayoutInflater.from(context).inflate(R.layout.dialog_add_split,null)
    val dialog : AlertDialog = AlertDialog.Builder(context)
        .setTitle(context.getString(R.string.add_split))
        .setView(dialogView)
        .create()

    init {
        setListeners()
        setAdapters()
    }

    private fun setAdapters() {
        //TODO("Get emails array from DB")
        //dialogView.split_user_email.setAdapter(ArrayAdapter<String>(context,android.R.layout.simple_dropdown_item_1line,DB.getEmailsList()))
    }

    override fun show() {
        dialog.show()
    }

    private fun setListeners() {
        dialogView.split_add.setOnClickListener {
            //TODO("Get userid by email")
            //val userId = DB.getUserIdByEmail(dialogView.split_user_email.text.toString())
            val amount = dialogView.split_amount.text.toString().toDouble()
            val newSplit = SubOperation()
            newSplit.amount = amount
            //newSplit.costOwnerId = userId
            newSplitCallback(newSplit)
            dialog.dismiss()
        }
        dialogView.split_cancel.setOnClickListener { dialog.dismiss()}
    }


}