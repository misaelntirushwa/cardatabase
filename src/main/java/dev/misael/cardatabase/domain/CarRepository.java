package dev.misael.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    // Fetch cars by brand
    List<Car> findByBrand(String brand);

    // Fetch cars by color
    List<Car> findByColor(String color);

    // Fetch cars by year
    List<Car> findByYear(int year);

    // Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYearAsc(String brand);

}
