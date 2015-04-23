package cs544.theblogger.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cs544.theblogger.entity.Comment;
import cs544.theblogger.repository.CommentRepository;


@Service
@Transactional
public class CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	private static final int PAGE_SIZE = 10;
	
	public Comment create(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public Page<Comment> getAll(Integer pageNumber){
		PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "createdDate");
		return  commentRepository.findAll(pageRequest);
	}

	public Comment find(long id) {
		return commentRepository.findOne(id);
	}

	public void delete(long id) {
		commentRepository.delete(id);
	}

}
