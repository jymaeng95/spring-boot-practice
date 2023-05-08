package com.group.libraryapp.dto.book.request

import com.group.libraryapp.domain.book.BookType

data class BookRequest(
    val name: String,
    val type: BookType,
) {
    companion object {
        // Test Code에서 Dto를 위한 텍스처
        fun fixture(name: String = "책 이름", type: BookType = BookType.COMPUTER) = BookRequest(name, type)
    }
}
