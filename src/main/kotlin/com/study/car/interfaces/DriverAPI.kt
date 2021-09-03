package com.study.car.interfaces

import com.study.car.entities.Driver
import com.study.car.entities.DriverRepository
import com.study.car.entities.PatchDriver
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping(
    path = ["/drivers"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class DriverAPI(val driverRepository: DriverRepository) {

    @GetMapping
    fun listDrivers() : List<Driver> = driverRepository.findAll()

    @GetMapping("/{id}")
    fun findDriver(@PathVariable("id") id : Long) = driverRepository
        .findById(id).orElseThrow {ResponseStatusException(HttpStatus.NOT_FOUND)}

    @PostMapping
    fun createDriver(@RequestBody driver : Driver) = driverRepository.save(driver)

    @PutMapping("/{id}")
    fun fullUpdateDriver(@PathVariable("id") id : Long, @RequestBody driver: Driver) : Driver {
        val foundDriver = findDriver(id)

        val copyDriver = foundDriver.copy(
            birthDate = driver.birthDate,
            name = driver.name
        )

        return driverRepository.save(copyDriver)
    }

    @PatchMapping("/{id}")
    fun incrementalUpdateDriver(@PathVariable("id") id : Long, @RequestBody driver : PatchDriver) : Driver {
        val foundDriver = findDriver(id)

        val copyDriver = foundDriver.copy(
            birthDate = driver.birthDate ?: foundDriver.birthDate,
            name = driver.name ?: foundDriver.name
        )

        return driverRepository.save(copyDriver)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id : Long) = driverRepository.delete(findDriver(id))
}