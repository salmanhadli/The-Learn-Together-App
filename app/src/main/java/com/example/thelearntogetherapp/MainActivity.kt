package com.example.thelearntogetherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thelearntogetherapp.ui.theme.TheLearnTogetherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheLearnTogetherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePage(headerImage = R.drawable.bg_compose_background);
                }
            }
        }
    }
}

@Composable
fun HomePage(headerImage: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        HeaderImage(headerImage = headerImage, modifier)
        Body(modifier)
    }
}

@Composable
fun HeaderImage(headerImage: Int, modifier: Modifier) {
    val image = painterResource(id = headerImage);
    Image(painter = image, contentDescription = null)
}

@Composable
fun Body(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Title(modifier);
        Section(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            noHorizontalPadding = false,
            modifier
        );
        Section(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            noHorizontalPadding = true,
            modifier
        );
    }
}

@Composable
fun Title(modifier: Modifier) {
    Text(
        text = "Jetpack Compose tutorial",
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun Section(text: String, noHorizontalPadding: Boolean, modifier: Modifier) {
    var modifier1: Modifier? = null;
    if (noHorizontalPadding) {
        modifier1 = modifier.padding(16.dp)
    } else {
        modifier1 = modifier.padding(
            horizontal = 16.dp
        );
    }
    Text(
        text = text,
        textAlign = TextAlign.Justify,
        modifier = modifier1
    )
}


@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    TheLearnTogetherAppTheme {
        HomePage(headerImage = R.drawable.bg_compose_background);
    }
}