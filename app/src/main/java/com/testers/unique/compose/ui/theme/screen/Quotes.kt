package com.testers.unique.compose.ui.theme.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.testers.unique.compose.R
import com.testers.unique.compose.ui.theme.DataManager
import com.testers.unique.compose.ui.theme.model.Quote

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewQuoteItem() {

    QuoteDetail(
        Quote(
            text = "I don't want to conquer anything. I just think the guy with the most freedom in this whole ocean... is the Pirate King!",
            author = "Monkey.D.Luffy"
        )
    )
}

@Composable
fun QuoteDetail(quote: Quote) {
    BackHandler {
        DataManager.updateAndSwitch(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier
                .padding(4.dp)
        ) {
            Row(
                modifier = Modifier.padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.luffykid),
                    contentDescription = "",
                    modifier = Modifier.weight(.2f)
                )
                Column(
                    modifier = Modifier
                        .weight(.8f)
                        .padding(top = 4.dp, bottom = 4.dp),
                    verticalArrangement = Arrangement.SpaceEvenly

                ) {
                    Text(
                        text = quote.text,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 2.dp)

                    )
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .background(Color.LightGray)
                            .height(2.dp)
                            .fillMaxWidth(.6f)

                    )
                    Text(
                        text = quote.author,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun QuoteItem(quote: Quote, onClick: (quote:Quote) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(quote)
            }

    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.luffykid),
                contentDescription = "",
                modifier = Modifier.weight(.2f)
            )
            Column(
                modifier = Modifier
                    .weight(.8f)
                    .padding(top = 4.dp, bottom = 4.dp),
                verticalArrangement = Arrangement.SpaceEvenly

            ) {
                Text(
                    text = quote.text,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 2.dp)

                )
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .background(Color.LightGray)
                        .height(2.dp)
                        .fillMaxWidth(.6f)

                )
                Text(
                    text = quote.author,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Thin,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }
    }

}

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuoteItem(quote = it, onClick)
        }
    })
}


@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    Column {
        Text(
            text = "Quotes",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth()
        )
        QuoteList(data = data,onClick)
    }

}