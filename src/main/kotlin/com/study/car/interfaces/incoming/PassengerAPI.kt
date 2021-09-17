package com.study.car.interfaces.incoming

import com.study.car.entities.Passenger
import com.study.car.domain.PassengerRepository
import com.study.car.entities.PatchPassenger
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping(
    path = ["/passengers"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class PassengerAPI(val passengerRepository: PassengerRepository) {

    @GetMapping
    fun listPassengers(): List<Passenger> = passengerRepository.findAll()

    @GetMapping("/{id}")
    fun findPassenger(@PathVariable("id") id : Long) : Passenger = passengerRepository
        .findById(id).orElseThrow() { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun createPassenger(@RequestBody pessenger : Passenger) = passengerRepository.save(pessenger)

    @PutMapping("/{id}")
    fun fullUpdatePassenger(@PathVariable("id") id : Long, @RequestBody pessenger : Passenger) : Passenger {
        val foundPassenger = findPassenger(id)

        val copyPassenger = foundPassenger.copy(
            name = pessenger.name
        )

        return passengerRepository.save(copyPassenger)
    }

    @PatchMapping("/{id}")
    fun incrementalUpdatePassenger(@PathVariable("id") id : Long, @RequestBody passenger: PatchPassenger) : Passenger {
        val foundPassenger = findPassenger(id)

        val copyPassenger = foundPassenger.copy(
            name = passenger.name ?: foundPassenger.name
        )

        return passengerRepository.save(copyPassenger)
    }

    @DeleteMapping("/{id}")
    fun deletePassenfer(@PathVariable("id") id : Long) = passengerRepository.delete(findPassenger(id))
}