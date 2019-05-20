package pl.grupowy.stahoo.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_friends_list.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.fragments.adapters.FriendInviteAdapter
import pl.grupowy.stahoo.fragments.adapters.FriendsListAdapter
import pl.grupowy.stahoo.fragments.dialogs.InviteFriendDialog
import pl.grupowy.stahoo.fragments.dialogs.RemoveFriendDialog
import pl.grupowy.stahoo.network.request.users.InvitationRequest
import pl.grupowy.stahoo.network.request.users.RemoveFriendRequest
import pl.grupowy.stahoo.network.request.users.SendInvitationRequest
import pl.grupowy.stahoo.network.response.users.UserResponse
import pl.grupowy.stahoo.network.services.UsersService
import javax.inject.Inject

class FriendsListFragment : BaseFragment() {
    val friendsList: MutableList<User> = ArrayList()
    val friendsAdapter = FriendsListAdapter(friendsList,
        onFriendClick = { friend ->
            RemoveFriendDialog(
                context!!, friend
            ) { removeFriend(friend) }.show()
        })

    val invitesList: MutableList<User> = ArrayList()
    val invitesAdapter = FriendInviteAdapter(invitesList,
        inviteAccepted = {
            manageInvitation(it, true) },
        inviteDeclined = { manageInvitation(it, false) })

    @Inject
    lateinit var usersService: UsersService

    override fun layoutRes(): Int = R.layout.fragment_friends_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()
        setListeners()
        setAdapters()
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
            { invitationEmailAddress -> sendInvitation(invitationEmailAddress) }.show()
        }
    }

    @SuppressLint("CheckResult")
    private fun removeFriend(friend: User) {
        usersService.removeFriend(RemoveFriendRequest(friend.id))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, { it.printStackTrace() })
    }

    @SuppressLint("CheckResult")
    private fun manageInvitation(user: User, isAccepted: Boolean) {
        usersService.manageInvitation(InvitationRequest(user.id, isAccepted))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, { it.printStackTrace() })
    }

    @SuppressLint("CheckResult")
    private fun sendInvitation(email: String) {
        usersService.sendInvitation(SendInvitationRequest(email))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, { it.printStackTrace() })
    }

    @SuppressLint("CheckResult")
    private fun fetchData() {
        usersService.getUserFriends()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate {
                invitesAdapter.notifyDataSetChanged()
                friendsAdapter.notifyDataSetChanged()
            }
            .subscribe({ result ->
                fillInvitesList(result.pending)
                fillFriendsList(result.friends)
            }, { it.printStackTrace() })
    }

    private fun fillInvitesList(invites: List<UserResponse>) {
        if (invites.isNotEmpty()) {
            invites.forEach {
                val user = User().apply {
                    id = it.id
                    username = it.username
                    email = it.email
                    firstName = it.firstName
                    lastName = it.lastName
                }
                invitesList.add(user)
            }
        }
    }

    private fun fillFriendsList(friends: List<UserResponse>) {
        if (friends.isNotEmpty()) {
            friends.forEach {
                val friend = User().apply {
                    id = it.id
                    username = it.username
                    email = it.email
                    firstName = it.firstName
                    lastName = it.lastName
                }
                friendsList.add(friend)
            }
        }
    }

}
