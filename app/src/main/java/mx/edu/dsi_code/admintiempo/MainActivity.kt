package mx.edu.dsi_code.admintiempo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import mx.edu.dsi_code.admintiempo.navigation.NavManager
import mx.edu.dsi_code.admintiempo.ui.theme.AdminTiempoTheme
import mx.edu.dsi_code.admintiempo.viewModels.CronometroViewModel

@AndroidEntryPoint   /*androidentrypoint se utiliza para especificar que  se gtrabaja con hilt y un origen de datos bd*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cronometroVM: CronometroViewModel by viewModels()

        setContent {
            AdminTiempoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(cronometroVM)
                }
            }
        }
    }
}



