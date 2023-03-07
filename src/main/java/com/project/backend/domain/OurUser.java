package com.project.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public
class OurUser {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

//    User(String name, String role) {
//
//        this.name = name;
//        this.role = role;
//    }

//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o)
//            return true;
//        if (!(o instanceof User))
//            return false;
//        User employee = (User) o;
//        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
//                && Objects.equals(this.role, employee.role);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.name, this.role);
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
//    }
}