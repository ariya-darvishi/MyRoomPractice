package com.example.myroompractice.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myroompractice.data.entities.Director
import com.example.myroompractice.data.entities.School

data class SchoolAndDirector(

    @Embedded val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director

)