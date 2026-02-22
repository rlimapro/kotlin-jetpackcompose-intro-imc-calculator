package io.github.rlimapro.composetutorial.ui.calculadora

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculadoraIMC(
    modifier: Modifier = Modifier,
    viewModel: CalculadoraViewModel = viewModel()
) {
    // Coluna principal
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(22.dp)
    ) {

        // Coluna que constrói o resultado
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 60.dp)
        ) {
            Text(
                text = viewModel.resultadoIMC.imc,
                fontSize = 22.sp
            )
            HorizontalDivider(modifier = Modifier.fillMaxWidth(.6f))
            Text(
                text = viewModel.resultadoIMC.categoria,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Coluna que constrói o formulário
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // Campo para a altura
                OutlinedTextField(
                    value = viewModel.altura,
                    onValueChange = { viewModel.onAlturaChange(it) },
                    label = { Text("Altura (m)") },
                    modifier = Modifier.fillMaxWidth().weight(1f)
                )

                // Campo para o peso
                OutlinedTextField(
                    value = viewModel.peso,
                    onValueChange = { viewModel.onPesoChange(it) },
                    label = { Text("Peso (kg)") },
                    modifier = Modifier.fillMaxWidth().weight(1f)
                )
            }

            // Botão para chamar a função de calcular
            Button(
                onClick = { viewModel.calcular() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular IMC")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculadoraIMCPreview() {
    CalculadoraIMC(viewModel = viewModel())
}