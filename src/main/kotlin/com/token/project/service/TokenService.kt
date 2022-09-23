package com.token.project.service

import com.token.project.model.Token
import com.token.project.repositories.TokenRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class TokenService(val repository: TokenRepository) {
    fun getAll(): List<Token> = repository.findAll()

    fun getAllByDay(dia: String): List<Token> {
        return repository.findAllByDay(dia)
    }

    fun create(token: Token): Token = repository.save(token)
}