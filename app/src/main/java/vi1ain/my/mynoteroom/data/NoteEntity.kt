package vi1ain.my.mynoteroom.data

import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val title: String,
    val description: String,
    //val time:String,
    //val isCheck: Boolean,
)
