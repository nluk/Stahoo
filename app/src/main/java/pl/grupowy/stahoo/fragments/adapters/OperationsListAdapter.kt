package pl.grupowy.stahoo.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main_operation.view.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation
import java.security.AccessController.getContext

class OperationsListAdapter(val operationsList : List<MainOperation>, val clickCallback : ClickCallback) : RecyclerView.Adapter<OperationsListAdapter.OperationsViewHolder>() {

    interface ClickCallback{
        fun onItemClick(position: Int)
    }

    override fun onBindViewHolder(holder: OperationsViewHolder, position: Int) {
        holder.bindItems(operationsList[position])
        holder.itemView.setOnClickListener {
            clickCallback.onItemClick(holder.adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_main_operation, parent, false)
        return OperationsViewHolder(v)
    }

    override fun getItemCount(): Int = operationsList.size

    class OperationsViewHolder(view : View) : RecyclerView.ViewHolder(view){



        fun bindItems(operation:MainOperation){


            itemView.operation_amount.text = operation.amount.toString()
            if(operation.amount>0.0) itemView.operation_amount.setTextColor(ContextCompat.getColor(itemView.context,R.color.income))
            else if(operation.amount<0.0) itemView.operation_amount.setTextColor(ContextCompat.getColor(itemView.context,R.color.expense))
            itemView.operation_title.text = operation.name
           if(operation.isCyclical) itemView.operation_is_cyclical.setImageResource(R.drawable.ic_cyclical_operation)
           else itemView.operation_is_cyclical.visibility = GONE
           if(operation.isDivided) itemView.operation_is_shared.setImageResource(R.drawable.ic_shared_operation)
            else itemView.operation_is_shared.visibility = GONE
        }
    }

}