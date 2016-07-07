package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Incidencia;


@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia,Integer>{

	
	@Query("select i from Incidencia i order by i.updateMoment ASC")
	Collection<Incidencia> findIncidenciasOrder();
	
	@Query("select i from Incidencia i where i.estado='PENDIENTE' or i.administrator.id=null")
	Collection<Incidencia> findIncidenciasPendientes();

	@Query("select i from Incidencia i where i.estudiante.id=?1")
	Collection<Incidencia> findIncidenciaByEstudiante(int id);

	@Query("select i from Incidencia i where i.oferta.id=?1")
	Collection<Incidencia> findIncidenciaByOfertaId(int id);

}
