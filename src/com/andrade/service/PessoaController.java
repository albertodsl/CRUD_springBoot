package com.andrade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.model.Pessoa;
import com.andrade.repository.PessoaRepository;

@RestController
@RequestMapping("/rs")
public class PessoaController {

	@Autowired
	private PessoaRepository dao;
	
	@PostMapping(value="/pessoa",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody Pessoa pessoa){
		try {
			
			dao.save(pessoa);
			
			return new ResponseEntity<String>("Dados gravados",HttpStatus.CREATED);
			
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/pessoas",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pessoa>> findAll(){
		
		List<Pessoa> lista = new ArrayList<>();
		
		try {
			lista = (ArrayList<Pessoa>) dao.findAll();
			
			return new ResponseEntity<List<Pessoa>>(lista,HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<List<Pessoa>>(lista ,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/pessoa/{id}")
	public ResponseEntity<Optional<Pessoa>> findByCode(@PathVariable("id") String cod){
		
		Optional<Pessoa> pessoa = null;
		
		try {
			pessoa = dao.findById(new Integer(cod));

			return new ResponseEntity<Optional<Pessoa>>(pessoa,HttpStatus.FOUND);
			
		} catch (Exception ex) {
			return new ResponseEntity<Optional<Pessoa>>(pessoa ,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/pessoa",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@RequestBody Pessoa pessoa){
		try {
			
			dao.save(pessoa);
			
			return new ResponseEntity<String>("Dados Alterados",HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro; " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/pessoa/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String cod){
		try {
			
			dao.deleteById(new Integer(cod));
			
			return new ResponseEntity<String>("Dados excluidos",HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<String>("Erro: " + ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
