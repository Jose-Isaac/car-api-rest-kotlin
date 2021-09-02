package com.study.car.entities

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Driver (
    @Id
    val id : Long? = null,
    val name : String,
    val birthDate : LocalDate
)