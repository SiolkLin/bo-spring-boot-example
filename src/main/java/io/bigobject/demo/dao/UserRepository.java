package io.bigobject.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import io.bigobject.demo.bean.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "from User" )
    public List<User> findAll();

    @Query(value = "from User where company.id=?1" )
    public List<User> findByCompanyId(String id);
    
    @Query(value = "cluster select * from bo_example_user where company_id=?1 ",nativeQuery = true )
    public List<User> findByCompanyIdUsingNativeSql(String id);
    

}