package com.orecic.toolsreminder.application.data

import com.orecic.toolsreminder.domain.ToolEntity

data class ToolRequest(val title: String, val link: String, val description: String, val tags: List<String>) {

    fun toEntity(): ToolEntity {
        return ToolEntity(title = title, link = link, description = description, tags = tags)
    }

}
