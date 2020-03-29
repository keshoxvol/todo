package code;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

import code.dbobj.Task;
import code.repositories.TaskRepo;

public class TaskCode {
	
	public static TaskRestObj taskRekurs(Task task, TaskRepo taskRepo) {
		Iterator<Task> childTasks = taskRepo.findAllByParent(task.getId()).iterator();
		List<TaskRestObj> listTaskRest = new LinkedList<>();
		while(childTasks.hasNext()) {
			listTaskRest.add(taskRekurs(childTasks.next(), taskRepo));
		}
		return new TaskRestObj(task.getTitle(), task.getResponsible(), task.getStatus(), listTaskRest);
	}
}
