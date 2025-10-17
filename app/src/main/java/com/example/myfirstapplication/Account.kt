package com.example.myfirstapplication

open class Account(val accountNumber: String, val ownerName: String) {
    private var balance: Double = 0.0

    fun getBalance(): Double = balance

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposit successful: $$amount. New balance: ${"%.2f".format(balance)}")
        } else {
            println("Deposit failed: amount must be > 0")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            balance -= amount
            println("Withdrawal successful: $$amount. New balance: ${"%.2f".format(balance)}")
        } else {
            println("Withdrawal failed: Insufficient funds or invalid amount")
        }
    }

    fun printInfo() {
        println("Account: $accountNumber | Owner: $ownerName | Balance: ${"%.2f".format(balance)}")
    }
}