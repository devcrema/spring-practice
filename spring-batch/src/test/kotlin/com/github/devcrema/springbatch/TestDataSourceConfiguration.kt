package com.github.devcrema.springbatch

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.testcontainers.containers.MySQLContainer
import javax.sql.DataSource

@Configuration
class TestDataSourceConfiguration {

    @Bean
    @DependsOn("mySqlTestContainer")
    fun dataSource(): DataSource =
            DataSourceBuilder.create()
                    .url("jdbc:mysql://localhost:" +
                            "${MySqlTestContainer.MY_SQL_CONTAINER.getMappedPort(MySQLContainer.MYSQL_PORT)}/" +
                            MySqlTestContainer.DATABASE_NAME)
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .username(MySqlTestContainer.USERNAME)
                    .password(MySqlTestContainer.PASSWORD)
                    .build()

}
