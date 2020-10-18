package com.orecic.toolsreminder.service

import com.orecic.toolsreminder.application.data.ToolRequest
import com.orecic.toolsreminder.application.data.ToolResponse
import com.orecic.toolsreminder.domain.ToolEntity
import com.orecic.toolsreminder.infraestructure.repository.ToolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ToolServiceImpl: ToolService {

    @Autowired
    lateinit var toolRepository: ToolRepository

    override fun register(toolRequest: ToolRequest): ToolResponse {
       val toolsRegisted:ToolEntity = toolRepository.save(toolRequest.toEntity())
        return ToolResponse(toolsRegisted.id, toolsRegisted.title, toolsRegisted.link, toolsRegisted.description, toolsRegisted.tags)
    }

    override fun delete(id: String) {
        toolRepository.deleteById(id)
    }

    override fun retrieveAll(): List<ToolResponse> {
        val allTools = toolRepository.findAll()
        return allTools.map { ToolResponse(it.id, it.title, it.link, it.description, it.tags) }.toList()
    }

}