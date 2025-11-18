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
fun TeamScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Equipe", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(32.dp))
            Text("Integrantes:", style = androidx.compose.material3.MaterialTheme.typography.titleMedium)

            Text("Wesley Assis Oliveira - RM 552516")
            Text("Guilherme Silva Cavalcanti - RM 98928")
        }

        Button(
            onClick = { navController.popBackStack() }, // Volta para a tela anterior (Menu)
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}