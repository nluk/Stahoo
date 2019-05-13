package pl.grupowy.stahoo.fragments.adapters

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_operation_layout.view.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.entities.MainOperation

class OperationsListAdapter(val operationsList : List<MainOperation>) : RecyclerView.Adapter<OperationsListAdapter.OperationsViewHolder>() {

    override fun onBindViewHolder(holder: OperationsViewHolder, position: Int) {
        holder.bindItems(operationsList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.main_operation_layout, parent, false)
        return OperationsViewHolder(v)
    }

    override fun getItemCount(): Int = operationsList.size



    class OperationsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindItems(operation:MainOperation){
            itemView.operation_amount.text = operation.amount.toString()
            itemView.operation_title.text = operation.name
           if(operation.isCyclical) itemView.operation_is_cyclical.setImageResource(R.drawable.ic_cyclical_operation)
           else itemView.operation_is_cyclical.visibility = GONE
           if(operation.isDivided) itemView.operation_is_shared.setImageResource(R.drawable.ic_shared_operation)
            else itemView.operation_is_shared.visibility = GONE
        }
    }

}