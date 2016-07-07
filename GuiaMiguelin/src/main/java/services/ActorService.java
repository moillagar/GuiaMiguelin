package services;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;
import domain.Estudiante;

@Service
@Transactional
public class ActorService {

	// Managed repository -----------------------------------------------------
	
			@Autowired
			private ActorRepository actorRepository;
			
			// Supporting services-----------------------------------------------------
			
			// Constructors -----------------------------------------------------------
			
			public ActorService() {
				super();
			}

			// Simple CRUD methods-------------------------------------------------------------

			public Actor create() {
				Actor result;
				result = new Actor();
				return result;
			}
			
			public void save(Actor actor) {
				Assert.notNull(actor,"intentando guardar un cliente nulo");
				actorRepository.save(actor);
			}

			public Actor findOne(Integer id) {
				Assert.isTrue(id!=0,"tried to find a customer with id zero");
				return actorRepository.findOne(id);
			}

			public Collection<Actor> findAll() {
				return actorRepository.findAll();
			}

			public void delete(Actor i) {
				Assert.notNull(i,"intentando borrar un cliente nulo");
				actorRepository.delete(i);
			}

			public Actor getLoggedActor() {
				Actor result;
				UserAccount user;
				user = LoginService.getPrincipal();
				result = actorRepository.findActorByUsername(user.getUsername());
				return result;
			}
	
	
}
