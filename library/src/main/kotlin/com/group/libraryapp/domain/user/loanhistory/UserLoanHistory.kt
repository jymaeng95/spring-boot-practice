package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.User
import javax.persistence.*

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,
    val bookName: String,

    @Enumerated(EnumType.STRING)
    var status: UserLoanStatus = UserLoanStatus.LOANED,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
){
    companion object {
        fun fixture(user: User, bookName: String = "책 이름", status: UserLoanStatus = UserLoanStatus.LOANED, id: Long? = null) = UserLoanHistory(user, bookName, status, id)
    }

    fun doReturn() {
        this.status = UserLoanStatus.RETURNED
    }
}