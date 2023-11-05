import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.courseweb_student.database.entity.User
import com.example.courseweb_student.database.repository.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    fun insert(user : User) = GlobalScope.launch {
        repository.insert(user)
    }

    fun delete(user : User) = GlobalScope.launch {
        repository.delete(user)
    }

    fun allUsers(): LiveData<List<User>> = repository.allUsers()

    fun getUserByName(userName: String): LiveData<User?> {
        return repository.getUserByName(userName)
    }
}

