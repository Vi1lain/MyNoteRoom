package vi1ain.my.mynoteroom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vi1ain.my.mynoteroom.note_screen.UiAddNote
import vi1ain.my.mynoteroom.note_screen.UiNoteList

object Routes{
    const val ADD_NOTE = "add_note"
    const val MAIN_SCREEN = "main_screen"
}

@Composable
fun NoteNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN){
        composable(Routes.MAIN_SCREEN){UiNoteList(navController=navController)}
        composable(Routes.ADD_NOTE){ UiAddNote(navController=navController)}
    }
}