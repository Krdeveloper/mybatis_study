package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.PhoneNumber;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

public class StudentDaoTest {
	private static StudentService studentService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	/*@Test
	public void testSelectStudentByAll() {
		List<Student> lists = studentService.selectStudentByAll();
		for(Student s : lists){
			System.out.println(s);
		}
		Assert.assertNotNull(lists);
	}*/
	
	/*@Test
	public void testInsertStudent() {
		Student student = new Student(5, "조시은", "jsw@test.co.kr", new Date());
		
		int res = studentService.insertStudent(student);
		
		Assert.assertEquals(1, res);
	}*/
	
	/*@Test
	public void testSelectStudentByNo() {
		Student student = studentService.selectStudentByNo(5);
		
		Assert.assertNotNull(student);
	}*/
	/*@Test
	public void testUpdateStudent() {
		Student student = new Student(5, "수정", "jsw@test.co.kr", new Date());
		
		int res = studentService.updateStudent(student);
		
		Assert.assertEquals(1, res);
	}
	@Test
	public void testDeleteStudentByNo() {
		
		
		int res = studentService.deleteStudentByNo(4);
		
		Assert.assertEquals(1, res);
	}*/
	@Test
	public void testInsertStudentWithPhone() {
		Student student = new Student(7, "이교민", "lgm@test.co.kr", new Date(), new PhoneNumber("010-1234-1234"));
		int res = studentService.insertStudentWithPhone(student);		
		Assert.assertEquals(1, res);
	}

}
