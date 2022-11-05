package com.example.assignment_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment_4.ui.theme.Assignment_4Theme
import com.example.assignment_4.viewmodel.DriversViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = DriversViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoView(vm = vm)
                }
            }
        }
    }
}


@Composable
fun TodoView(vm: DriversViewModel) {

    LaunchedEffect(Unit, block = {
        vm.getDriversStanding()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("Driver Standings")
                    }
                })
        },
        content = {
            if (vm.errorMessage.isEmpty()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        items(vm.driversStandingList) { drivers ->
                            Column {
                                driverStandingsItem(
                                    familyName = drivers?.driver?.familyName!!,
                                    givenName = drivers.driver.givenName!!,
                                    team = drivers.constructors?.get(0)?.constructorId!!,
                                    points = drivers.points!!,
                                    position = drivers.position!!
                                )
                            }
                        }
                    }
                }
            } else {
                Text(vm.errorMessage)
            }
        }
    )
}

@Composable
fun driverStandingsItem(
    familyName: String,
    givenName: String,
    team: String,
    points: String,
    position: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 16.dp, 0.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(end = 3.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    text = position.toString()
                )
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                        .padding(5.dp),
                    color = Color.Black
                )
                Column(modifier = Modifier.padding(start = 5.dp)) {
                    Text(
                        text = familyName
                    )
                    Text(text = givenName)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = team
                    )
                    Text(text = "$points PTS")
                }
            }

        }
    }
    Divider()
}

@Composable
fun driverList(familyName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 16.dp, 0.dp)
        ) {
            Text(
                text = familyName
            )
        }
    }
    Divider()
}

@Preview
@Composable
fun driverStandingsItemPreview() {
    Assignment_4Theme {
        // A surface container using the 'background' color from the theme
        driverStandingsItem(
            familyName = "hamilton",
            givenName = "Lewis",
            team = "Mderceds",
            points = "44",
            position = "6",
        )
    }
}