package com.stockmarket.stockservice.database;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockmarket.stockservice.model.Stock;

@Repository
public interface StockReposittory extends JpaRepository<Stock, Long> {

	@Query("select s from Stock  s where companyCode=:companyCode and postedDate > :startDate and postedDate < :endDate")
	List<Stock> findByCompanyCodeAndStartDateAndEndDate(@Param("companyCode") String companyCode,
			@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

	void deleteByCompanyCode(@NotNull String companyCode);

	
	Optional<List<Stock>> findByCompanyCodeOrderByPostedDate(@NotNull String companyCode);

	Optional<List<Stock>> findByCompanyCodeOrderByIdDesc(@NotNull String companyCode);

}
