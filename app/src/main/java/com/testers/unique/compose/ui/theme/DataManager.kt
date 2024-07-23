package com.testers.unique.compose.ui.theme

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.testers.unique.compose.Pages
import com.testers.unique.compose.ui.theme.model.Quote
import java.nio.charset.Charset

object DataManager {
    var data = emptyArray<Quote>()
    val isDataLoaded = mutableStateOf(false)
    val currentpage = mutableStateOf(Pages.LISTINGS)
    var currentQuote :Quote? =null
    fun loadQuotesFromAssets(context:Context){
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.defaultCharset())
        val gson =Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value=true
    }

    fun switchPages(){
        if(currentpage.value == Pages.LISTINGS){
            currentpage.value=Pages.DETAIL
        }else{
            currentpage.value=Pages.LISTINGS
            currentQuote=null
        }
    }
    fun updateCurrentQuote(quote:Quote?){
        currentQuote=quote
    }
    fun updateAndSwitch(quote: Quote?):Unit{
        updateCurrentQuote(quote)
        switchPages()
    }
}