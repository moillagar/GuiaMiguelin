package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Establecimiento;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento,Integer>{

	
	@Query("select e from Establecimiento e where e.proveedor.id=?1")
	Collection<Establecimiento> findEstablecimientoByProveedorId(Integer id);
	
	
	
	@Query("select e from Establecimiento e where e.publicado is false")
	Collection<Establecimiento> findEstablecimientoNoPublicado();



	@Query("select e from Establecimiento e where e.publicado is true order by e.nombre")
	Collection<Establecimiento> findAllOrderByName();


	@Query("select e from Establecimiento e where e.publicado is true")
	Collection<Establecimiento> findPublicados();
}
