package com.github.devcrema.springbatch

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.utility.DockerImageName
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
        val MY_SQL_CONTAINER: MySQLContainer<*> =
                // image for linux/arm64/v8 m1 support
                DockerImageName.parse("mysql/mysql-server:8.0.26")
                        .asCompatibleSubstituteFor("mysql")
                        .let { compatibleImageName -> MySQLContainer<Nothing>(compatibleImageName) }
                        .apply {
                            withDatabaseName(DATABASE_NAME)
                            withUsername(USERNAME)
                            withPassword(PASSWORD)
                            withEnv("MYSQL_USER", USERNAME)
                            withEnv("MYSQL_PASSWORD", PASSWORD)
                            withEnv("MYSQL_ROOT_PASSWORD", PASSWORD)
                            start()
                        }

        const val DATABASE_NAME: String = "batch_test"
        const val USERNAME: String = "root"
        const val PASSWORD: String = "password"
    }
}