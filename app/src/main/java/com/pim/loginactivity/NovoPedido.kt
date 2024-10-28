package com.pim.loginactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class NovoPedido : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedidoScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoScreen() {
    var selectedCliente by remember { mutableStateOf("Selecione o cliente") }
    var selectedProduto by remember { mutableStateOf("Selecione o produto") }
    var selectedQuantidade by remember { mutableStateOf("Selecione a quantidade") }

    val clientes = listOf("Cliente 1", "Cliente 2", "Cliente 3")
    val produtos = listOf("Produto 1", "Produto 2", "Produto 3")
    val quantidades = listOf("1", "2", "3", "4", "5")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Fazer pedido",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        DropdownField("cliente", clientes, selectedCliente) { selectedCliente = it }
        Spacer(modifier = Modifier.height(16.dp))

        DropdownField("produto", produtos, selectedProduto) { selectedProduto = it }
        Spacer(modifier = Modifier.height(16.dp))

        DropdownField("quantidade", quantidades, selectedQuantidade) { selectedQuantidade = it }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Ação do botão */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Confirmar", color = Color.White, fontSize = 18.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(label: String, items: List<String>, selectedItem: String, onItemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            label = { Text(label) },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier.fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PedidoScreenPreview() {
    PedidoScreen()
}
