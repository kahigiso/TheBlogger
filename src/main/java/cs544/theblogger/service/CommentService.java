package cs544.theblogger.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.theblogger.entity.Comment;
import cs544.theblogger.repository.CommentRepository;


@Service
@Transactional
public class CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

	public Comment create(Comment comment) {
		return commentRepository.save(comment);
	}



}
