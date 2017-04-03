package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryNameBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String category1;
	private String category2;
	private String category3;
	private String category4;

	// 引数なしのコンストラクタ
		public CategoryNameBeans() {

		}

		// 以下、setter/getter

		public String getCategory1() {
			return category1;
		}

		public void setCategory1(String category1) {
			this.category1 = category1;
		}

		public String getCategory2() {
			return category2;
		}

		public void setCategory2(String category2) {
			this.category2 = category2;
		}

		public String getCategory3() {
			return category3;
		}

		public void setCategory3(String category3) {
			this.category3 = category3;
		}

		public String getCategory4() {
			return category4;
		}

		public void setCategory4(String category4) {
			this.category4 = category4;
		}

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getCategory1());
		list.add(getCategory2());
		list.add(getCategory3());
		list.add(getCategory4());
		return list;
	}

	public void setAll(List<String> list) {
		setCategory1(list.get(0));
		setCategory2(list.get(1));
		setCategory3(list.get(2));
		setCategory4(list.get(3));
	}

}
