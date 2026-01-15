package gson.ex;

import java.io.Serializable;

public class Source implements Serializable {
	
	private static final long serialVersionUID = 3289472339034L;
	
	private String id;
	private String name;
	
	public Source() {
	}

	public Source(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", name=" + name + "]";
	}
	
}
