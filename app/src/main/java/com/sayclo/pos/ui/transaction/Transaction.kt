package com.sayclo.pos.ui.transaction

import java.math.BigDecimal

data class Transaction(
    val id: Int,
    val cashier: String,
    val date: String,
    val amount: BigDecimal
)