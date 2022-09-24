package controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dto.FigurinhaDTO;
import models.Figurinha;
import service.FigurinhaService;

@RestController
@RequestMapping("/figurinhas")
public class FigurinhaController {
	
	@Autowired
	private FigurinhaService figurinhaService;		
	
	@PostMapping
	public ResponseEntity<Figurinha> saveFigurinha(@RequestBody Figurinha fig) {
		return new ResponseEntity<>(figurinhaService.saveFigurinha(fig),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public List<Figurinha> getFigurinha(@PathVariable Long id) {
		return figurinhaService.listFigurinha(id);
	}
	
	@GetMapping("/{idDono}")
	@ResponseBody
	public ResponseEntity<List<Figurinha>> getAllFigurinhasPorUsuario(@PathVariable("idDono") Long idDono) {
		return new ResponseEntity<>(figurinhaService.getFigurinhasByUser(idDono), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FigurinhaDTO> insert(@RequestBody FigurinhaDTO dto ){
		dto = figurinhaService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<FigurinhaDTO> update(@PathVariable Long id, @RequestBody FigurinhaDTO dto){
		dto = figurinhaService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping( value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		figurinhaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
}