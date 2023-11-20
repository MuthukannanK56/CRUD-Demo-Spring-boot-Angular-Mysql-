package com.CrudDemo.CRUD.operation.backend.Repository;

import com.CrudDemo.CRUD.operation.backend.Model.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
