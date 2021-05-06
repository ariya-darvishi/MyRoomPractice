package com.example.myroompractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroompractice.data.entities.Director
import com.example.myroompractice.data.entities.School
import com.example.myroompractice.data.entities.Student
import com.example.myroompractice.data.entities.Subject
import com.example.myroompractice.data.entities.relations.*
import com.example.myroompractice.repositories.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(
    private val repository: SchoolRepository
) : ViewModel() {


    fun insertSchool(school: School) = viewModelScope.launch {
        repository.insertSchool(school)
    }

    fun insertDirector(director: Director) = viewModelScope.launch {
        repository.insertDirector(director)
    }

    fun insertStudent(student: Student) = viewModelScope.launch {
        repository.insertStudent(student)
    }

    fun insertSubject(subject: Subject) = viewModelScope.launch {
        repository.insertSubject(subject)
    }

    fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef) = viewModelScope.launch {
        repository.insertStudentSubjectCrossRef(crossRef)
    }

    fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector> =
        runBlocking {
            repository.getSchoolAndDirectorWithSchoolName(schoolName)
        }

    fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents> = runBlocking {
        repository.getSchoolWithStudents(schoolName)
    }

    fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents> = runBlocking {
        repository.getStudentsOfSubject(subjectName)
    }

    fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects> = runBlocking {
        repository.getSubjectsOfStudent(studentName)
    }

}