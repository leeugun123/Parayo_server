package com.example.parayo.domain.jpa

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate


@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id : Long? = null

    open var createdAt: Date? = null
    open var updatedAt: Date? = null

    @PrePersist
    fun prePersist(){
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate(){
        updatedAt = Date()
    }

}