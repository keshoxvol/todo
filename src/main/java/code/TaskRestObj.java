package code;

import java.util.List;
import java.util.Set;

public class TaskRestObj {
	
	private String title;
	private String responsible;
	private String status;
	private List<TaskRestObj> childList;
	
	public TaskRestObj(String title, String responsible, String status, List<TaskRestObj> childList) {
		this.title = title;
		this.responsible = responsible;
		this.status = status;
		this.setChildList(childList);
	}
	
	public TaskRestObj(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public List<TaskRestObj> getChildList() {
		return childList;
	}

	public void setChildList(List<TaskRestObj> childList) {
		this.childList = childList;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
