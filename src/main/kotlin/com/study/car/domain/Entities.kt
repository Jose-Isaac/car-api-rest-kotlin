package com.study.car.entities

import java.time.LocalDate
import java.time.LocalDateTime
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
    val destination : String,
    val status: TravelRequestStatus = TravelRequestStatus.CREATED,
    val creationDate: LocalDateTime = LocalDateTime.now()
)

data class PatchDriver (
    val name : String?,
    val birthDate : LocalDate?
)

data class PatchPassenger (
    val name : String?
)

data class TravelRequestInput (
    val passengerId: Long,
    val origin: String,
    val destination: String
)

data class TravelRequestOutput(
    val id : Long,
    val origin : String,
    val destination : String,
    val status: TravelRequestStatus,
    val creationDate: LocalDateTime
)

enum class TravelRequestStatus {
    CREATED, ACCEPTED, REFUSED
}