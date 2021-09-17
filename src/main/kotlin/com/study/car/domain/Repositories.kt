package com.study.car.domain

import com.study.car.entities.Driver
import com.study.car.entities.Passenger
import com.study.car.entities.TravelRequest
import com.study.car.entities.TravelRequestStatus
import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository : JpaRepository<Driver, Long>

interface PassengerRepository : JpaRepository<Passenger, Long>

interface TravelRequestRepository : JpaRepository<TravelRequest, Long> {

    fun findByStatus(status: TravelRequestStatus): List<TravelRequest>
}
