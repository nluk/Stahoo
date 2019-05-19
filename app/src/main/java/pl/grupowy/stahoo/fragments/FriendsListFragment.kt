package pl.grupowy.stahoo.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_friends_list.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.fragments.adapters.FriendInviteAdapter
import pl.grupowy.stahoo.fragments.adapters.SubOperationAdapter
import pl.grupowy.stahoo.fragments.adapters.FriendsListAdapter
import pl.grupowy.stahoo.fragments.dialogs.InviteFriendDialog
import pl.grupowy.stahoo.fragments.dialogs.RemoveFriendDialog


class FriendsListFragment : BaseFragment() {


    val friendsList : MutableList<User> = ArrayList()
    val friendsAdapter = FriendsListAdapter(friendsList,
        onFriendClick = {friend ->
            RemoveFriendDialog(context!!,friend
            ) { friend ->
                //TODO("Friend removal")
            }.show()
        })

    val invitesList : MutableList<User> = ArrayList()
    val invitesAdapter = FriendInviteAdapter(invitesList,
        inviteAccepted = {invitingUser ->
            //TODO("Add on invite accepted")
        },
        inviteDeclined = {invitingUser ->
            //TODO("Add on invite declined")
        })

    override fun layoutRes(): Int = R.layout.fragment_friends_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()
        setListeners()
        setAdapters()
        dummyData()
    }

    private fun dummyData() {
        for(id in 1..20){
            val invitingUser = User()
            val friend = User()
            invitingUser.email = "invite_email$id@gmail.com"
            friend.email = "friend_email$id@gmail.com"
            friend.username = "user_$id"
            friendsList.add(friend)
            invitesList.add(invitingUser)
        }

        invitesAdapter.notifyDataSetChanged()
        friendsAdapter.notifyDataSetChanged()
    }

    private fun setAdapters() {
        friends_recycler.adapter = friendsAdapter
        friends_recycler.layoutManager = LinearLayoutManager(context)

        invites_recycler.adapter = invitesAdapter
        invites_recycler.layoutManager = LinearLayoutManager(context)
    }

    private fun setListeners() {
        add_friend.setOnClickListener {
            InviteFriendDialog(context!!)
            { invitationEmailAddress ->

                //TODO("Send invite")
            }.show()
        }
    }



    private fun fetchData() {
        //TODO("Add fetching invites & friends") //To change body of created functions use File | Settings | File Templates.
    }

}
