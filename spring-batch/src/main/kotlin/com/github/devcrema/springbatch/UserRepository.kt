package com.github.devcrema.springbatch

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val jpaUserRepository: JpaUserRepository
) {

    fun save(user: User): User = jpaUserRepository.save(user)

    fun findById(id: Long): User? = jpaUserRepository.findByIdOrNull(id)
}

interface JpaUserRepository: JpaRepository<User, Long>
