package cs544.theblogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.theblogger.repository.VideoRepository;

@Service
public class VideoService{
	
	@Autowired
	private VideoRepository videoRepository;


}
