package com.example.parayo.domain.product.registration

import javax.print.DocFlavor.STRING

class ProductRegistrationRequest(
    val name : String,
    val description : String,
    val price : Int,
    val categoryId: Int,
    val imageIds : List<Long?>
) {
}