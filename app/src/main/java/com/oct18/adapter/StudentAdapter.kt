package com.oct18.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oct18.databinding.StudentLayoutBinding
import com.oct18.model.Student

class StudentAdapter(public var data: List<Student>,
                     private val listener:OnStudentClickListener) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    /*
    Event Handling
     */
    public interface OnStudentClickListener{
        fun onStudentClick(student:Student)
        fun onStudentLongClick(student:Student)
    }


    // 4.
    class StudentViewHolder(val binding: StudentLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    // 2 . Create Layout file
    // 3. onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        // binding instance
        val binding=StudentLayoutBinding.inflate(inflater, parent, false)
        return StudentViewHolder(binding)
    }

    // 5
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
       val student=data[position]
        /*with(holder.binding){
            tvFullName.text="${student.firstName} ${student.lastName}"
            tvEmail.text=student.email
        }*/

        holder.binding.student=student

        if(student.isSelected) holder.binding.cardView.setCardBackgroundColor(Color.GREEN)
        else holder.binding.cardView.setCardBackgroundColor(Color.GRAY)

        holder.itemView.setOnClickListener {
            listener.onStudentClick(student)
        }

        holder.itemView.setOnLongClickListener {
            listener.onStudentLongClick(student)
            true
        }
    }

    // 1
    override fun getItemCount(): Int = data.size
}