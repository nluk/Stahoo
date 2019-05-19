package pl.grupowy.stahoo.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_friend.view.*
import kotlinx.android.synthetic.main.item_friend_invite.view.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User

typealias OnFriendClick = (friend : User)->Unit
class FriendsListAdapter(val friendsList : List<User>, val onFriendClick: OnFriendClick) : RecyclerView.Adapter<FriendsListAdapter.FriendsViewHolder>() {


    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.bindItems(friendsList[position])
        holder.itemView.setOnClickListener {
            onFriendClick(friendsList[holder.adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return FriendsViewHolder(v)
    }

    override fun getItemCount(): Int = friendsList.size

    class FriendsViewHolder(view : View) : RecyclerView.ViewHolder(view){


        fun bindItems(friend:User){
            itemView.friend_email.text = friend.email
            itemView.friend_nickname.text = friend.username
        }
    }

}