package repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.*;

@Repository
public interface CalificacionOfertaRepository extends JpaRepository<CalificacionOferta,Integer>{

	@Query("select c from CalificacionOferta c where c.oferta.id=?1 order by creationMoment")
	Collection<CalificacionOferta> findCalificacionOfertaByOfertaId(int id);

	@Query("select c from CalificacionOferta c order by creationMoment")
	List<CalificacionOferta> findLastCalificacionOfertaOrderBy();

}
