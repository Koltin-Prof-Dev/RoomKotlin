package mx.edu.dsi_code.admintiempo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


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
        modifier = Modifier.fillMaxWidth()
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