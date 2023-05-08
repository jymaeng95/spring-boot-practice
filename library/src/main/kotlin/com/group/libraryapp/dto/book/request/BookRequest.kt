package com.group.libraryapp.dto.book.request

data class BookRequest(
    val name: String,
    val type: String,
) {
    companion object {
        // Test Code에서 Dto를 위한 텍스처
        fun fixture(name: String = "책 이름", type: String = "컴퓨터") = BookRequest(name, type)
    }
}
