package com.plase.plase.model.api.entry

import java.util.*

data class UserContract(
    var uId: String?,
    var name: String?,
    var email: String,
    var deviceModel: String?,
    var applicationVersion: String?,
    var insertDate: Date?
)