package com.study.car.interfaces

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(
    path = ["/passengers"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class PassenferAPI {
}