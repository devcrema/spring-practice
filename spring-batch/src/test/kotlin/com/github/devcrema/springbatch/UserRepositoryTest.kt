package com.github.devcrema.springbatch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import java.util.*

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class UserRepositoryTest(
    private val userRepository: UserRepository
) {

    @Test
    fun save() {
        // given
        val user = User(email = "${UUID.randomUUID()}@email.com")
        // when
        userRepository.save(user)
        // then
        assertEquals(user, userRepository.findById(user.id))
    }

    @Test
    fun `findById when invalid userId then return null`() {
        // given, when
        val result = userRepository.findById(0L)
        // then
        assertNull(result)
    }
}
