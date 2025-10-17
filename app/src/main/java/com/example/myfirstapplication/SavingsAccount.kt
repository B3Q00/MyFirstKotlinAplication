package com.example.myfirstapplication

class SavingsAccount(accountNumber: String, ownerName: String) : Account(accountNumber, ownerName) {

    override fun withdraw(amount: Double) {
        if (amount > 500) {
            println("Withdrawal failed: exceeds per-transaction limit of $500")
            return
        }
        super.withdraw(amount)
    }
}