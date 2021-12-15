package com.oct18.dao

import androidx.room.*
import com.oct18.model.Student

@Dao
interface StudentDao {

    @Insert
    fun insertStudent(student : Student)

    @Update
    fun updateStudent(student : Student)

    @Delete
    fun deleteStudent(student : Student)

    @Query("select * from Student")
    fun getAllStudents():List<Student>
}