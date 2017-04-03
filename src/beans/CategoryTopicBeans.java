package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryTopicBeans implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;

	private String topic;

	public CategoryTopicBeans() {

	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<String> getAll() {
		List<String> list = new ArrayList<>();
		list.add(getTopic());
		return list;
	}

	public void setAll(List<String> list) {
		setTopic(list.get(0));
	}

}
