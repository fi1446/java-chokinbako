package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TeacherCourseInfoBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;
	private String course_name;
	private String category1;
	private String category2;
	private String category3;
	private String category4;
	private int students_num;
	private String course_password;

	public TeacherCourseInfoBeans() {

	}
	
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getCategory4() {
		return category4;
	}

	public void setCategory4(String category4) {
		this.category4 = category4;
	}

	public int getStudents_num() {
		return students_num;
	}

	public void setStudents_num(int students_num) {
		this.students_num = students_num;
	}

	public String getCourse_password() {
		return course_password;
	}

	public void setCourse_password(String course_password) {
		this.course_password = course_password;
	}
}
