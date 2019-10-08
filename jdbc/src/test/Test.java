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
		System.out.println("\t��ӭʹ��ѧ������ϵͳ");
		System.out.println("***********************************");
		System.out.println("\t1.��¼ϵͳ");
		System.out.println("\t2.�˳�");
		System.out.println("***********************************");
		System.out.print("��ѡ���������֣�");
		int num = input.nextInt();
		switch (num) {
		case 1://��¼
			System.out.print("�������û�����");
			String username = input.next();
			System.out.print("���������룺");
			String password = input.next();
			TeacherDao teacherDao = new TeacherDaoImpl();
			//���õ�¼�ķ���
			Teacher teacher =teacherDao.login(username, password);
			if(teacher!=null){
				System.out.println("��¼�ɹ���\n");
				//��ʾ�����˵�
				secondMenu();
			}else{
				System.out.println("�û���������󣬵�¼ʧ�ܣ�");
			}
			break;
		default://�˳�
			break;
		}
	}
	
	/**
	 * �����˵�
	 */
	public static void secondMenu(){
		Scanner input = new Scanner(System.in);

		boolean flag = true;// ѭ��
		do {
			System.out.println("\n***********************************");
			System.out.println("\t1.��ѯ�����꼶");
			System.out.println("\t2.����꼶��Ϣ");
			System.out.println("\t3.�޸��꼶��Ϣ");
			System.out.println("\t4.ɾ���꼶��Ϣ");
			System.out.println("\t5.��ѯ����ѧ��");
			System.out.println("\t6.���ѧ����Ϣ");
			System.out.println("\t7.�޸�ѧ����Ϣ");
			System.out.println("\t8.ɾ��ѧ����Ϣ");
			System.out.println("\t9.��ѯѧ������");
			System.out.println("\t10.�˳�ϵͳ");
			System.out.println("***********************************");
			System.out.print("��ѡ��˵���");
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				//��ѯ�����꼶
				showGradeList();
				break;
			case 2:
				//����꼶��Ϣ
				addGrade();
				break;
			case 3:
				//�޸��꼶��Ϣ
				updateGrade();
				break;
			case 4:
				//ɾ���꼶��Ϣ
				deleteGrade();
				break;
			case 5:
				//��ѯ����ѧ��
				showStudentList();
				break;
			case 6:
				//���ѧ����Ϣ
				addStudent();
				break;
			case 7:
				//�޸�ѧ����Ϣ
				updateStudent();
				break;
			case 8:
				//ɾ��ѧ����Ϣ
				deleteStudent();
				break;
			case 9:
				//ͳ��ѧ������
				getStudentCount();
				break;
			case 10:
				flag = false;//�˳�ѭ��
				System.out.println("лл����ʹ�ã�");
				break;
			default:
				System.out.println("������������!");
				break;
			}
		} while (flag);
	}
	
	
	/**
	 * ͳ��ѧ������
	 */
	private static void getStudentCount() {
		// TODO Auto-generated method stub
		System.out.println("ѧ����������"+studentDao.getTotalCount()+"\n");
	}

	/**
	 * ɾ��ѧ����Ϣ
	 */
	private static void deleteStudent() {
		// TODO Auto-generated method stub
		System.out.print("������Ҫɾ����ѧ����ţ�");
		int id = input.nextInt();
		int count =studentDao.deleteStudent(id);
		if(count>0){
			System.out.println("ѧ����Ϣɾ���ɹ���");
		}else{
			System.out.println("ѧ����Ϣɾ��ʧ�ܣ�");
		}
	}

	/**
	 * �޸�ѧ����Ϣ
	 */
	private static void updateStudent() {
		// TODO Auto-generated method stub
		System.out.print("������ѧ��������");
		String name = input.next();
		System.out.print("�������Ա�");
		String sex = input.next();
		System.out.print("��������ϵ�绰��");
		String phone = input.next();
		System.out.print("�������꼶��ţ�");
		int gradeId = input.nextInt();
		System.out.print("������������ڣ�");
		String birthday = input.next();
		System.out.print("������ѧ����ţ�");
		int studentId = input.nextInt();
		
		Student student = new Student(studentId,name,sex,phone,gradeId,DateUtil.convertDate(birthday));
		int count = studentDao.updateStudent(student);
		if(count>0){
			System.out.println("ѧ����Ϣ�޸ĳɹ���");
		}else{
			System.out.println("ѧ����Ϣ�޸�ʧ�ܣ�");
		}
	}

	/**
	 * ���ѧ����Ϣ
	 */
	private static void addStudent() {
		// TODO Auto-generated method stub
		System.out.print("������ѧ��������");
		String name = input.next();
		System.out.print("�������Ա�");
		String sex = input.next();
		System.out.print("��������ϵ�绰��");
		String phone = input.next();
		System.out.print("�������꼶��ţ�");
		int gradeId = input.nextInt();
		System.out.print("������������ڣ�");
		String birthday = input.next();
		
		Student student = new Student(name,sex,phone,gradeId,DateUtil.convertDate(birthday));
		int count = studentDao.addStudent(student);
		if(count>0){
			System.out.println("ѧ����Ϣ��ӳɹ���");
		}else{
			System.out.println("ѧ����Ϣ���ʧ�ܣ�");
		}
	}

	/**
	 * ��ѯ����ѧ��
	 */
	private static void showStudentList() {
		// TODO Auto-generated method stub
		System.out.println("���\t����\t�Ա�\t��ϵ��ʽ\t\t�꼶\t��������");
		List<Student> list = studentDao.findStudentList();
		for (Student student : list) {
			System.out.println(student.getId()+"\t"+student.getStudentName()+"\t"+student.getSex()+"\t"+student.getPhone()+"\t"+student.getGradeId()+"\t"+student.getBirthday());
		}
	}
	
	/**
	 * ɾ���꼶��Ϣ
	 */
	private static void deleteGrade() {
		// TODO Auto-generated method stub
		System.out.print("������Ҫɾ�����꼶��ţ�");
		int gradeId = input.nextInt();
		int count = gradeDao.deleteGrade(gradeId);
		if(count>0){
			System.out.println("�꼶��Ϣɾ���ɹ���");
		}else{
			System.out.println("�꼶��Ϣɾ��ʧ�ܣ�");
		}
	}

	/**
	 * �޸��꼶��Ϣ
	 */
	private static void updateGrade() {
		// TODO Auto-generated method stub
		System.out.print("�������꼶���ƣ�");
		String gradeName = input.next();
		System.out.print("�������꼶��ţ�");
		int gradeId = input.nextInt();
		Grade grade = new Grade(gradeId,gradeName);
		int count = gradeDao.updateGrade(grade);
		if(count>0){
			System.out.println("�꼶��Ϣ�޸ĳɹ���");
		}else{
			System.out.println("�꼶��Ϣ�޸�ʧ�ܣ�");
		}
	}

	/**
	 * ����꼶��Ϣ
	 */
	private static void addGrade() {
		// TODO Auto-generated method stub
		System.out.print("�������꼶���ƣ�");
		String gradeName = input.next();
		Grade grade = new Grade(gradeName);
		int count = gradeDao.addGrade(grade);
		if(count>0){
			System.out.println("�꼶��Ϣ��ӳɹ���");
		}else{
			System.out.println("�꼶��Ϣ���ʧ�ܣ�");
		}
	}

	/**
	 * ��ʾ�꼶�б�
	 */
	private static void showGradeList() {
		// TODO Auto-generated method stub
		System.out.println("���\t�꼶����");
		List<Grade> list = gradeDao.findGradeList();
		for (Grade grade : list) {
			System.out.println(grade.getId()+"\t"+grade.getGradeName());
		}
	}
}
