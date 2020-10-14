package com.orecic.toolsreminder

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create("mongodb://172.17.0.2:27017")
    }
}