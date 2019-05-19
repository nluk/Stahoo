package pl.grupowy.stahoo.fragments.dialogs

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.dialog_friend_actions.*
import kotlinx.android.synthetic.main.dialog_friend_actions.view.*
import kotlinx.android.synthetic.main.dialog_invite_friend.view.*
import kotlinx.android.synthetic.main.dialog_operation_actions.*
import kotlinx.android.synthetic.main.dialog_operation_actions.view.*

import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.entities.MainOperation

typealias FriendRemoveAction = (friend : User)->Unit

class RemoveFriendDialog(context : Context,val friend: User,val friendRemoveAction: FriendRemoveAction) : AlertDialog(context){
    var dialogView : View  = LayoutInflater.from(context).inflate(R.layout.dialog_friend_actions,null)
    val dialog : AlertDialog = AlertDialog.Builder(context)
        .setView(dialogView)
        .create()

    init {
        setListeners()
    }

    override fun show() {
        dialog.show()
    }

    private fun setListeners() {
        dialogView.friend_removal_cancel.setOnClickListener { dialog.dismiss() }
        dialogView.friend_removal_accept.setOnClickListener {
            friendRemoveAction(friend)
            dialog.dismiss()
        }
    }


}