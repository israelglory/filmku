package com.kxsplash.filmku

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kxsplash.filmku.ui.theme.FilmkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmkuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {

    Scaffold(
        topBar = {
            MyAppBar()
        }
    ) {
        MyBody()
    }
}

@Composable
fun NowShowingCard(
    painter: Painter,
    contentDescription: String,
    title: String,
){

    Box (
        modifier = Modifier.padding(end = 16.dp)
    ){
        Column {
            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = 10.dp,
                modifier = Modifier.height(212.dp)
            ) {
                Image(painter = painter, contentDescription = contentDescription)
            }
            Column (
                modifier = Modifier.padding(top = 12.dp)
            ){
                Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun PopularCard(painter: Painter,
                contentDescription: String,
                title: String,) {
    val star = painterResource(id = R.drawable.star)
    Row(
        modifier = Modifier.padding(start = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = 10.dp,
            modifier = Modifier
                .height(120.dp)
                .padding(end = 10.dp)
        ) {
            Image(painter = painter, contentDescription = contentDescription)
        }
        Column {
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = star, contentDescription = "star", modifier = Modifier
                    .padding(end = 5.dp)
                    .size(18.dp))
                Text(text = "6.4/10 IMDb", color = Color(0xFF9C9C9C), fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row{
                MovieType("HORROR")
                Spacer(modifier = Modifier.size(8.dp))
                MovieType("MYSTERY")
                Spacer(modifier = Modifier.size(8.dp))
                MovieType("THRILLER")

            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "1h 47m")
        }
    }
}

@Composable
fun MyAppBar() {
    val notificationIcon = painterResource(id = R.drawable.notif)
    val menuIcon = painterResource(id = R.drawable.menu)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            //.background(Color.White)
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 10.dp, end = 10.dp)

    ) {
        Image(
            painter = menuIcon,
            contentDescription = "Menu",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
        Text(text = "FilmKu", fontSize = 20.sp,  fontWeight = FontWeight.Bold)
        Image(
            painter = notificationIcon,
            contentDescription = "Notification",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
    }
}

@Composable
fun MyBody() {
    //val film1 = painterResource(id = R.drawable.film1)
    //val scrollState = rememberScrollState()
    Column {
        Text(text = "Now Showing", fontSize = 16.sp,  fontWeight = FontWeight.Bold, modifier = Modifier
            .padding(start = 10.dp, end = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalScrollScreen()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Popular", fontSize = 16.sp,  fontWeight = FontWeight.Bold, modifier = Modifier
            .padding(start = 10.dp, end = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))

        VerticalScrollScreen()
    }
}

@Composable
fun MovieType(type: String) {
    Card(
        shape = RoundedCornerShape(50.dp),
        elevation = 0.dp,
        backgroundColor = Color(0xFFDBE3FF),

        ) {
        Text(text = type, color = Color(0xFF88A4E8), modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp), fontSize = 8.sp)

    }
}

@Composable
fun HorizontalScrollScreen() {
    val film1 = painterResource(id = R.drawable.film1)
    val movies = listOf<MovieClass>(
        MovieClass(
            painter = painterResource(id = R.drawable.film1),
            contentDescription = "",
            movieTitle = "Venom Let There Be Carnage",
        ),
        MovieClass(
            painter = painterResource(id = R.drawable.film1),
            contentDescription = "",
            movieTitle = "Venom Let There Be Carnage",
        ),
        MovieClass(
            painter = painterResource(id = R.drawable.film1),
            contentDescription = "",
            movieTitle = "Venom Let There Be Carnage",
        ),
        MovieClass(
            painter = painterResource(id = R.drawable.film1),
            contentDescription = "",
            movieTitle = "Venom Let There Be Carnage",
        ),
        MovieClass(
            painter = painterResource(id = R.drawable.film1),
            contentDescription = "",
            movieTitle = "Venom Let There Be Carnage",
        ),
        MovieClass(
            painter = painterResource(id = R.drawable.film1),
            contentDescription = "",
            movieTitle = "Venom Let There Be Carnage",
        ),
    )
    // a wrapper to fill the entire screen
    Box {
        // BowWithConstraints will provide the maxWidth used below
        BoxWithConstraints(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)) {
            // LazyRow to display your items horizontally
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                items(10) {

                    NowShowingCard(painter = film1, contentDescription = "", title = "Spiderman: No Way Home")
                }
            }
        }
    }
}

@Composable
fun VerticalScrollScreen() {
    val film1 = painterResource(id = R.drawable.film1)
    // a wrapper to fill the entire screen
    Box() {
        // BowWithConstraints will provide the maxWidth used below
        BoxWithConstraints(modifier = Modifier
            .fillMaxHeight()
        ) {
            // LazyRow to display your items horizontally
            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                state = rememberLazyListState()
            ) {
                items(10) {
                    PopularCard(
                        painter = film1, contentDescription = "", title = "Venom Let There Be Carnage"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}


//@Preview(showBackground = true, widthDp = 270, heightDp = 560)
@Composable
fun MovieDescriptionPreview() {

}

@Preview(showBackground = true, widthDp = 300, heightDp = 660)
@Composable
fun MyAppPreview() {
    MyApp()
}

class MovieClass(movieTitle: String, painter:Painter, contentDescription: String){

}