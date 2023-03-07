package com.project.backend.controller;

import java.util.List;

import com.project.backend.domain.OurUser;
import com.project.backend.exception.OurUserNotFoundException;
import com.project.backend.repository.OurUserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class OurUserController {

    private final OurUserRepository repository;

    OurUserController(OurUserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<OurUser> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    OurUser newEmployee(@RequestBody OurUser newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    OurUser one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new OurUserNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    OurUser replaceEmployee(@RequestBody OurUser newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}