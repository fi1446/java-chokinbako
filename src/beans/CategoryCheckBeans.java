package beans;

import java.io.Serializable;

public class CategoryCheckBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;
	private String check;

	public CategoryCheckBeans() {

	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
}
