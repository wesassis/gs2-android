package rm552516rm98928.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("MENU", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate("imc") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cálculo de IMC")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("equipe") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Equipe")
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Volta para o login e limpa a pilha de navegação
                navController.popBackStack("login", inclusive = false)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar (Sair)")
        }
    }
}