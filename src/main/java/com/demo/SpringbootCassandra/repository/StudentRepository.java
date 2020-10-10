package com.demo.SpringbootCassandra.repository;

import com.demo.SpringbootCassandra.models.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StudentRepository extends CassandraRepository<Student,Integer> {}
