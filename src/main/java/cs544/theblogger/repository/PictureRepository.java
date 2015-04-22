package cs544.theblogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs544.theblogger.entity.Picture;


public interface PictureRepository extends JpaRepository<Picture, Long>{
}
