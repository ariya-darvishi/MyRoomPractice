package com.example.myroompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myroompractice.data.entities.Director
import com.example.myroompractice.data.entities.School
import com.example.myroompractice.data.entities.Student
import com.example.myroompractice.data.entities.Subject
import com.example.myroompractice.data.entities.relations.StudentSubjectCrossRef
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val schoolViewModel: SchoolViewModel by viewModels()

//    lateinit var viewModel: SchoolViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProvider(this).get(SchoolViewModel::class.java)

        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )


        lifecycleScope.launch {
            directors.forEach { schoolViewModel.insertDirector(it) }
            schools.forEach { schoolViewModel.insertSchool(it) }
            subjects.forEach { schoolViewModel.insertSubject(it) }
            students.forEach { schoolViewModel.insertStudent(it) }
            studentSubjectRelations.forEach { schoolViewModel.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector =
                schoolViewModel.getSchoolAndDirectorWithSchoolName("Kotlin School")

            val schoolWithStudents = schoolViewModel.getSchoolWithStudents("Kotlin School")

        }
    }

}