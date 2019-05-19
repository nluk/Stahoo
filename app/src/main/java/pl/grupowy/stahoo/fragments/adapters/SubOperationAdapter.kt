package pl.grupowy.stahoo.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_friend_invite.view.*
import kotlinx.android.synthetic.main.item_sub_operation.view.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.models.SubOperation

typealias SubOperationClick = (sub : SubOperation) -> Unit

class SubOperationAdapter(val subOperationsList : List<SubOperation>, val onSubOperationClick : SubOperationClick) : RecyclerView.Adapter<SubOperationAdapter.SubOperationViewHolder>() {


    override fun onBindViewHolder(holder: SubOperationViewHolder, position: Int) {
        holder.bindItems(subOperationsList[position])
        holder.itemView.setOnClickListener {onSubOperationClick(subOperationsList[holder.adapterPosition])}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubOperationViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_sub_operation, parent, false)
        return SubOperationViewHolder(v)
    }

    override fun getItemCount(): Int = subOperationsList.size

    class SubOperationViewHolder(view : View) : RecyclerView.ViewHolder(view){


        fun bindItems(sub : SubOperation){
            itemView.sub_operation_amount.text = sub.amount.toString()
           //TODO("Fetch sub operation user by id") itemView.sub_operation_user = DB.getUserByID(sub.costOwnerId).username
        }
    }

}