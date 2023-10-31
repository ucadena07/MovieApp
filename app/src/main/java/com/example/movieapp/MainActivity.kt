package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Movies")
                    }
                )
            },
        ) { innerPadding ->
            MainContent(innerPadding)
        }
    }
}

@Composable
fun MainContent(padding: PaddingValues = PaddingValues(0.dp)) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.padding(padding)
    ) {
        Movies()
    }
}

@Composable
fun Movies(movieList: List<String> = listOf("Avatar", "300", "Harry Potter", "Happy Feet","Life","Cross the line")) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn() {
            items(items = movieList) {
                MovieRow(it)
            }
        }
    }
}

@Composable
fun MovieRow(movie: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                shadowElevation = 4.dp
                ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "icon")
            }
            Text(text = movie)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MainContent()
    }
}