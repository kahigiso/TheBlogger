package cs544.theblogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs544.theblogger.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
