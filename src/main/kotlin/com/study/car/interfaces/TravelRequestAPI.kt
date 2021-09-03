package com.study.car.interfaces

import com.study.car.entities.TravelRequest
import com.study.car.entities.TravelRequestRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(
    path = ["/travelRequests"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class TravelRequestAPI(
    val travelRequestRepository: TravelRequestRepository
) {
    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequest : TravelRequest) {}
}