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

import br.edu.up.hogwarts.entity.Bruxo;
import br.edu.up.hogwarts.repository.BruxoRepository;

@RestController
@RequestMapping("bruxo")
public class BruxoController {

	@Autowired
	private BruxoRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Bruxo>listAll(){
		Iterable<Bruxo> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Bruxo getById(@PathVariable Integer id) {
		Bruxo bruxo = repository.getOne(id);
		return bruxo;
	}
	
	@PostMapping
	public Bruxo add(@RequestBody @Valid Bruxo bruxo) {
		return repository.save(bruxo);
	}
	
	@DeleteMapping("/{id}")
	public Bruxo delete(@PathVariable Integer id) {
		Bruxo bruxo = repository.getOne(id);
		repository.delete(bruxo);
		return bruxo;
	}
}
