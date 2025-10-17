package com.example.myfirstapplication

class VIPAccount(accountNumber: String, ownerName: String, val transactionFee: Double = 2.0) : Account(accountNumber, ownerName) {

    override fun withdraw(amount: Double) {
        if (amount <= 0) {
            println("Withdrawal failed: amount must be > 0")
            return
        }

        val totalAmount = amount + transactionFee

        super.withdraw(totalAmount)
    }
}