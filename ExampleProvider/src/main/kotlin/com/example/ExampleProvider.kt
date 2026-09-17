package com.example

class ExampleProvider : MainAPI() {
    override var mainUrl = "https://www.fullhdfilmizlesene.now/"
    override var name = "Filmizlesene"
    override val supportedTypes = setOf(TvType.Movie)
    override var lang = "tr"
    override val hasMainPage = true

    override suspend fun search(query: String): List<SearchResponse> {
        // Sitenin arama API/HTML yapısına göre burada arama yapılır.
        return emptyList()
    }
}

import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.SearchResponse

class ExampleProvider : MainAPI() { // all providers must be an instance of MainAPI
    override var mainUrl = "https://example.com/" 
    override var name = "Example provider"
    override val supportedTypes = setOf(TvType.Movie)

    override var lang = "en"

    // enable this when your provider has a main page
    override val hasMainPage = true

    // this function gets called when you search for something
    override suspend fun search(query: String): List<SearchResponse> {
        return listOf<SearchResponse>()
    }
}
