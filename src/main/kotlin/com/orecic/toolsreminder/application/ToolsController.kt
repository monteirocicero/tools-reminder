package com.orecic.toolsreminder.application

import com.orecic.toolsreminder.application.data.ToolRequest
import com.orecic.toolsreminder.service.ToolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger.getLogger


@RestController
@RequestMapping("/tools")
class ToolsController {

    @Autowired
    lateinit var toolService: ToolService

    @PostMapping
    fun register(request: ToolRequest) {
        logger.info("m=register toolRequest=$request")
        toolService.register(request)
    }

    companion object {
        private val logger
                = getLogger(ToolsController::class.java.name)
    }



}