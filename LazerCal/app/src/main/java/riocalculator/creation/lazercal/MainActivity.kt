package riocalculator.creation.lazercal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvone.setOnClickListener { appendOnExpression("1", true) }
        tvtwo.setOnClickListener { appendOnExpression("2", true) }
        tvthree.setOnClickListener { appendOnExpression("3", true) }
        tvfour.setOnClickListener { appendOnExpression("4", true) }
        tvfive.setOnClickListener { appendOnExpression("5", true) }
        tvsix.setOnClickListener { appendOnExpression("6", true) }
        tvseven.setOnClickListener { appendOnExpression("7", true) }
        tveight.setOnClickListener { appendOnExpression("8", true) }
        tvnine.setOnClickListener { appendOnExpression("9", true) }
        tvzero.setOnClickListener { appendOnExpression("0", true) }
        tvdot.setOnClickListener { appendOnExpression(".", true) }

        tvadd.setOnClickListener { appendOnExpression("+", true) }
        tvsub.setOnClickListener { appendOnExpression("-", true) }
        tvmult.setOnClickListener { appendOnExpression("*", true) }
        tvdiv.setOnClickListener { appendOnExpression("/", true) }
        tvequals.setOnClickListener { appendOnExpression("=", true) }
        tvopen.setOnClickListener { appendOnExpression("(", true) }
        tvclose.setOnClickListener { appendOnExpression(")", true) }

        tvce.setOnClickListener {
            tvexpression.text = ""
            tvresult.text = ""
        }

        tvback.setOnClickListener {
            val string = tvexpression.text.toString()
            if (string.isNotEmpty()) {
                tvexpression.text = string.substring(0, string.length - 1)
            }
            tvresult.text = ""
        }

        tvequals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvexpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvresult.text=longResult.toString()
                else
                    tvresult.text=result.toString()

            }catch (e:Exception){
                Log.d("Exception","message :" + e.message)
            }
        }

    }

    fun appendOnExpression(string: String, canClear: Boolean) {
        if (canClear) {
            tvresult.text=""
            tvexpression.append(string)
        }
        else {
            tvexpression.append(tvresult.text)
            tvexpression.append(string)
            tvresult.text = ""
        }


        }
    }