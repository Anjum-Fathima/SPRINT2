package com.cg.hsm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long>
{
	User findByUserName(String userName);
}
