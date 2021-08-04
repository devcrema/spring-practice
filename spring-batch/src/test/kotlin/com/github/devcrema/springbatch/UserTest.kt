package com.github.devcrema.springbatch

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.ZoneOffset.UTC

internal class UserTest {

    @Test
    fun `validateInActiveUser when now registered then enabled true`() {
        // given
        val nowRegistered = User(email = "test1@mail.com")
        // when
        nowRegistered.validateInActiveUser(LocalDateTime.now(UTC))
        // then
        Assertions.assertEquals(true, nowRegistered.enabled)
    }

    @Test
    fun `validateInActiveUser when 1 year ago registered then enabled false`() {
        // given
        val yearAgoRegistered = User(
            email = "test1@mail.com",
            registeredAt = LocalDateTime.now(UTC)
                .minusYears(1)
                .minusDays(1)
        )
        // when
        yearAgoRegistered.validateInActiveUser(LocalDateTime.now(UTC))
        // then
        Assertions.assertEquals(false, yearAgoRegistered.enabled)
    }
}