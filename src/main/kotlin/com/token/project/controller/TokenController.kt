package com.token.project.controller

import com.token.project.model.Token
import com.token.project.service.TokenService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("token")
@RestController
class TokenController(val service: TokenService) {

    @GetMapping
    fun getaAll(): List<Token> {
        return service.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody token: Token): Token = service.create(token)
}