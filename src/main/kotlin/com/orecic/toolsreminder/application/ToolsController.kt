package com.orecic.toolsreminder.application

import com.orecic.toolsreminder.application.data.ToolRequest
import com.orecic.toolsreminder.application.data.ToolResponse
import com.orecic.toolsreminder.service.ToolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger.getLogger
import javax.security.auth.callback.ConfirmationCallback.OK


@RestController
@RequestMapping("/tools")
class ToolsController {

    @Autowired
    lateinit var toolService: ToolService

    @PostMapping
    fun register(@RequestBody request: ToolRequest): ResponseEntity<*> {
        logger.info("m=register toolRequest=$request")
        try {
            val response = toolService.register(request)
            return ResponseEntity(response, CREATED)
        } catch (e: Exception) {
            logger.info("m=register error=${e.message}")
        }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable("id") id: String): ResponseEntity<*> {
        logger.info("m=delete id=$id")
        try {
            toolService.delete(id)
            return ResponseEntity.ok().body(OK)
        } catch (e: Exception) {
            logger.info("m=delete id=$id")
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @GetMapping
    fun retrieveAll(): ResponseEntity<*>{
        logger.info("m=retrieveAll")
        try {
            toolService.retrieveAll()
        } catch (e: Exception) {
            logger.info("m=retrieveAll")
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    companion object {
        private val logger
                = getLogger(ToolsController::class.java.name)
    }

}