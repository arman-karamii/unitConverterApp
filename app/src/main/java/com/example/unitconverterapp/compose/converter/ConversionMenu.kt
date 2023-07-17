package com.example.unitconverterapp.compose.converter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.unitconverterapp.data.Conversion
import com.example.unitconverterapp.ui.theme.DarkYellow
import com.example.unitconverterapp.ui.theme.Yellow

@Composable
fun ConversionMenu(list: List<Conversion>,
                   modifier: Modifier = Modifier,
                   convert : (Conversion) -> Unit
){

     var displayingText by remember{ mutableStateOf("Select the conversion type")}
     var textFieldSize by remember{mutableStateOf(Size.Zero)} //To assign the dropdown the same width as TextField.
     var expanded by remember { mutableStateOf(false)}

     val icon = if(expanded)
         Icons.Filled.KeyboardArrowUp
         else
         Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            value = displayingText,
            onValueChange = { displayingText = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Gray),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { cordinates ->
                    textFieldSize = cordinates.size.toSize()
                }
            ,
            label = { Text(text = "Conversion type", color = Yellow) },
            trailingIcon = {
                Icon(
                    icon,
                    contentDescription = "icon",
                    modifier.clickable { expanded = !expanded },
                    tint = Color.Gray)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Yellow,
                unfocusedBorderColor = Yellow,
                cursorColor = Yellow
            ),

            readOnly = true

        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(color = DarkYellow)
        )
        {
            list.forEach { conversion ->
                DropdownMenuItem(onClick = {
                    displayingText = conversion.description
                    expanded = false
                    convert(conversion)
                }) {
                    Text(
                        text = conversion.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}