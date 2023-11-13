package vi1ain.my.mynoteroom.note_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vi1ain.my.mynoteroom.NoteViewModel
import vi1ain.my.mynoteroom.R
import vi1ain.my.mynoteroom.navigation.Routes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UiNoteList(
    navController: NavHostController,
    noteViewModel: NoteViewModel
) {
    val noteList = noteViewModel.notesList.collectAsState(initial = emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = Routes.ADD_NOTE)
                }) {
                Icon(
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray), contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(noteList.value) { item ->

                UiCardItem(navController = navController,note = item,noteViewModel=noteViewModel,{
                    noteViewModel.checkNoteEntity = item
                    noteViewModel.titleState = item.title
                    noteViewModel.descriptionState = item.description
                },{
                    noteViewModel.deleteNote(item)
                }) }
        }
    }
}