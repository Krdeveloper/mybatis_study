package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentMapper;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	private StudentService() {
		
		// TODO Auto-generated constructor stub
		
	}
	
	public List<Student> selectStudentByAll(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		//sqlSession.close();
		return studentDao.selectStudentByAll();
		
	}
	
	public int insertStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		int res = studentDao.insertStudent(student);//1이면 추가 된거고 0이면 추가 안된거
		sqlSession.commit();//commit해야 들어감
		return res;
	}
	public int insertStudentWithPhone(Student student){
		int res = -1;
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
			res = studentDao.insertStudentWithPhone(student);
			sqlSession.commit();			
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	/*//selectStudentByNo
	public Student selectStudentByNo(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		return studentDao.selectStudentByNo(studNo);
		
	}*/
	
	/*public int updateStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.updateStudent(student);
		sqlSession.commit();
		return res;
	}
	public int deleteStudentByNo(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.deleteStudentByNo(studNo);
		sqlSession.commit();
		return res;
	}*/
	
	
}
