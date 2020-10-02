package com.example.simplerestexample.controller;


import com.example.simplerestexample.model.Person;

import com.example.simplerestexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;


    //Salva uma pessoa no banco
    @PostMapping("/personCreate")
    public ResponseEntity<Person> savePerson(@RequestBody @Validated Person person){
        return new ResponseEntity<Person>(personRepository.save(person), HttpStatus.CREATED);
    }

    //Faz alteração de cadastro
    @PutMapping("/personAlter/{id}")
    public ResponseEntity<Person> update(@PathVariable(value = "id") long id, @RequestBody @Validated Person person){
        Optional<Person> persona = personRepository.findById(id);
        if (!persona.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            person.setId(persona.get().getId());
            return new ResponseEntity<Person>(personRepository.save(person), HttpStatus.OK);
        }
    }


    //Busca todas pessoas cadastradas
    @GetMapping("/personSearch")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> personList = personRepository.findAll();
        if(personList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
        }
    }

    //Busca pessoa por ID
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getOnePerson(@PathVariable(value="id") long id){
        Optional<Person> person = personRepository.findById(id);
        if(!person.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Person>(person.get(), HttpStatus.OK);
        }
    }

    //Deleta pessoa
    @DeleteMapping("/personDelete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value="id") long id){
        Optional<Person> person = personRepository.findById(id);
        if(!person.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            personRepository.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
