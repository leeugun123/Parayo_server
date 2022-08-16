package com.example.parayo.domain.product

import com.example.parayo.domain.jpa.BaseEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@Entity(name = "product_image")
class ProductImage (var path: String, var productId: Long? = null) : BaseEntity() {
}