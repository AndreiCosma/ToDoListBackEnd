package com.csm.domain.repo

import com.csm.domain.entity.Registration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

/*
* Created by I503342 - 19/03/2019
*/
interface RegistrationRepo : JpaRepository<Registration, Long> {

    fun findByUserId(userId: Long): Optional<Registration>

    fun findByRegistrationUUID(registrationUUID: String): Optional<Registration>

    @Query("select r from Registration r where r.active = false")
    fun findByActiveFalse(): MutableList<Registration>

}