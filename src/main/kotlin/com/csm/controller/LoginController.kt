package com.csm.controller

import com.csm.domain.dto.UserLoginRequestDTO
import com.csm.service.def.UserLoginService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono


/*
* Created by I503342 - 18/03/2019
*/
@RestController
@RequestMapping(path = [LoginController.PATH])
@Api(tags = ["Access, Refresh token endpoint used to get tokens."])
class LoginController(val userLoginService: UserLoginService) {

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Use credentials to get access token and refresh token.")
    fun login(@RequestBody userLoginRequestDTO: UserLoginRequestDTO) = userLoginService.loginUser(userLoginRequestDTO).toMono()

    companion object {
        const val PATH = "/login"
    }
}