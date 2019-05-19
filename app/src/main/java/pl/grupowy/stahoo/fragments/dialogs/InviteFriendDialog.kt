package pl.grupowy.stahoo.fragments.dialogs

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.dialog_invite_friend.view.*
import kotlinx.android.synthetic.main.dialog_operation_actions.*
import kotlinx.android.synthetic.main.dialog_operation_actions.view.*

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation

typealias SendInviteAction = (email : String)->Unit

class InviteFriendDialog(context : Context,val sendInviteAction: SendInviteAction) : AlertDialog(context){
    var dialogView : View  = LayoutInflater.from(context).inflate(R.layout.dialog_invite_friend,null)
    val dialog : AlertDialog = AlertDialog.Builder(context)
        .setTitle(context.getString(R.string.invite_friend))
        .setView(dialogView)
        .create()

    init {
        setListeners()
    }

    override fun show() {
        dialog.show()
    }

    private fun setListeners() {
        dialogView.invite_send.setOnClickListener {
            sendInviteAction(dialogView.invite_email.text.toString())
            dialog.dismiss()
        }
    }


}