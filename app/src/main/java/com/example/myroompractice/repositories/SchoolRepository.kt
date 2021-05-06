package com.example.myroompractice.repositories

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.myroompractice.data.entities.Director
import com.example.myroompractice.data.entities.School
import com.example.myroompractice.data.entities.Student
import com.example.myroompractice.data.entities.Subject
import com.example.myroompractice.data.entities.relations.*

interface SchoolRepository {

    suspend fun insertSchool(school: School)

    suspend fun insertDirector(director: Director)

    suspend fun insertStudent(student: Student)

    suspend fun insertSubject(subject: Subject)

    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>


}