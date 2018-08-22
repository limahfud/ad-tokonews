package me.mahfud.tokonews.network.response

import me.mahfud.tokonews.model.Article

data class ArticlesResponse(val status: String,
                            val totalResults: Int,
                            val articles: List<Article>)