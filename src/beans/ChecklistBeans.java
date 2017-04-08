package beans;

import java.io.Serializable;

public class ChecklistBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;
	private String checklist;

	public ChecklistBeans() {

	}

	public String getChecklist() {
		return checklist;
	}

	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}
}
