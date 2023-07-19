package com.zayson.querydsl.entity

import jakarta.persistence.*
import jakarta.persistence.FetchType.*

@Entity
data class Member (
    @Id @GeneratedValue
    @Column(name = "member_id") var id: Long,

    var username: String,
    var age: Int,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    var team: Team?
){
    private fun changeTeam(team: Team) {
        this.team = team
        team.members.add(this)
    }
}