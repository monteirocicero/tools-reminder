package com.orecic.toolsreminder.infraestructure.repository

import com.orecic.toolsreminder.domain.ToolEntity
import org.springframework.data.repository.CrudRepository

interface ToolRepository: CrudRepository<ToolEntity, String> {
    fun findByTags(tag: String): List<ToolEntity>
}