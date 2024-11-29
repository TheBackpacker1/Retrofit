import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Viewmodel.PockUiState
import com.example.myapplication.network.PockApi
import kotlinx.coroutines.launch
import java.io.IOException

class PokViewModel: ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var pockUiState: PockUiState by mutableStateOf(PockUiState.Loading)
        private set

    /**
     */
    init {
        getAllPock()
    }
    fun getAllPock() {
        viewModelScope.launch {

            pockUiState = try {
                val listResult = PockApi.retrofitService.getAllPokemon()
                PockUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                PockUiState.Error
            } catch (e: HttpException) {
                PockUiState.Error
            }
        }
    }
}