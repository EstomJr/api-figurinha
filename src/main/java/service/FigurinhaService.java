package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.FigurinhaDTO;
import models.Figurinha;
import repository.FigurinhaRepository;


@Service

public class FigurinhaService {
	
@Autowired
	
	private FigurinhaRepository figurinhaRepository;
	private ArrayList<Figurinha> figurinhaList = new ArrayList<>();
	
	public List<Figurinha> getFigurinhas() {
		return figurinhaRepository.findAll();
	}

	public Figurinha saveFigurinha(Figurinha fig) {
		return figurinhaRepository.save(fig);
	}

	// Retorna lista de figurinhas pelo Id
	public List<Figurinha> listFigurinha(long id) {
		List<Figurinha> selected = new ArrayList<>();
		for (Figurinha figurinha : figurinhaList) {
			if (figurinha.getIdDono().equals(id)) {
				selected.add(figurinha);
			}
		}
		return selected;
	}

	public List<Figurinha> getFigurinhasByUser(Long idUser) {
		List<Figurinha> figurinhas = figurinhaRepository.findAll();
		List<Figurinha> figurinhasPorUsuario = new ArrayList<>();
		for (int j = 0; figurinhas.size() > j; j++) {
			if (figurinhas.get(j).getIdDono() == idUser) {
				figurinhasPorUsuario.add(figurinhas.get(j));
			}

		}
		return figurinhasPorUsuario;
	}

	public void delete(Long id) {
		figurinhaRepository.deleteById(id);
	    }

	public FigurinhaDTO update(Long id, FigurinhaDTO dto) {
		Figurinha entity = figurinhaRepository.getReferenceById(id);
		entity.setNomeJogador(dto.getNomeJogador());
		entity.setSelecaoJogador(dto.getSelecaoJogador());
		entity = figurinhaRepository.save(entity);
		return new FigurinhaDTO(entity);
	}

	public FigurinhaDTO insert(FigurinhaDTO dto) {
		Figurinha entity  = new Figurinha();
		entity.setNomeJogador(dto.getNomeJogador());
		entity.setSelecaoJogador(dto.getSelecaoJogador());
		entity.setIdDono(dto.getIdDono());
		entity = figurinhaRepository.save(entity);
		return new FigurinhaDTO(entity);
	}

		
}





