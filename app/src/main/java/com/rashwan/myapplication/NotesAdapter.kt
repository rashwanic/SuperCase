package com.rashwan.myapplication
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.rowstyle.view.*

class NotesAdapter (context: Context,caseList:List<Casesinfo>):ArrayAdapter<Casesinfo>(context,0,caseList)

{

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent:ViewGroup): View {

        var view =LayoutInflater.from(context).inflate(R.layout.rowstyle,parent,false)

      var case: Casesinfo? =getItem(position)
        view.caseNum.text = case?.IsDeleted.toString()
        view.caseYear.text=case?.caseYear
        view.caseCount.text=case?.caseCount
        view.caseCountYear.text=case?.caseCountYear
        view.caseAccuser.text=case?.caseAccuser
        view.caseSessionDate.text=tools.epochToStr(case?.caseSessionDate!!.toLong())

        if (case.IsDeleted == 1) {
            view.rowstyle.background =
                ContextCompat.getDrawable(context, R.drawable.background_rowstyle_deleted)
      }

        return view
    }
}


