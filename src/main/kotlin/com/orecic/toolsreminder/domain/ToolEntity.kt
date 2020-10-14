package com.orecic.toolsreminder.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document("tools")
class ToolEntity(val id : String? = null, val title: String, val link: String, val description: String, val tags: List<String>) {

}