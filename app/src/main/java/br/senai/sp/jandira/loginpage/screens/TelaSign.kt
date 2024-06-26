package br.senai.sp.jandira.loginpage.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.loginpage.R
import br.senai.sp.jandira.loginpage.ui.theme.LoginPageTheme

@Composable
fun TelaSign(controleNavegacao: NavHostController) {

    var userState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }
    var checkState = remember {
        mutableStateOf(false)
    }
    LoginPageTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(150.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(color = 0xF1C107F5)),
                    shape = RoundedCornerShape(topStart = 0.dp, bottomStart = 28.dp)
                ) {

                }
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.text_signup),
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xF1C107F5)
                    )
                    Text(text = stringResource(id = R.string.text_account),color = Color(0xAA000000))
                }

            }
            Card (
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(height = 110.dp, width = 100.dp)
                    .padding(top = 12.dp), shape = CircleShape,
                border = BorderStroke(2.dp, Color(0xF1C107F5))
            ){

                Image(
                    modifier = Modifier
                        .size(height = 100.dp, width = 100.dp)
                        .offset(y = 6.dp),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = ""
                )
            }

            Image(
                modifier = Modifier
                    .offset(x = 220.dp, y = -25.dp)
                    .size(height = 30.dp, width = 30.dp),
                painter = painterResource(id = R.drawable.cam),
                contentDescription = "")
            Column (
                modifier = Modifier
                    .padding(bottom = 1.dp),

                ){
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    shape = RoundedCornerShape(12.dp),
                    value = userState.value,
                    onValueChange = {
                        userState.value = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "nome",
                            tint = Color(0xF1C107F5),
                            modifier = Modifier
                                .size(32.dp)
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.name))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xF1C107F5),
                        focusedBorderColor = Color(0xF1C107F5)
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    value = phoneState.value,
                    onValueChange = {
                        phoneState.value = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "phone",
                            tint = Color(0xF1C107F5),
                            modifier = Modifier
                                .size(32.dp)
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.phone))
                    },

                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xF1C107F5),
                        focusedBorderColor = Color(0xF1C107F5)
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp,),
                    shape = RoundedCornerShape(12.dp),
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "email",
                            tint = Color(0xF1C107F5),
                            modifier = Modifier
                                .size(32.dp)
                        )
                    },
                    label = {
                        Text(text = "E-mail")
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xF1C107F5),
                        focusedBorderColor = Color(0xF1C107F5)
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "password",
                            tint = Color(0xF1C107F5),
                            modifier = Modifier
                                .size(32.dp)
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xF1C107F5),
                        focusedBorderColor = Color(0xF1C107F5)
                    )
                )
                Row (
                    modifier = Modifier
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Checkbox(checked = checkState.value, onCheckedChange = {
                        checkState.value = it
                    },
                        colors = CheckboxDefaults.colors(checkedColor = Color(0xF1C107F5), uncheckedColor = Color(0xF1C107F5))

                    )
                    Text(text = stringResource(id = R.string.idade))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.End
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp),
                    horizontalAlignment = Alignment.End
                ) {

                    Button(
                        onClick = {controleNavegacao.navigate("home")},
                        modifier = Modifier
                            .height(50.dp)
                            .width(350.dp)
                            .padding(2.dp),
                        colors = ButtonDefaults
                            .buttonColors(containerColor = Color(0xF1C107F5)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = stringResource(id = R.string.createaccount))
                    }
                    Row (
                    ){
                        Text(text = stringResource(id = R.string.mensagem))
                        Text(text = stringResource(id = R.string.signin), color = Color(0xF1C107F5),
                            modifier = Modifier.clickable { controleNavegacao.navigate("login") })
                    }
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {

                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(150.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(color = 0xF1C107F5)),
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 28.dp)
                ) {}

            }


        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaSignPreview() {
    TelaSign(controleNavegacao = rememberNavController())
}
