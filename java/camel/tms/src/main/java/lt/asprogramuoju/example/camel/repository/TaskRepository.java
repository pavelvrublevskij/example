package lt.asprogramuoju.example.camel.repository;

import lt.asprogramuoju.example.camel.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
