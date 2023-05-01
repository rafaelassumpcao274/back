package com.unilith.Back.V1.Vo.V1.Security

import java.util.*

data class TokenVo(
    val userName:String? = null,
    val authenticated: Boolean? = null,
    val created:Date? = null,
    val expiration: Date? = null,
    val accessToken :String? = null,
    val refreshToken:String? = null
)