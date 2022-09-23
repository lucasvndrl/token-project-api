package com.token.project.repositories

import com.token.project.model.Token
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TokenRepository : JpaRepository<Token, Int> {
    @Query("SELECT tk FROM Token tk WHERE tk.token_date = :dia")
     fun findAllByDay(@Param("dia") dia: String): List<Token>
}