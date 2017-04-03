package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChecklistBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String checklist;

	// 引数なしのコンストラクタ
		public ChecklistBeans() {

		}

		// 以下、setter/getter

		public String getChecklist() {
			return checklist;
		}

		public void setChecklist(String checklist) {
			this.checklist = checklist;
		}

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getChecklist());
		return list;
	}

	public void setAll(List<String> list) {
		setChecklist(list.get(0));
	}

}
