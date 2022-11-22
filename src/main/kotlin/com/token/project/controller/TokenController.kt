package com.token.project.controller

import com.token.project.model.Token
import com.token.project.service.TokenService
import com.token.project.utils.DateFormatUtils
import com.token.project.utils.MonthObject
import org.hibernate.annotations.Parameter
import org.springframework.data.repository.query.Param
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month
import java.util.Date

@RequestMapping("token")
@RestController
class TokenController(val service: TokenService) {

    @GetMapping("/")
    fun getaAll(): List<Token> {
        return service.getAll()
    }

    @GetMapping("/day")
    fun getAllByDay(): List<Token> {
        return service.getAllByDay(DateFormatUtils.diaHoje)
    }

    @GetMapping("/month")
    fun getAllBymonth(@RequestBody month: MonthObject): List<Token> {
        return service.getAllByMes(month.month)
    }

    @GetMapping("/finished")
    fun getAllFinishedTokens(): List<Token> {
        return service.getAllFinishedTokens()
    }

    @GetMapping("/priority")
    fun getAllPriorityTokens(): List<Token> {
        return service.getAllPriorityTokens()
    }

    @GetMapping("/finished_priority")
    fun getAllFinishedPriorityTokens(): List<Token> {
        return service.getAllFinishedPriorityTokens()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody token: Token): Token {
        return service.create(token)
    }
}
