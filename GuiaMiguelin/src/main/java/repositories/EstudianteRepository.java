package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Estudiante;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Integer>{

	
	@Query("select a from Estudiante a where a.user.username=?1")
	Estudiante findEstudianteByUsername(String username );
	

	@Query("select s from Estudiante s where s.userCode=?1")
	Estudiante findEstudianteByUserCode(String userCode);

}
