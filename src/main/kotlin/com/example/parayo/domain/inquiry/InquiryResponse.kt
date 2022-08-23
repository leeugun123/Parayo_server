package com.example.parayo.domain.inquiry

data class InquiryResponse (
    val id : Long,
    val question : String,
    val answer : String?,
    val requestUserName : String,
    val requestUserId : Long,
    val productOwnerName : String,
    val productOwnerId : Long,
    val productJane : String,
    val productId : Long
    )

fun Inquiry.toInquiryResponse() = id?.let{

    InquiryResponse(
        it,
        question,
        answer,
        requestUser?.name ?: "이름 없음",
        requestUser?.id ?: -1,
        productOwner?.name ?: "이름 없음",
        productOwner?.id ?: -1,
        product?.name ?: "상품명없음",
                    productId

    )
}