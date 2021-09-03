package com.study.car.entities

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Driver (
    @Id
    @GeneratedValue
    val id : Long? = null,
    val name : String,
    val birthDate : LocalDate
)

data class PatchDriver (
    val name : String?,
    val birthDate : LocalDate?
)