package vi1ain.my.mynoteroom

import android.app.Application
import vi1ain.my.mynoteroom.data.NoteDB

class App:Application() {
    val database by lazy { NoteDB.createDataBase(this) }
}