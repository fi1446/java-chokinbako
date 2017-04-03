package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentNewInfoBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String name;
	private String email;
	private int logins_id;
	
	public StudentNewInfoBeans() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLogins_id() {
		return logins_id;
	}

	public void setLogins_id(int logins_id) {
		this.logins_id = logins_id;
	}

}
