package com.example.volunteerapp.ui.theme.screens.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.R
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class Event(
    val title: String,
    val date: String,
    val time: String,
    val location: String,
    val id: String = ""
)
@Composable
fun ListScreen(navController: NavController){
    var events by remember { mutableStateOf(
        listOf(
            Event("Tree Planting Initiative", "2/6/2024", "", "Karura Forest"),
            Event("Blood Donation Drive", "14/6/2024", "", "Uhuru Park")
        )

    ) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(events) { event ->
            CardComponent(
                event = event,
                image = R.drawable.tree,
                onDeleteClick = {
                    events = events.filter { it != event }
                }
            )
        }
    }
}

@Composable
fun CardComponent(event: Event, image: Int, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.h6.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Column(
                    modifier = Modifier.padding(bottom = 4.dp)
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Date Icon",
                            tint = Color.DarkGray
                        )
                        Text(
                            text = event.date,
                            style = MaterialTheme.typography.body2.copy(
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location Icon",
                            tint = Color.DarkGray
                        )
                        Text(
                            text = event.location,
                            style = MaterialTheme.typography.body2.copy(
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        onClick = onDeleteClick,
                        modifier = Modifier.padding(top = 8.dp),
                    ) {
                        Text(
                            text = "Withdraw",
                            color = Color.White,
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun ListScreenPreview(){
    ListScreen(rememberNavController())

}