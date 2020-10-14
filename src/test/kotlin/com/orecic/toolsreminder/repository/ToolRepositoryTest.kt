package com.orecic.toolsreminder.repository

import com.orecic.toolsreminder.application.data.ToolRequest
import com.orecic.toolsreminder.service.ToolService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ToolRepositoryTest {

    @Autowired
    lateinit var toolService: ToolService

    @Test
    fun testRegister() {
        val toolRequest = ToolRequest("title1", "link1", "description1", listOf("tag1"))
        toolService.register(toolRequest)
    }


}