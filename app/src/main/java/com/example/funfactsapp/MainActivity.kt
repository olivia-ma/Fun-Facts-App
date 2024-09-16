package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactsapp.ui.theme.FunFactsAppTheme
import kotlin.random.Random
import kotlin.text.Typography.quote

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Fact()
            }
        }
    }
}
@Composable
fun Fact() {
    // fact list
    val facts = listOf(
        "Platypuses have fluorescent fur that glows when exposed to UV light.",
        "When an immortal jellyfish (Turritopsis dohrnii) grows old or damaged, the species can evade death by reverting to a baby polyp stage.",
        "Snakes use their tongues to smell.",
        "In Switzerland, an anti-cruelty law was passed requiring people who are buying either cats or dogs to buy two instead of one.",
        "Raccoons are actually very clean animals, and will go to the bathroom in the same spot, away from where they eat and sleep. This spot is known as a \"Latrine Site\".",
        "Each day, wild koalas eat around 510 grams of fresh succulent eucalyptus leaves, and the water in the foliage they feed on is believed to contribute about three quarters of their water intake in both summer and winter.",
        "Koalas' diet consists mostly of eucalyptus but they only recognize the leaves as food when on a branch.",
        "Flamingos are pink on the inside, not just the outside.",
        "There are some animals that appear to be bulletproof. Armadillo ‘armour’ – composed of bony plates known as osteoderms – has been seen to deflect bullets.",
        "Dolphins use toxic pufferfish to \"get high\"",
        "Giraffes' long necks are not only designed for reaching leaves beyond the reach of their competitors, but also for fighting. ",
        "An elephant's trunk contains tens of thousands of individual muscles (many more than in the entire human body)"
    )

    // state to hold the current index
    var currIndex by remember { mutableStateOf(0) }

    // randomly select a new fact
    // ensures that same index isnt selected twice in a row
    fun nextFact() {
        var newIndex = Random.nextInt(facts.size)

        while (newIndex == currIndex) {
            newIndex = Random.nextInt(facts.size)
        }
        currIndex = newIndex
    }


    // display quote and button
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "˗ˏˋ ✩₊˚.⋆ Fun Fact ⋆⁺₊✧ ˎˊ˗" ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,

            color = Color.hsv(226f, 0.74f, 0.36f)
        )

        Spacer(modifier = Modifier.height(13.dp))

        Text(
            text = facts[currIndex],
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            color = Color.hsv(46f, 0.85f, 0.63f),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            lineHeight = 35.sp,
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))


        ElevatedButton(onClick = { nextFact() },
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.hsv(226f, 0.74f, 0.36f)),
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .width(300.dp)
                .height(50.dp)
        ){

            Text(
                text = "Next Fact",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsAppTheme {
        Fact()
    }
}