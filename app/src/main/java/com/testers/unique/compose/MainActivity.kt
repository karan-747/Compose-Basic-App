package com.testers.unique.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.testers.unique.compose.ui.theme.DataManager
import com.testers.unique.compose.ui.theme.model.Quote
import com.testers.unique.compose.ui.theme.screen.ComposeTheme
import com.testers.unique.compose.ui.theme.screen.PreviewBlogItem
import com.testers.unique.compose.ui.theme.screen.QuoteDetail
import com.testers.unique.compose.ui.theme.screen.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadQuotesFromAssets(applicationContext)
        }

        
        setContent {
            App()
        }
    }


}



@Composable
fun App() {
    if(DataManager.isDataLoaded.value){
        if(DataManager.currentpage.value ==Pages.LISTINGS){
            QuoteListScreen(data = DataManager.data){
                DataManager.updateAndSwitch(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }
}



enum class Pages{
    LISTINGS,
    DETAIL
}

