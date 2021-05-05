package com.example.myroompractice.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.myroompractice.data.entities.Student
import com.example.myroompractice.data.entities.Subject

data class StudentWithSubjects(

    @Embedded val student: Student,

    @Relation(

        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)

    )
    val subjects: List<Subject>

)
