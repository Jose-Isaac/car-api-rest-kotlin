package com.study.car.domain

import com.study.car.entities.TravelRequest
import com.study.car.entities.TravelRequestStatus
import com.study.car.interfaces.outcoming.GMapsService
import org.springframework.stereotype.Component

@Component
class TravelService(
    val travelRequestRepository: TravelRequestRepository,
    val gMapsService: GMapsService
) {
    val MAX_TRAVEL_TIME = 3000

    fun saveTravelService(travelRequest: TravelRequest) = travelRequestRepository.save(travelRequest)

    fun listNearbyTravelRequests(currentAddress: String): List<TravelRequest> {
        val requests = travelRequestRepository.findByStatus(TravelRequestStatus.CREATED)

        return requests.filter {
            travelRequest ->
            gMapsService
                .getDistanceBetweenAddresses(currentAddress, travelRequest.origin) < MAX_TRAVEL_TIME
        }
    }
}
