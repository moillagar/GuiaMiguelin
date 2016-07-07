package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Estudiante;
import domain.Photo;

import repositories.PhotoRepository;

@Service
@Transactional
public class PhotoService {
	
	// Managed repository -----------------------------------------------------
	
		@Autowired
		private PhotoRepository photoRepository;
		@Autowired
		private EstudianteService estudianteService;
		// Supporting services-----------------------------------------------------
		
		// Constructors -----------------------------------------------------------
		
		public PhotoService() {
			super();
		}

		// Simple CRUD methods-------------------------------------------------------------

		public Photo create() {
			Photo result;
			result = new Photo();
			return result;
		}
		
		public void save(Photo photo) {
			Assert.notNull(photo,"intentando guardar un cliente nulo");
			photoRepository.save(photo);
		}
		
		public void delete(Photo photo) {
			Assert.notNull(photo,"intentando guardar un cliente nulo");
			Estudiante estudiante = estudianteService.getLoggedSingle();
			//Assert.isTrue(estudiante.getPhotos().contains(photo), "la foto no pertenece al estudiante");
			photoRepository.delete(photo);
		}

		public Photo findOne(Integer id) {
			Assert.isTrue(id!=0,"tried to find a customer with id zero");
			return photoRepository.findOne(id);
		}

		public Collection<Photo> findAll() {
			return photoRepository.findAll();
		}

		public void Cliente(Photo i) {
			Assert.notNull(i,"intentando borrar un cliente nulo");
			photoRepository.delete(i);
		}

		// Other business methods -------------------------------------------------
		/*public Photo getAvatar(){
			Photo photo;
			Estudiante estudiante;
			estudiante=estudianteService.getLoggedSingle();
			photo=photoRepository.getAvatar(estudiante.getId());
			return photo;
		}
		public Photo getAvatarPlace(Integer id){
			Photo photo;
			photo=photoRepository.getAvatarEstablecimiento(id);
			return photo;
		}
		
		public Photo getAvatar(Integer id){
			Photo photo;			
			photo=photoRepository.getAvatar(id);
			return photo;
		}*/
}
