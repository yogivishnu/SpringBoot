package com.amman.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amman.finance.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
