package com.zuhlke.sre.sremicroservice

import com.mongodb.reactivestreams.client.MongoClients
import lombok.RequiredArgsConstructor
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.DependsOn
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

/**
 * Simple configuration that registers a [LoggingEventListener] to demonstrate mapping behavior when streaming
 * data.
 *
 * @author Mark Paluch
 */
@EnableReactiveMongoRepositories
@AutoConfigureAfter(EmbeddedMongoAutoConfiguration::class)
@RequiredArgsConstructor
internal class ApplicationConfiguration : AbstractReactiveMongoConfiguration() {

    private val environment: Environment? = null

    @Bean
    fun mongoEventListener(): LoggingEventListener {
        return LoggingEventListener()
    }

    @Bean
    @DependsOn("embeddedMongoServer")
    override fun reactiveMongoClient(): com.mongodb.reactivestreams.client.MongoClient {
        val port = environment!!.getProperty("local.mongo.port", Int::class.java)
        return MongoClients.create(String.format("mongodb://localhost:%d", port))
    }

    override fun getDatabaseName(): String {
        return "reactive"
    }
}