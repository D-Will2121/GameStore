package com.dwill.gamestore.config;

import com.dwill.gamestore.model.game.Game;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dwill.gamestore.repository.game",
        entityManagerFactoryRef = "gameEntityManagerFactory",
        transactionManagerRef= "gameTransactionManager"
)
public class GameConfig {
    @Bean
    @ConfigurationProperties("app.datasource.game")
    public DataSourceProperties gameDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("app.datasource.game.configuration")
    public DataSource gameDataSource() {
        return gameDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "gameEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean gameEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(gameDataSource())
                .packages(Game.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager gameTransactionManager(
            final @Qualifier("gameEntityManagerFactory") LocalContainerEntityManagerFactoryBean gameEntityManagerFactory) {
        return new JpaTransactionManager(gameEntityManagerFactory.getObject());
    }
}
