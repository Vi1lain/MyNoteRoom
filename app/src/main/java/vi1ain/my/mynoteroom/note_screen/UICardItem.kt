package vi1ain.my.mynoteroom.note_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.mynoteroom.NoteViewModel
import vi1ain.my.mynoteroom.data.NoteEntity
import vi1ain.my.mynoteroom.navigation.Routes


@Composable
fun UiCardItem(
    navController: NavHostController,
    note: NoteEntity,
    noteViewModel: NoteViewModel,
    onClick: (NoteEntity) -> Unit,
    onClickDelete: (NoteEntity) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 3.dp, top = 3.dp, end = 3.dp
            )
            .clickable {
                onClick(note)
                navController.navigate(route = Routes.ADD_NOTE)

            }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                        .weight(1f),
                    text = note.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = note.time,
                    modifier = Modifier.padding(top = 10.dp, end = 10.dp),
                    color = Color.Blue,
                    fontSize = 12.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp, start = 10.dp, bottom = 7.dp)
                        .weight(1f),
                    text = note.description,
                    fontSize = 16.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                    //fontWeight = FontWeight.Bold
                )
Checkbox(checked = note.isCheck, onCheckedChange = {
    noteViewModel.OnCheckedNote(note.copy(isCheck = it))
})
                IconButton(onClick = {
                    onClickDelete(note)
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}