package code.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

import code.dbobj.Task;

public interface TaskRepo extends CrudRepository<Task, Long>{
	List<Task> findAllByParent(@Param("id") int id);
	Task findById(@Param("id") int id);
}
