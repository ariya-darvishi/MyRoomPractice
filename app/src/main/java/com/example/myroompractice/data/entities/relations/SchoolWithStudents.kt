package com.example.myroompractice.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myroompractice.data.entities.School
import com.example.myroompractice.data.entities.Student

data class SchoolWithStudents(

    @Embedded val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
