package com.csm.controller

import com.csm.service.def.RefreshTokenService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono


/*
* Created by I503342 - 20/03/2019
*/

@RequestMapping(path = [RefreshTokenController.PATH])
@RestController
@Api(tags = ["Refresh an access token here."])
class RefreshTokenController(
        private val refreshTokenService: RefreshTokenService
) {

    @PostMapping
    @ApiOperation(value = "Refresh an access token using a refresh token.")
    fun refreshToken(@RequestParam(name = "refreshToken") refreshToken: String) =
            refreshTokenService.refreshToken(refreshToken).toMono()

    companion object {
        const val PATH = "/refresh"
    }
}