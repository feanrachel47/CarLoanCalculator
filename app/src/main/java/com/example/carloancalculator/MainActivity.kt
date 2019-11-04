package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()


        }
    }

    fun calculateLoan(){

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error))
            return
        }

        //TODO  get all inputs from user and perform calculation
        val carPrice = editTextCarPrice.text.toString().toFloat()
        val downPayment = editTextDownPayment.text.toString().toInt()
        val loanPeriod = editTextLoanPeriod.text.toString().toFloat()
        val interestRate = editTextCarPrice.text.toString().toFloat()

        val loan = carPrice - downPayment
        val interest = loan * interestRate * loanPeriod
        val monthlyRepayment = (loan + interest) / loanPeriod / 12


        //TODO display outputs
        textViewLoan.setText(getString(R.string.loan) + "${loan}") //or textViewLoan.text= getString(R.string.loan) + "${loan}"
        textViewInterest.setText(getString(R.string.interest) + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")
    }


    fun resetInput(view: View) {
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextCarPrice.setText("")

    }
}
