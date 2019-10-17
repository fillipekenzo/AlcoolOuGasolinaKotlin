package com.example.exemplo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View) {
        val precoAlcool = inputPrecoAlcool.text.toString()
        val precoGasolina = inputPrecoGasolina.text.toString()
        val kmGasolina = inputKmPorLitroGasolina.text.toString();
        val kmAlcool = inputKmPorLitroAlcool.text.toString();
        calcularMelhorPreco(precoAlcool, precoGasolina,kmAlcool, kmGasolina)
    }

    fun btLimpar(view: View) {
        inputPrecoAlcool.text.clear();
        inputPrecoGasolina.text.clear();
        inputKmPorLitroGasolina.text.clear();
        inputKmPorLitroAlcool.text.clear();
        resultado.visibility = View.INVISIBLE;
    }
    fun calcularMelhorPreco(precoAcool: String, precoGasolina: String,alcool : String, gasolina: String) {
        val valorAlcool = precoAcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        val kmAlcool = alcool.toDouble()
        val kmGasolina = gasolina.toDouble()
        val custoBenGasolina = valorGasolina/kmGasolina;
        val custoBenAlcool = valorAlcool/kmAlcool;
        if (custoBenAlcool > custoBenGasolina) {
            resultado.setText("Melhor Utilizar Gasolina!")
        } else if(custoBenAlcool == custoBenGasolina) {
            resultado.setText("Os dois estão com o mesmo custo benefício!")
        }else{
            resultado.setText("Melhor Utilizar Álcool!")
        }
        resultado.visibility = View.VISIBLE;
    }
}
