package io.github.rlimapro.composetutorial.ui.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.github.rlimapro.composetutorial.data.model.ResultadoIMC
import kotlin.math.pow

class CalculadoraViewModel : ViewModel() {

    var altura by mutableStateOf("")
        private set
    var peso by mutableStateOf("")
        private set
    var resultadoIMC by mutableStateOf(ResultadoIMC(categoria = "Preencha os campos"))
        private set

    fun onAlturaChange(novaAltura: String) {
        altura = novaAltura
    }

    fun onPesoChange(novoPeso: String) {
        peso = novoPeso
    }

    fun calcular() {
        val alturaDouble = altura.toDoubleOrNull()
        val pesoDouble = peso.toDoubleOrNull()

        if (alturaDouble == null || pesoDouble == null || alturaDouble == 0.0) {
            resultadoIMC = ResultadoIMC(categoria = "Insira valores numéricos válidos!")
            return
        }

        val resultado = pesoDouble / alturaDouble.pow(2)
        val imcFormatado = "%.2f".format(resultado)

        val categoria = when {
            resultado < 17.0 -> "Muito abaixo do peso"
            resultado < 18.5 -> "Abaixo do peso"
            resultado < 25.0 -> "Peso normal"
            resultado < 30.0 -> "Acima do peso"
            resultado < 35.0 -> "Obesidade I"
            resultado < 40.0 -> "Obesidade II (severa)"
            else -> "Obesidade III (mórbida)"
        }

        resultadoIMC = ResultadoIMC(imc = imcFormatado, categoria = categoria)
    }
}