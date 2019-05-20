package pl.grupowy.stahoo.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_friend_invite.view.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User

typealias InviteAcceptedCallback = (user : User) -> Unit
typealias InviteDeclinedCallback = (user : User) -> Unit
class FriendInviteAdapter(val invitesList : MutableList<User>, val inviteAccepted : InviteAcceptedCallback, val inviteDeclined : InviteDeclinedCallback) : RecyclerView.Adapter<FriendInviteAdapter.FriendInviteViewHolder>() {


    override fun onBindViewHolder(holder: FriendInviteViewHolder, position: Int) {
        holder.bindItems(invitesList[position])
        holder.itemView.setOnClickListener {
            if (it.id == R.id.invite_accept) {
                inviteAccepted(invitesList[holder.adapterPosition])
                Toast.makeText(holder.itemView.context,"Invite accepted",LENGTH_SHORT).show()
            }
            else if (it.id == R.id.invite_accept) {
                inviteDeclined(invitesList[holder.adapterPosition])
                Toast.makeText(holder.itemView.context,"Invite declined",LENGTH_SHORT).show()
            }
            invitesList.removeAt(holder.adapterPosition)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendInviteViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_friend_invite, parent, false)
        return FriendInviteViewHolder(v)
    }

    override fun getItemCount(): Int = invitesList.size

    class FriendInviteViewHolder(view : View) : RecyclerView.ViewHolder(view){


        fun bindItems(invitingUser:User){
            itemView.invite_email.text = invitingUser.email
        }
    }

}