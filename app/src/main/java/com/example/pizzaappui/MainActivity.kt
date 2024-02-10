package com.example.pizzaappui

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaappui.ui.theme.BackgroundColor
import com.example.pizzaappui.ui.theme.DarkBlackColor
import com.example.pizzaappui.ui.theme.LightGrayColor
import com.example.pizzaappui.ui.theme.Pizza
import com.example.pizzaappui.ui.theme.PizzaAppUiTheme
import com.example.pizzaappui.ui.theme.RedColor
import com.example.pizzaappui.ui.theme.YellowColor
import com.example.pizzaappui.ui.theme.pizzaList

import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
homescreen()
                }
            }
        }
    }
}





    

@Composable
fun homescreen() {
    var list = listOf<String>("Starter", "Asian", "Placha & Roast & Grill", "Classic", "Indian", "Italian")
    var selectedChip by remember { mutableStateOf("Starter") }
    val scrollState = rememberScrollState()
    val systemUiController= rememberSystemUiController()
    val headerColor= Color(0xFFF5815C)
    systemUiController.setStatusBarColor(headerColor)



    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            header()
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .horizontalScroll(scrollState)
                        .background(color = Color.White)
                            ) {
                    list.forEach { chipTitle ->
                        customchip(
                            title = chipTitle,
                            selected = chipTitle == selectedChip
                        ) {
                            selectedChip = chipTitle
                        }
                    }
                }
            }
            LazyVerticalGrid(columns = GridCells.Fixed(2) ){
                items(pizzaList){
                    pizlay(pizza = it)
                }
            }
        }

    }

}

@Composable
fun customchip(
    title: String,
    selected: Boolean,
    onValueChange: (String) -> Unit
) {
    TextButton(
        onClick = { onValueChange(title) },
        shape = RoundedCornerShape(30.dp),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color(0XFFFFAA2C) else Color.White,
            contentColor = if (selected) Color.White else DarkBlackColor
        ),
        modifier = Modifier.padding(start = 8.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600
            )
        )
    }
}
@Composable
fun pizlay(pizza: Pizza){
    Card (
        modifier = Modifier
            .width(175.dp)
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .background(color = BackgroundColor, shape = RoundedCornerShape(5.dp)),


    ){


    Box(modifier = Modifier
        .fillMaxWidth()
        , contentAlignment = Alignment.Center){
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 5.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(id = pizza.image), contentDescription = "")
            spaceh()
            Text(
                text = pizza.price,
               textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300,
                    color = RedColor

                ))
            spaceh()
            Text(
                text = pizza.name,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = DarkBlackColor

                ))
            spaceh()
            Text(
                text = pizza.description,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300,
                    color = LightGrayColor

                ))
            spaceh()
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(91.dp),
               colors = ButtonDefaults.buttonColors(
                   containerColor = YellowColor,
                   contentColor = Color.White
               ),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    text = "Add",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.White

                    ))

            }




        }


    }}
}
@Composable
fun spaceh(){
    Spacer(modifier = Modifier.padding(vertical = 5.dp))
}






