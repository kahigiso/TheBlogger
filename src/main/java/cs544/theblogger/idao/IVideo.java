package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Video;


@Transactional(propagation=Propagation.MANDATORY)
public interface IVideo {
	public  Video create(Video video);
	public  void update(Video video);
	public  Video get(Long id);
	public  List<Video> getAll();
	public  void delete(Long id);
}
