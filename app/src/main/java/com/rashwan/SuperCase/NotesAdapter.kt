package com.rashwan.SuperCase
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.rowstyle.view.*
import java.time.LocalDate

class NotesAdapter (context: Context,caseList:List<Casesinfo>):ArrayAdapter<Casesinfo>(context,0,caseList)

{

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent:ViewGroup): View {

        var view =LayoutInflater.from(context).inflate(R.layout.rowstyle,parent,false)

      var case: Casesinfo? =getItem(position)
        view.caseNum.text = case?.caseNum
        view.caseYear.text=case?.caseYear
        view.caseCount.text=case?.caseCount
        view.caseCountYear.text=case?.caseCountYear
        view.caseAccuser.text=case?.caseAccuser
        view.caseSessionDate.text=tools.epochToStr(case?.caseSessionDate!!.toLong())


        var diffDays =
            ((case.caseSessionDate!!.toLong() - tools.strToEpoch(LocalDate.now().toString())) / (86400))
        var daycount = "ايام"
        if (diffDays.toInt() > 11) {
            daycount = "يوما"
        }
        if (diffDays.toInt() == 1) {
            view.remain.text = "جلسة اليوم!"
        } else if (diffDays.toInt() == 2) {
            view.remain.text = "جلسة باكر!"
        } else if (diffDays.toInt() == 3) {
            view.remain.text = "جلسة بعد باكر!"
        } else if (diffDays.toInt() > 0) {
            diffDays = diffDays - 1

            view.remain.text = "متبقي( " + diffDays.toString() + " ) $daycount"

        } else {

            diffDays = diffDays * -1
            diffDays = diffDays + 1

            if (diffDays.toInt() > 11) {
                daycount = "يوما"
            }
            view.remain.text = "مضى( " + diffDays.toString() + " )$daycount"

        }

        if (case.deleted == 1) {
            view.rowstyle.background =
                ContextCompat.getDrawable(context, R.drawable.background_rowstyle_deleted)
      }

        return view
    }
}

