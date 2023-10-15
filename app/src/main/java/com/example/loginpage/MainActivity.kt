package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    shape: Shape = RoundedCornerShape(30.dp)
) {
    var login by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember { mutableStateOf(value = false) }
    val personIcon = painterResource(R.drawable.baseline_person_24)
    val lockIcon = painterResource(R.drawable.baseline_lock_24)
    val background = painterResource(R.drawable.backdround)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = background,
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_avatar),
                contentDescription = "avatar",
                modifier = Modifier.width(150.dp)
            )
            TextField(
                value = login,
                onValueChange = { login = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),

                label = {
                    Text(
                        text = "Username",
                        color = colorResource(id = R.color.blue)
                    )
                },
                shape = shape,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = colorResource(id = R.color.white_blue)
                ),
                leadingIcon = {
                    Icon(
                        painter = personIcon,
                        contentDescription = "user",
                        tint = colorResource(id = R.color.blue)
                    )
                },
                singleLine = true,
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),

                label = {
                    Text(
                        text = "Password",
                        color = colorResource(id = R.color.blue)
                    )
                },
                shape = shape,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = colorResource(id = R.color.white_blue)
                ),
                leadingIcon = {
                    Icon(
                        painter = lockIcon,
                        contentDescription = "password",
                        tint = colorResource(id = R.color.blue)
                    )
                },
                singleLine = true,
                visualTransformation = if (showPassword) {

                    VisualTransformation.None

                } else {

                    PasswordVisualTransformation()

                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    if (showPassword) {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = "hide_password",
                                tint = colorResource(id = R.color.blue)
                            )
                        }
                    } else {
                        IconButton(
                            onClick = { showPassword = true }) {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = "hide_password",
                                tint = colorResource(id = R.color.blue)
                            )
                        }
                    }
                }
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Row {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue)),
                    modifier = Modifier
                        .width(120.dp)
                ) {
                    Text(text = "Sign In")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue)),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text(text = "Sign Up")
                }
            }
            Text(
                text = "Forgot password?",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(top = 10.dp)
                ,
                color = colorResource(id = R.color.blue)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPageTheme {
        LoginPage()
    }
}