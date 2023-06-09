package com.unilith.Back.V1.Vo.V1.Security

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountCredentialsVO(
    val username: String? = null,
    val password: String? = null,
)
