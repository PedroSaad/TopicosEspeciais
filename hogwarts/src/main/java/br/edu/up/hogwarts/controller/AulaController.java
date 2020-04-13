package br.edu.up.hogwarts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.hogwarts.entity.Aula;
import br.edu.up.hogwarts.repository.AulaRepository;


@RestController
@RequestMapping("aula")
public class AulaController {

	@Autowired
	private AulaRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Aula>listAll(){
		Iterable<Aula> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Aula getById(@PathVariable Integer id) {
		Aula aula = repository.getOne(id);
		return aula;
	}
	
	@PostMapping
	public Aula add(@RequestBody @Valid Aula aula) {
		return repository.save(aula);
	}
	
	@DeleteMapping("/{id}")
	public Aula delete(@PathVariable Integer id) {
		Aula aula = repository.getOne(id);
		repository.delete(aula);
		return aula;
	}
}
