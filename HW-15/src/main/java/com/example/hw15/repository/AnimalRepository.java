package com.example.hw15.repository;

import com.example.hw15.entity.Animal;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    //Почему не работает?
//    @Query("SELECT new map(CONCAT(a.type.type, ' ', a.name, ' ', a.id) AS typeName, a.birthDate) FROM Animal a WHERE YEAR(a.birthDate) % 4 = 0")
//    Map<String, LocalDate> findLeapYearNames1();

    @Query("SELECT a FROM Animal a WHERE YEAR(a.birthDate) % 4 = 0")
    List<Animal> findLeapYearNames();

    @Query("SELECT a FROM Animal a WHERE YEAR(CURRENT_DATE()) - YEAR(a.birthDate) > :age")
    List<Animal> findAllAnimalsOlderThan(@Param("age") int age);

    @Query("SELECT a from Animal a where a.name = :name")
    List<Animal> getAnimalsByName(@Param("name") String name);

    @Query("SELECT a from Animal a")
    List<Animal> getAllAnimals();

}
