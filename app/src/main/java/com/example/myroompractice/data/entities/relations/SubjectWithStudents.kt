package com.example.myroompractice.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.myroompractice.data.entities.Student
import com.example.myroompractice.data.entities.Subject

data class SubjectWithStudents(

    @Embedded val subject: Subject,

    @Relation(

        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)

    )
    val student: List<Student>

)
