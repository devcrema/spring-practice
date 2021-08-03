package com.github.devcrema.springbatch

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.testcontainers.containers.MySQLContainer
import javax.annotation.PreDestroy

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
class MySqlTestContainer {

    @PreDestroy
    fun stop() {
        MY_SQL_CONTAINER.stop()
    }

    companion object {
        @JvmStatic
        val MY_SQL_CONTAINER: MySQLContainer<*> = MySQLContainer<Nothing>("mysql:8.0.26")
                .apply {
                    withDatabaseName(DATABASE_NAME)
                    withUsername(USERNAME)
                    withPassword(PASSWORD)
                    start()
                }

        const val DATABASE_NAME: String = "batch_test"
        const val USERNAME: String = "root"
        const val PASSWORD: String = "password"
    }
}