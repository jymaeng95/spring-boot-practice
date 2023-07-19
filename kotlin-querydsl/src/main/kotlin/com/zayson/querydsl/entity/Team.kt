package com.zayson.querydsl.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Team (
    @Id @GeneratedValue
    @Column(name = "team_id") var id: Long,

    var name: String,

    @OneToMany(mappedBy = "team")
    var members: MutableList<Member> = mutableListOf()
){

}