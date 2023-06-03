package com.unilith.Back.V1.Vo.V1.Security

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountCredentialsVo(

    @JsonProperty("name")
    val userName:String? = null,

    val password:String? = null
)
