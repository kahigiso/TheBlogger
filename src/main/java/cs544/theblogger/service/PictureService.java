package cs544.theblogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.repository.PictureRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PictureService{
	
	@Autowired
	private PictureRepository pictureRepository;

	
}
