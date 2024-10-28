package com.pim.loginactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CadastrarCliente : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CadastroClienteScreen()
        }
    }
}

@Composable
fun CadastroClienteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2E7D32))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Cadastrar cliente", fontSize = 24.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(label = "Nome completo", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            CustomTextField(label = "Data de nascimento", modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))


        CustomTextField(label = "CPF/CNPJ")

        Spacer(modifier = Modifier.height(16.dp))


        SeccaoTitulo("contatos")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(label = "Celular", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            CustomTextField(label = "Residencial/ fone", modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(label = "E-mail")

        Spacer(modifier = Modifier.height(16.dp))


        SeccaoTitulo("endereço")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(label = "Rua", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            CustomTextField(label = "Bairro", modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(label = "Cep", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            CustomTextField(label = "Numero", modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(32.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color(0xFF2E7D32)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Cadastrar", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun CustomTextField(label: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = label, fontSize = 16.sp)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
    }
}

@Composable
fun SeccaoTitulo(titulo: String) {
    Text(
        text = titulo,
        color = Color.White,
        modifier = Modifier
            .background(Color(0xFF2E7D32))
            .padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CadastroClienteScreen()
}
