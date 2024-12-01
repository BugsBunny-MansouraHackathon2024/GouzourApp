package com.bugsbunny.gouzour.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bugsbunny.gouzour.R
import com.bugsbunny.gouzour.presentation.ui.theme.GozGreen
import com.bugsbunny.gouzour.presentation.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(navController: NavController) {
    /* TO DO VIEW MODEL INTEGRATION */

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val errorMessage by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
//    val authState by viewModel.registerStateFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "إنشاء حساب",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = "email",
                onValueChange = {email = it},
                label = { Text("الاسم") },
                placeholder = { Text("اكتب اسمك") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("البريد الالكتروني") },
                placeholder = { Text("ادخل بريدك الالكتروني") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("كلمة المرور") },
                placeholder = { Text("اختر كلمة مرور") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "Password Icon")
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("رقم التليفون") },
                placeholder = { Text("+20********") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = false, onCheckedChange = {})
                Text(text = "تذكرني", modifier = Modifier.padding(start = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /* TODO: Add forget password action */ }) {
                    Text(text = "نسيت كلمة المرور؟", color = MaterialTheme.colorScheme.primary)
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* TODO: Add continue action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(GozGreen) // Green color
            ) {
                Text(text = "تابع", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "أو تسجيل بواسطة", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Card {
                    IconButton(onClick = { /* TODO: Facebook login action */ }) {
//                    Icon(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "Facebook")
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))
                Card {
                    IconButton(onClick = { /* TODO: Google login action */ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_google), contentDescription = "Google")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "لديك حساب بالفعل؟")
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(onClick = { /* TODO: Navigate to login screen */ }) {
                    Text(text = "تسجيل دخول", color = GozGreen)
                }
            }
        }
    }
}
