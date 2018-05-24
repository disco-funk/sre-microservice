package com.zuhlke.sre.sremicroservice

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface ReactiveCustomerRepository : ReactiveCrudRepository<City, Long> {

    @Query("{ 'city': ?0 }")
    fun findByCity(city: String): Mono<City>
}