package com.token.project.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tokens")
data class Token(
    @Id @GeneratedValue var id: Int,
    var token_type: String,
    var token_date: String
)



