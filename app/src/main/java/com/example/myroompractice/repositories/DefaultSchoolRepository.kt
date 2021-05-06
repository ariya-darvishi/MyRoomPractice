package com.example.myroompractice.repositories

import com.example.myroompractice.data.SchoolDao
import com.example.myroompractice.data.entities.Director
import com.example.myroompractice.data.entities.School
import com.example.myroompractice.data.entities.Student
import com.example.myroompractice.data.entities.Subject
import com.example.myroompractice.data.entities.relations.*

class DefaultSchoolRepository(
    private val dao: SchoolDao
) : SchoolRepository {

    override suspend fun insertSchool(school: School) {
        dao.insertSchool(school)
    }

    override suspend fun insertDirector(director: Director) {
        dao.insertDirector(director)
    }

    override suspend fun insertStudent(student: Student) {
        dao.insertStudent(student)
    }

    override suspend fun insertSubject(subject: Subject) {
        dao.insertSubject(subject)
    }

    override suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef) {
        dao.insertStudentSubjectCrossRef(crossRef)
    }

    override suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector> =
        dao.getSchoolAndDirectorWithSchoolName(schoolName)


    override suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents> =
        dao.getSchoolWithStudents(schoolName)


    override suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents> =
        dao.getStudentsOfSubject(subjectName)


    override suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects> =
        dao.getSubjectsOfStudent(studentName)

}