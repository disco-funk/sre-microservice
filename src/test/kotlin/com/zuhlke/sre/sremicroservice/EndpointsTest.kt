package com.zuhlke.sre.sremicroservice

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EndpointsTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun testIsAliveController() {
        val result = testRestTemplate.getForEntity("/isAlive", String::class.java)
        assertEquals(HttpStatus.OK, result.statusCode)
        assertEquals("{\"status\":\"Active\"}", result.body)
    }
}