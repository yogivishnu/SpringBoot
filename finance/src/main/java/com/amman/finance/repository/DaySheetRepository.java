package com.amman.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amman.finance.entity.DaySheet;

public interface DaySheetRepository extends JpaRepository<DaySheet, Long> {

}
