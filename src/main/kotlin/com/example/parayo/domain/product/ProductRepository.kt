package com.example.parayo.domain.product

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product,Long> {

    //1
    fun findByCategoryIdAndIdGreaterThanOrderByIdDesc(
        categoryId: Int, id : Long, pageable : Pageable
    ): List<Product>

    //2
    fun findByCategoryIdAndIdLessThanOrderByIdDesc(
        categoryId: Int,id : Long, pageable : Pageable
    ): List<Product>

    fun findByIdGreaterThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Product>

    fun findByIdLessThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Product>





}