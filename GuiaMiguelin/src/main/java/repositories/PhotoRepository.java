package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	/*@Query("select p from Estudiante s where s.id=?1 and p.avatar=true")
	Photo getAvatar(Integer estudianteId);
	
	@Query("select p from Establecimiento s  where s.id=?1 and p.avatar=true")
	Photo getAvatarEstablecimiento(Integer establecimientoId);*/
//	
}

