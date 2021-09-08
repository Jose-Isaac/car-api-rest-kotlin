package com.study.car.domain

import com.study.car.entities.TravelRequest
import com.study.car.entities.TravelRequestRepository
import org.springframework.stereotype.Component

@Component
class TravelService(
    val travelRequestRepository: TravelRequestRepository
) {
    fun saveTravelService(travelRequest: TravelRequest) = travelRequestRepository.save(travelRequest)
}