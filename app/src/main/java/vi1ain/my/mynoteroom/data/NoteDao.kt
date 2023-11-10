package vi1ain.my.mynoteroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)
    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): Flow<List<NoteEntity>>
}