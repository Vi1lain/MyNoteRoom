package vi1ain.my.mynoteroom

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import vi1ain.my.mynoteroom.data.NoteDB
import vi1ain.my.mynoteroom.data.NoteEntity
import vi1ain.my.mynoteroom.utils.getCurrentTime

@Suppress("UNCHECKED_CAST")
class NoteViewModel(val noteDB: NoteDB) : ViewModel() {

    val notesList = noteDB.noteDao().getAllNotes()
    var titleState by mutableStateOf("")
    var descriptionState by mutableStateOf("")
    var checkNoteEntity: NoteEntity? = null

    fun insertNote() = viewModelScope.launch {
        val noteItem = checkNoteEntity?.copy(title = titleState) ?: NoteEntity(
            title = titleState,
            description = descriptionState,
            time = checkNoteEntity?.time?: getCurrentTime()
        )
        noteDB.noteDao().insertNote(noteItem)
        checkNoteEntity = null
        titleState = ""
        descriptionState = ""
    }

    fun deleteNote(item: NoteEntity) = viewModelScope.launch {
        noteDB.noteDao().deleteNote(item)
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val noteDB = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return NoteViewModel(noteDB) as T
            }
        }
    }
}