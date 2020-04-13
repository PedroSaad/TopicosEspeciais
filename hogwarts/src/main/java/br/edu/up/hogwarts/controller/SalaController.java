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

import br.edu.up.hogwarts.entity.Sala;
import br.edu.up.hogwarts.repository.SalaRepository;

@RestController
@RequestMapping("sala")
public class SalaController {
	
	@Autowired
	private SalaRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Sala>listAll(){
		Iterable<Sala> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Sala getById(@PathVariable Integer id) {
		Sala sala = repository.getOne(id);
		return sala;
	}
	
	@PostMapping
	public Sala add(@RequestBody @Valid Sala sala) {
		return repository.save(sala);
	}
	
	@DeleteMapping("/{id}")
	public Sala delete(@PathVariable Integer id) {
		Sala sala = repository.getOne(id);
		repository.delete(sala);
		return sala;
	}
}
