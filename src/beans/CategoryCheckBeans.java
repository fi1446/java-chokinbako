package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getCheck());
		return list;
	}

	public void setAll(List<String> list) {
		setCheck(list.get(0));
	}

}
