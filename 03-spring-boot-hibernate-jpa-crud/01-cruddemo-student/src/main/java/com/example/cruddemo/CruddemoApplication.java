package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int deletedStudents = studentDAO.deleteAll();
		System.out.println("Where deleted " + deletedStudents + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(5);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// get student by id
		int id = 1;
		System.out.println("Retrieving student with id: " + id);
		Student student = studentDAO.findById(id);
		// change firstName
		System.out.println("Updating student ...");
		student.setFirstName("John");
		// update student
		studentDAO.update(student);
		// display the updated student
		Student updatedStudent = studentDAO.findById(id);
		System.out.println("Updated student: " + updatedStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		studentDAO.findByLastName("Doe").forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get and display a list of students
		studentDAO.findAll().forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@example.com");
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display the id of the saved student object
		int savedStudentId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + savedStudentId);
		// retrieve student by id
		System.out.println("Retrieving student with id: " + savedStudentId);
		Student savedStudent = studentDAO.findById(savedStudentId);
		// display student
		System.out.println("Found the student: " + savedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Paul", "Doe", "paul@example.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@example.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@example.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("John", "Doe", "john@example.com");
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display the id of the saved student object
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
