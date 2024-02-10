package com.example.pizzaappui

import android.graphics.drawable.Icon
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaappui.ui.theme.OrangeColor



@Composable
fun header(){

    val text1= buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,

            )){append("JKM ")

        }
        append("Resto")
    }
    Box (
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = OrangeColor)){
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                iconbutton(icon = Icons.Default.Menu, tint = Color.White , modifier = Modifier.padding(top = 15.dp))
                Text(text = text1,Modifier.padding(top = 15.dp))
            }
            iconbutton(icon = Icons.Default.Search, tint = Color.White , modifier = Modifier.padding(top = 15.dp))

        }



    }


}




@Composable
fun iconbutton(icon: ImageVector,tint:Color,modifier: Modifier){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = icon, contentDescription = "", tint = tint, modifier = Modifier)


    }




}



