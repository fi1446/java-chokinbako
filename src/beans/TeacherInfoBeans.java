package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TeacherInfoBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String teacher_name;
	private int teachers_id;
	private int courses_id;
	private String registered;

	public TeacherInfoBeans() {

	}
	
	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getTeachers_id() {
		return teachers_id;
	}

	public void setTeachers_id(int teachers_id) {
		this.teachers_id = teachers_id;
	}


	public int getCourses_id() {
		return courses_id;
	}

	public void setCourses_id(int courses_id) {
		this.courses_id = courses_id;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

}
