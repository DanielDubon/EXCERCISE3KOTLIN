package com.example.excercise3kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.excercise3kotlin.ui.theme.EXCERCISE3KOTLINTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EXCERCISE3KOTLINTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val inputString = "abcdcaf"
                    val output = firstNonRepeatingCharacter(inputString)
                    Log.d("RESPUESTA",output.toString())

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

fun firstNonRepeatingCharacter(string: String): Int {
    val charFrequency = HashMap<Char, Int>()

    // Count the frequency of each character in the string
    for (char in string) {
        charFrequency[char] = charFrequency.getOrDefault(char, 0) + 1
    }

    // Find the index of the first non-repeating character
    for ((index, char) in string.withIndex()) {
        if (charFrequency[char] == 1) {
            return index
        }
    }

    // If no non-repeating character found, return -1
    return -1
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EXCERCISE3KOTLINTheme {
        Greeting("Android")
    }
}