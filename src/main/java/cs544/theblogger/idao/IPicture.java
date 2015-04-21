package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Picture;

@Transactional(propagation=Propagation.MANDATORY)
public interface IPicture {
	public  Picture create(Picture picture);
	public  void update(Picture picture);
	public  Picture get(Long id);
	public  List<Picture> getAll();
	public  void delete(Long id);
}
