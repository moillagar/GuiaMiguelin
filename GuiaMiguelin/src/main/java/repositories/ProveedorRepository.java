package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Estudiante;
import domain.Proveedor;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>{
	@Query("select a from Proveedor a where a.user.username=?1")
	Proveedor findProveedorByUsername(String username );
	

	@Query("select s from Proveedor s where s.userCode=?1")
	Proveedor findProveedorByUserCode(String userCode);
}
