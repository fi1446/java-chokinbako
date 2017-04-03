package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String student_name;
	private String course_name;
	private String email;

	// 引数なしのコンストラクタ
		public StudentInfoBeans() {

		}

		// 以下、setter/getter

		public String getStudent_name() {
			return student_name;
		}

		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}

		public String getCourse_name() {
			return course_name;
		}

		public void setCourse_name(String course_name) {
			this.course_name = course_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getStudent_name());
		list.add(getCourse_name());
		list.add(getEmail());
		return list;
	}

	public void setAll(List<String> list) {
		setStudent_name(list.get(0));
		setCourse_name(list.get(1));
		setEmail(list.get(2));
	}

}
