package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOutput = findViewById(R.id.tvOutput)

        val out = StringBuilder()


        val savings = SavingsAccount("S101", "George G.")
        val vip = VIPAccount("V202", "Mariam A.")


        savings.deposit(1000.0)
        out.append("Savings: Deposited 1000.0\n")
        vip.deposit(1000.0)
        out.append("VIP: Deposited 1000.0\n\n")


        out.append("Attempting savings.withdraw(600.0)\n")
        savings.withdraw(600.0)
        out.append("Attempting savings.withdraw(400.0)\n")
        savings.withdraw(400.0)

        out.append("\nTesting VIP withdrawal: vip.withdraw(200.0)... fee should apply\n")
        vip.withdraw(200.0)

        out.append("\nFinal account states:\n")
        out.append("Savings Account: ${savings.accountNumber} | Owner: ${savings.ownerName} | Balance: ${"%.2f".format(savings.getBalance())}\n")
        out.append("VIP Account: ${vip.accountNumber} | Owner: ${vip.ownerName} | Balance: ${"%.2f".format(vip.getBalance())}\n")

        savings.printInfo()
        vip.printInfo()


        tvOutput.text = out.toString()
    }
}