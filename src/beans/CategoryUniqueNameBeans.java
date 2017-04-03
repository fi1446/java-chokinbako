package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryUniqueNameBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String name;
	
	public CategoryUniqueNameBeans() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getName());
		return list;
	}

	public void setAll(List<String> list) {
		setName(list.get(0));
	}

}
