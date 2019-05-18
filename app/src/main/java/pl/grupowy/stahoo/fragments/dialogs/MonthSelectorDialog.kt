package pl.grupowy.stahoo.fragments.dialogs

import android.app.AlertDialog
import android.content.Context
import pl.grupowy.stahoo.R

class MonthSelectorDialog(context: Context, val handler : OnMonthSelectedHandler) : AlertDialog(context) {

    val alertDialog = AlertDialog.Builder(context)
                                .setTitle(R.string.select_month)
                                .setItems(R.array.months_array) { _,which ->
                                    handler.onMonthSelected(which )
                                }
                                .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.cancel() }
                                .create()

   override fun show(){
       alertDialog.show()
   }

    interface OnMonthSelectedHandler{
        fun onMonthSelected(whichMonth : Int)
    }



}