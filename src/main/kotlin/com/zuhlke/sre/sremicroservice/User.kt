package com.zuhlke.sre.sremicroservice

import org.springframework.data.annotation.Id

data class User(@Id val id: String, val name: String)