package rm552516rm98928.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun IMCScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculadora de IMC", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Seu nome") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Seu Peso (ex: 80.5)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Sua altura (ex: 1.75)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val pesoFloat = peso.toFloatOrNull()
                val alturaFloat = altura.toFloatOrNull()

                if (pesoFloat != null && alturaFloat != null && alturaFloat > 0) {
                    val imc = pesoFloat / (alturaFloat * alturaFloat)
                    resultado = "Olá $nome, seu IMC é: ${"%.2f".format(imc)}"
                } else {
                    resultado = "Por favor, insira valores válidos."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = resultado,
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1f)) // Empurra o botão "Voltar" para baixo

        Button(
            onClick = { navController.popBackStack() }, // Apenas volta para a tela anterior (Menu)
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}