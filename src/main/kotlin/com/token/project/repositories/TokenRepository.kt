package com.token.project.repositories

import com.token.project.model.Token
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface TokenRepository : JpaRepository<Token, Int> {
    @Query("SELECT tk FROM Token tk WHERE tk.token_date = :day")
     fun findAllByDay(@Param("day") dia: LocalDate): List<Token>

     @Query("SELECT * FROM tokens tk WHERE tk.token_date >= :startDate AND tk.token_date <= :endDate", nativeQuery = true)
     fun findAllByMonth(@Param("startDate") startDate: String, @Param("endDate") endDate: String): List<Token>
}