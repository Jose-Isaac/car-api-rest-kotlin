package com.study.car.entities

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Driver (
    @Id
    @GeneratedValue
    val id : Long? = null,
    val name : String,
    val birthDate : LocalDate
)

@Entity
data class Passenger (
    @Id
    @GeneratedValue
    val id : Long? = null,
    val name: String
)

@Entity
data class TravelRequest(
    @Id
    @GeneratedValue
    val id : Long? = null,

    @ManyToOne
    val passenger : Passenger,
    val origin : String,
    val destination : String
)

data class PatchDriver (
    val name : String?,
    val birthDate : LocalDate?
)

data class PatchPassenger (
    val name : String?
)