package com.github.devcrema.springbatch

import java.time.LocalDateTime
import java.time.ZoneOffset.UTC
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String,
    val registeredAt: LocalDateTime = LocalDateTime.now(UTC),
    var enabled: Boolean = true,
){
    fun validateInActiveUser(criteriaTime: LocalDateTime){
        if(registeredAt < criteriaTime.minusYears(1)){
            this.enabled = false
        }
    }
}