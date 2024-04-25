package br.senai.sp.jandira.loginpage.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.loginpage.repositorio.CategoriaRepositorio
import br.senai.sp.jandira.loginpage.repositorio.ViagemRepositorio
import br.senai.sp.jandira.loginpage.utilitarios.encurtadorDeDatas


@Composable
fun TelaHome(controleNavegacao: NavHostController) {

    var textState = remember {
        mutableStateOf("")
    }
    val  viagens = ViagemRepositorio().listarTodasAsViagens()

    val icons = CategoriaRepositorio().listarTodasAsCaregorias()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F4F4))
    ) {
        Surface (modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)){
            Image(
                painter = painterResource(id = br.senai.sp.jandira.loginpage.R.drawable.paris),
                contentDescription = "Paisagem",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row (
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Column (
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Surface (
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp),
                            shape = CircleShape
                        ){
                            Image(
                                painter = painterResource(id = br.senai.sp.jandira.loginpage.R.drawable.perfil ),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            text = "Susanna Hoffs",
                            color =  Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row (){
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = "Botão de pesquisa",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Text(
                            text = "You're in Paris",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                    Text(
                        text = "My Trips",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }



    }
    Column (
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 220.dp)
    ){
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Categories",
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow() {

            items(icons) {
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .height(100.dp)
                        .padding(end = 12.dp),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color(0xFFCF06F0)
                        ),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = it.icone!!,
                            contentDescription = "Montanha",
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .size(32.dp)
                        )
                        Text(
                            text = it.nome,
                            color = Color.White,
                            fontSize = 20.sp
                        )

                    }

                }

            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = textState.value,
            onValueChange = {textState.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Search your destiny",
                    color = Color.Gray
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Botão de pesquisa",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Past Trips",
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(){
            items(viagens) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(240.dp)
                        .padding(bottom = 12.dp),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.White
                        ),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Surface (
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                    ){
                        Image(
                            painter = painterResource(id = br.senai.sp.jandira.loginpage.R.drawable.london) ,
                            contentDescription = "Paisagem",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column (
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    ){
                        Text(
                            text = "${it.destino}, ${it.dataChegada.year}",
                            color = Color(0xFFCF06F0),
                            fontWeight = FontWeight(480),
                            fontSize = 20.sp
                        )
                        Text(
                            text = it.descricao,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                        )
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = encurtadorDeDatas(it.dataChegada, it.dataPartida),
                                color = Color(0xFFCF06F0),
                                fontWeight = FontWeight(480)
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaHomePreview() {
    TelaHome(controleNavegacao = rememberNavController())

}