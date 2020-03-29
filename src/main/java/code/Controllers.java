package code;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import code.dbobj.Task;
import code.repositories.TaskRepo;

@RestController
public class Controllers {

	@Autowired
	private TaskRepo taskRepo;

	@PostMapping("/addtask")
	public void addTask(@RequestParam(value = "title") String title,
			@RequestParam(value = "parent")int parent,
			@RequestParam(value = "status")String status,
			@RequestParam(value = "responsible")String responsible) {
		taskRepo.save(new Task(title, parent, responsible, status));
	}

	@GetMapping("/getall")
	public List<TaskRestObj> findAllTask(){
		Iterator<Task> iteratorTask = taskRepo.findAllByParent(0).iterator();
		List<TaskRestObj> listTaskRest = new LinkedList<>();
		while(iteratorTask.hasNext()) {
			listTaskRest.add(TaskCode.taskRekurs(iteratorTask.next(), taskRepo));
		}
		return listTaskRest;
	}	
	
	@GetMapping("/gettasks")
	public Iterable<Task> getAllTask(){
		Iterable<Task> tasks = taskRepo.findAll();
		return tasks;
	}

	@PostMapping("/delall")
	public void delTask() {
		taskRepo.deleteAll();
	}
}
