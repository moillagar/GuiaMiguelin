package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Clientes;



@Repository
public interface ClientesRepository extends JpaRepository<Clientes,Integer>{

	@Query("select a from Clientes a where a.user.username=?1")
	Clientes findActorByUsername(String username );

	@Query("select c from Clientes c where c.user.username=?1")
	Clientes findCustomerByUserNmae(String userName);

}
