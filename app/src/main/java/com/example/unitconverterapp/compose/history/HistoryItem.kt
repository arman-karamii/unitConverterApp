package com.example.unitconverterapp.compose.history

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterapp.ui.theme.HistoryYellow
import com.example.unitconverterapp.ui.theme.LightRed
import com.example.unitconverterapp.ui.theme.TiffanyBlue
import com.example.unitconverterapp.ui.theme.YellowGreen

@Composable
fun HistoryItem(
 messagePart1 : String,
 messagePart2 : String,
 onClose : () -> Unit,
 modifier: Modifier = Modifier
){
   Row (
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = HistoryYellow)
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
           ){
       Column {
           Text(text = messagePart1,
               color = YellowGreen,
               fontSize = 20.sp
           )
           Text(text = messagePart2,
                color = TiffanyBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
           )
       }
       OutlinedButton(
           onClick = { onClose() } ,
           modifier= Modifier.size(25.dp),

           shape = CircleShape,
           border= BorderStroke(1.dp, Color.Red),
           contentPadding = PaddingValues(0.dp),
           colors = ButtonDefaults.outlinedButtonColors(
               contentColor =  LightRed,
               backgroundColor = LightRed
           )
       ){
           Icon(
               Icons.Rounded.Close,
               contentDescription ="close" ,
               tint = Color.Red ,
           )
       }
       
       

   }

}