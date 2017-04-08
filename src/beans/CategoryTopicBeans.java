package beans;

import java.io.Serializable;

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
}
