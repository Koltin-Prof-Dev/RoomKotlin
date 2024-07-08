package mx.edu.dsi_code.admintiempo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.dsi_code.admintiempo.R


@Composable
fun MainTitle(title:String){
    Text(text = title, color = Color.White, fontWeight = FontWeight.Bold)
}

@Composable
fun MainTextField(value:String, onValueChange: (String) -> Unit, label:String){

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label ={ Text(text = label)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 15.dp)
        )


}
@Composable
/*Nota de diseño: cuando tienes un composable que retorna un valor siempre debera llamarse la funcion
* en minuscula para evitar tener problemas con androidstudio
* */
fun formatTiempo(tiempo: Long):String
{
    /*formateamos la consulta del tiempo*/
    val segundos = (tiempo / 1000)% 60
    val minutos = (tiempo/ 1000 /60)%60
    val horas= tiempo/ 1000 /3600
    /*con este formateo obtenemos horas, minutos , segundos*/
    return String.format("%02d:%02d:%02d",horas,minutos,segundos)

}

@Composable
fun CronCard(titulo:String, crono:String, onClick:() -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
        .clickable { onClick() }   ){
        Column(modifier= Modifier.padding(15.dp)) {
           Text(text = titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row{ Icon(painter = painterResource(R.drawable.timer), contentDescription = "", tint = Color.Gray)
            Text(text = crono, fontSize = 20.sp)
            }
            Divider(modifier = Modifier.fillMaxWidth().height(1.dp), color= MaterialTheme.colorScheme.primary)
        }
    }
}