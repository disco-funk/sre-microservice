package com.zuhlke.sre.sremicroservice

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.toMono

@RunWith(SpringRunner::class)
@SpringBootTest
class SreMicroserviceApplicationTests {

	@Test

	fun getSomeData() {
		val client = ApplicationConfiguration().reactiveMongoClient()

		val block = client.listDatabases().first().toMono().block()

		println(block.toString())
	}
}
