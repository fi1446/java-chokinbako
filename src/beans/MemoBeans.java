package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemoBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String memo;

	public MemoBeans() {

	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getMemo());
		return list;
	}

	public void setAll(List<String> list) {
		setMemo(list.get(0));
	}

}
