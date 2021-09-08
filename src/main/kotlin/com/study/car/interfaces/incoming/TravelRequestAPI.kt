package com.study.car.interfaces.incoming

import com.study.car.domain.TravelService
import com.study.car.entities.TravelRequestInput
import com.study.car.entities.TravelRequestOutput
import com.study.car.interfaces.incoming.mapping.TravelRequestMapper
import org.springframework.hateoas.EntityModel
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
    val travelService: TravelService,
    val mapper: TravelRequestMapper
) {
    @PostMapping
    fun makeTravelRequest(
        @RequestBody travelRequestInput: TravelRequestInput ) : EntityModel<TravelRequestOutput>
    {
        val travelRequest = travelService.saveTravelService(mapper.map(travelRequestInput))

        val output = mapper.map(travelRequest)

        return mapper.buildOutputModel(travelRequest, output)
    }
}