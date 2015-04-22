package cs544.theblogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs544.theblogger.entity.Video;


public interface VideoRepository extends JpaRepository<Video, Long>{

}
