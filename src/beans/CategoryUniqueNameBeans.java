package beans;

import java.io.Serializable;

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
}
