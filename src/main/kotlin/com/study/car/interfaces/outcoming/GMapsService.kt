package com.study.car.interfaces.outcoming

import com.jayway.jsonpath.JsonPath
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GMapsService(
    @Value("\${app.car.domain.googlemaps.apikey}")
    val appKey: String
) {
    val GMAPS_TEMPLATE: String =
        "https://maps.googleapis.com/maps/api/directions/json?origin={origin}&destination={destination}&key={key}"

    fun getDistanceBetweenAddresses(
        addressOne: String,
        addressTwo: String
    ): Int {
        val template = RestTemplate()

        val jsonResult = template.getForObject(GMAPS_TEMPLATE, String::class.java, addressOne, addressTwo, appKey)

        println("\n\n JSONRESULT $jsonResult \n\n")

        val jsonParse = JsonPath.parse(jsonResult)

        println("\n\n JSONPARSE $jsonParse \n\n")
        val rawResults = jsonParse.read("\$..regs[*].duration.value", Array<String>::class.java)

        println("\n\n RAWRESULTS $rawResults ± ${rawResults[0]} \n\n")
        return rawResults.map { it as Int }.minOrNull() ?: Int.MAX_VALUE
    }
}
