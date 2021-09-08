package io.bigobject.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.bigobject.demo.bean.Company;
import io.bigobject.demo.bean.User;

@Transactional
@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    @Query(value = "from User" )
    public List<Company> findAll();
}