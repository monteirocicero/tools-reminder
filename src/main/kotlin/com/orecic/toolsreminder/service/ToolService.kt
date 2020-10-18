package com.orecic.toolsreminder.service

import com.orecic.toolsreminder.application.data.ToolRequest
import com.orecic.toolsreminder.application.data.ToolResponse

interface ToolService {
    fun register(toolRequest: ToolRequest): ToolResponse
    fun delete(id: String)
    fun retrieveAll(): List<ToolResponse>
}