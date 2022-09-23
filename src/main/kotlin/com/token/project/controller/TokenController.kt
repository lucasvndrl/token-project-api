package com.token.project.controller

import com.token.project.model.Token
import com.token.project.service.TokenService
import com.token.project.utils.DateFormatUtils
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RequestMapping("token")
@RestController
class TokenController(val service: TokenService) {

    @GetMapping("/")
    fun getaAll(): List<Token> {
        return service.getAll()
    }

    @GetMapping("/dia")
    fun getAllByDay(): List<Token> {
        return service.getAllByDay(DateFormatUtils.diaHojeFormatado.format(Date()))
    }

//    @GetMapping("/mes")
//    fun getAllByMes(): List<Token> {
//        return service.getAllByMes()
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody token: Token): Token = service.create(token)
}