package com.example.simplerestexample.repository;

import com.example.simplerestexample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    //Essa interface possibilita usar os metodos list, save, delet, update
    //sempre vai herdar JPARepository o Model e o tipo de variavel usado no id
}
