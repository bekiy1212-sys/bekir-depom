package com.example

class class MyProvider : MainAPI() {
    override var mainUrl = "https://www.fullhdfilmizlesene.now/"
    override var name = "Filmizlesene"
    override val supportedTypes = setOf(TvType.Movie)
    override var lang = "tr"

    override suspend fun search(query: String): List<SearchResponse> {
        val document = app.get("$mainUrl/arama/$query").document

        return document.select("article.movie").mapNotNull { item ->
            val link = item.selectFirst("a")?.attr("href") ?: return@mapNotNull null
            val title = item.selectFirst(".title")?.text() ?: return@mapNotNull null
            val poster = item.selectFirst("img")?.attr("src")

            newMovieSearchResponse(
                title,
                fixUrl(link),
                TvType.Movie
            ) {
                this.posterUrl = poster
            }
        }
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
