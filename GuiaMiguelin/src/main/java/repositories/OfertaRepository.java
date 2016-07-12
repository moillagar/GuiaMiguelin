package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Establecimiento;
import domain.Oferta;


@Repository
public interface OfertaRepository extends JpaRepository<Oferta,Integer>{
	
	@Query("select o from Oferta o where o.nombre like %?1% or o.descripcion like %?1% or o.establecimiento.campus like %?1%")
	Collection<Oferta> findOfertaByKeyword(String key);

	@Query("select o from Oferta o where o.establecimiento.id=?1")
	Collection<Oferta> findOfertaByEstablecimiento(Integer id);

	@Query("select o from Oferta o where o.establecimiento.id=?1")
	Collection<Oferta> findOfertaByEstablecimientoId(int id);

}
