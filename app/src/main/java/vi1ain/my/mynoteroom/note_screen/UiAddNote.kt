package vi1ain.my.mynoteroom.note_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.mynoteroom.NoteViewModel
import vi1ain.my.mynoteroom.R
import vi1ain.my.mynoteroom.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UiAddNote(
    navController: NavHostController,
    noteViewModel: NoteViewModel
) {

    Scaffold() {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.LightGray
                )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()

                    .padding(7.dp), shape = RoundedCornerShape(10.dp)

            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        TextField(
                            modifier = Modifier.weight(1f),
                            value = noteViewModel.titleState,
                            onValueChange = { text ->
                                noteViewModel.titleState = text
                            },
                            label = { Text(text = "Title", fontSize = 14.sp) },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Blue
                            ),
                            singleLine = true,
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        )
                        IconButton(
                            onClick = {
                                noteViewModel.insertNote()
                                navController.popBackStack(Routes.MAIN_SCREEN, inclusive = false)
                            }) {
                            Icon(
                                painter = painterResource(id = R.drawable.save_icon),
                                contentDescription = "Save", tint = Color.Blue

                            )

                        }
                    }
                    TextField(modifier = Modifier.fillMaxSize(),
                        value = "Description",
                        onValueChange = {

                        }, label = {
                            Text(
                                text = "Description",
                                fontSize = 14.sp
                            )
                        }, colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,

                            ), textStyle = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    )
                }
            }
        }
    }
}