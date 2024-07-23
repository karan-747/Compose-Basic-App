package com.testers.unique.compose.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.testers.unique.compose.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBlogItem(){
//    BlogItem(R.drawable.luffy,"Monkey D Luffy", "Straw-Hat Pirates-Captain")
    LazyColumn(content = {
        items(getOnePieceCharacters()){
            BlogItem(image = it.image, name = it.name, title = it.title)
        }
    })
}





@Composable
fun BlogItem(image: Int,name:String,title:String) {

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier.padding(start = 8.dp, end = 8.dp,top=5.dp, bottom = 3.dp)
    ) {
        Row(

            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .weight(.15f)
                    .padding(4.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Column(
                modifier = Modifier.weight(.85f)
            ) {
                Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = title, fontSize = 18.sp)
            }
        }
    }
}

data class  Character(
    val name :String,
    val title:String,
    val image:Int
)

fun getOnePieceCharacters():List<Character>{
    val list = mutableListOf<Character>()
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    list.add(Character("Monkey.D.Luffy","Straw-Hat Pirates(C)",R.drawable.luffykid))
    return list
}