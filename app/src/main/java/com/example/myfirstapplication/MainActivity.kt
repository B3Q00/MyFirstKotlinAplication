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


        val acc1 = SavingsAccount("S101", "George G.")
        val acc2 = VIPAccount("V202", "Mariam A.")


        acc1.deposit(1000.0)
        out.append("Savings: Deposited 1000.0\n")


        out.append("Attempting savings.withdraw(300)\n")
        acc1.withdraw(300.0)
        out.append("Attempting savings.withdraw(600)\n")
        acc1.withdraw(600.0)

        acc2.deposit(1000.0)
        out.append("VIP: Deposited 1000.0\n\n")

        out.append("\nTesting VIP withdrawal: vip.withdraw(50)... fee should apply\n")
        acc2.withdraw(50.0)



        val accounts: List<Account> = listOf(acc1,acc2)

        for (account in accounts){
            account.deposit(50.0)
            account.printInfo()
        }

        acc2.printInfo()
        acc1.printInfo()

        out.append("\nFinal account states:\n")
        out.append("Savings Account: ${acc1.accountNumber} | Owner: ${acc1.ownerName} | Balance: ${"%.2f".format(acc1.getBalance())}\n")
        out.append("VIP Account: ${acc2.accountNumber} | Owner: ${acc2.ownerName} | Balance: ${"%.2f".format(acc2.getBalance())}\n")


        tvOutput.text = out.toString()
    }
}