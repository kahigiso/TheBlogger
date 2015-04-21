package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Comment;

@Transactional(propagation=Propagation.MANDATORY)
public interface IComment {
	public  Comment create(Comment comment);
    public  void update(Comment comment);
    public  Comment get(Long id);
    public  List<Comment> getAll();
    public  void delete(Long id);
}
