package test;

import java.util.List;
import java.util.Scanner;

import com.school.dao.GradeDao;
import com.school.dao.StudentDao;
import com.school.dao.TeacherDao;
import com.school.dao.impl.GradeDaoImpl;
import com.school.dao.impl.StudentDaoImpl;
import com.school.dao.impl.TeacherDaoImpl;
import com.school.entity.Grade;
import com.school.entity.Student;
import com.school.entity.Teacher;
import com.school.utils.DateUtil;

public class Test {
	
	
	static GradeDao gradeDao = new GradeDaoImpl();
	static StudentDao studentDao = new StudentDaoImpl();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\t欢迎使用学生管理系统");
		System.out.println("***********************************");
		System.out.println("\t1.登录系统");
		System.out.println("\t2.退出");
		System.out.println("***********************************");
		System.out.print("请选择，输入数字：");
		int num = input.nextInt();
		switch (num) {
		case 1://登录
			System.out.print("请输入用户名：");
			String username = input.next();
			System.out.print("请输入密码：");
			String password = input.next();
			TeacherDao teacherDao = new TeacherDaoImpl();
			//调用登录的方法
			Teacher teacher =teacherDao.login(username, password);
			if(teacher!=null){
				System.out.println("登录成功！\n");
				//显示二级菜单
				secondMenu();
			}else{
				System.out.println("用户名密码错误，登录失败！");
			}
			break;
		default://退出
			break;
		}
	}
	
	/**
	 * 二级菜单
	 */
	public static void secondMenu(){
		Scanner input = new Scanner(System.in);

		boolean flag = true;// 循环
		do {
			System.out.println("\n***********************************");
			System.out.println("\t1.查询所有年级");
			System.out.println("\t2.添加年级信息");
			System.out.println("\t3.修改年级信息");
			System.out.println("\t4.删除年级信息");
			System.out.println("\t5.查询所有学生");
			System.out.println("\t6.添加学生信息");
			System.out.println("\t7.修改学生信息");
			System.out.println("\t8.删除学生信息");
			System.out.println("\t9.查询学生数量");
			System.out.println("\t10.退出系统");
			System.out.println("***********************************");
			System.out.print("请选择菜单：");
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				//查询所有年级
				showGradeList();
				break;
			case 2:
				//添加年级信息
				addGrade();
				break;
			case 3:
				//修改年级信息
				updateGrade();
				break;
			case 4:
				//删除年级信息
				deleteGrade();
				break;
			case 5:
				//查询所有学生
				showStudentList();
				break;
			case 6:
				//添加学生信息
				addStudent();
				break;
			case 7:
				//修改学生信息
				updateStudent();
				break;
			case 8:
				//删除学生信息
				deleteStudent();
				break;
			case 9:
				//统计学生数量
				getStudentCount();
				break;
			case 10:
				flag = false;//退出循环
				System.out.println("谢谢您的使用！");
				break;
			default:
				System.out.println("您的输入有误!");
				break;
			}
		} while (flag);
	}
	
	
	/**
	 * 统计学生数量
	 */
	private static void getStudentCount() {
		// TODO Auto-generated method stub
		System.out.println("学生总数量："+studentDao.getTotalCount()+"\n");
	}

	/**
	 * 删除学生信息
	 */
	private static void deleteStudent() {
		// TODO Auto-generated method stub
		System.out.print("请输入要删除的学生编号：");
		int id = input.nextInt();
		int count =studentDao.deleteStudent(id);
		if(count>0){
			System.out.println("学生信息删除成功！");
		}else{
			System.out.println("学生信息删除失败！");
		}
	}

	/**
	 * 修改学生信息
	 */
	private static void updateStudent() {
		// TODO Auto-generated method stub
		System.out.print("请输入学生姓名：");
		String name = input.next();
		System.out.print("请输入性别：");
		String sex = input.next();
		System.out.print("请输入联系电话：");
		String phone = input.next();
		System.out.print("请输入年级编号：");
		int gradeId = input.nextInt();
		System.out.print("请输入出生日期：");
		String birthday = input.next();
		System.out.print("请输入学生编号：");
		int studentId = input.nextInt();
		
		Student student = new Student(studentId,name,sex,phone,gradeId,DateUtil.convertDate(birthday));
		int count = studentDao.updateStudent(student);
		if(count>0){
			System.out.println("学生信息修改成功！");
		}else{
			System.out.println("学生信息修改失败！");
		}
	}

	/**
	 * 添加学生信息
	 */
	private static void addStudent() {
		// TODO Auto-generated method stub
		System.out.print("请输入学生姓名：");
		String name = input.next();
		System.out.print("请输入性别：");
		String sex = input.next();
		System.out.print("请输入联系电话：");
		String phone = input.next();
		System.out.print("请输入年级编号：");
		int gradeId = input.nextInt();
		System.out.print("请输入出生日期：");
		String birthday = input.next();
		
		Student student = new Student(name,sex,phone,gradeId,DateUtil.convertDate(birthday));
		int count = studentDao.addStudent(student);
		if(count>0){
			System.out.println("学生信息添加成功！");
		}else{
			System.out.println("学生信息添加失败！");
		}
	}

	/**
	 * 查询所有学生
	 */
	private static void showStudentList() {
		// TODO Auto-generated method stub
		System.out.println("编号\t姓名\t性别\t联系方式\t\t年级\t出生日期");
		List<Student> list = studentDao.findStudentList();
		for (Student student : list) {
			System.out.println(student.getId()+"\t"+student.getStudentName()+"\t"+student.getSex()+"\t"+student.getPhone()+"\t"+student.getGradeId()+"\t"+student.getBirthday());
		}
	}
	
	/**
	 * 删除年级信息
	 */
	private static void deleteGrade() {
		// TODO Auto-generated method stub
		System.out.print("请输入要删除的年级编号：");
		int gradeId = input.nextInt();
		int count = gradeDao.deleteGrade(gradeId);
		if(count>0){
			System.out.println("年级信息删除成功！");
		}else{
			System.out.println("年级信息删除失败！");
		}
	}

	/**
	 * 修改年级信息
	 */
	private static void updateGrade() {
		// TODO Auto-generated method stub
		System.out.print("请输入年级名称：");
		String gradeName = input.next();
		System.out.print("请输入年级编号：");
		int gradeId = input.nextInt();
		Grade grade = new Grade(gradeId,gradeName);
		int count = gradeDao.updateGrade(grade);
		if(count>0){
			System.out.println("年级信息修改成功！");
		}else{
			System.out.println("年级信息修改失败！");
		}
	}

	/**
	 * 添加年级信息
	 */
	private static void addGrade() {
		// TODO Auto-generated method stub
		System.out.print("请输入年级名称：");
		String gradeName = input.next();
		Grade grade = new Grade(gradeName);
		int count = gradeDao.addGrade(grade);
		if(count>0){
			System.out.println("年级信息添加成功！");
		}else{
			System.out.println("年级信息添加失败！");
		}
	}

	/**
	 * 显示年级列表
	 */
	private static void showGradeList() {
		// TODO Auto-generated method stub
		System.out.println("编号\t年级名称");
		List<Grade> list = gradeDao.findGradeList();
		for (Grade grade : list) {
			System.out.println(grade.getId()+"\t"+grade.getGradeName());
		}
	}
}
