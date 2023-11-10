package vi1ain.my.mynoteroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDB : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object{
        fun createDataBase(context: Context):NoteDB{
            return Room.databaseBuilder(
                context,
                NoteDB::class.java, "note.db"
            ).build()
        }
    }
}