package kotlinweekly.model

import kotlinx.serialization.Serializable

@Serializable
data class Issue(
    val number: Int,
    val date: String,
    val title: String,
    val announcements: List<Item>? = null,
    val articles: List<Item>? = null,
    val jobs: List<Item>? = null,
    val sponsored: Item? = null,
    val videos: List<Item>? = null,
    val podcast: List<Item>? = null,
    val android: List<Item>? = null,
    val kotlinMultiplatformArticles: List<Item>? = null,
    val conferences: List<Item>? = null
)

@Serializable
class Item(
    val title: String,
    val description: String,
    val link: String,
    val shortUrl: String? = null
) {

    fun getLinkingUrl(): String {
        if (shortUrl != null) {
            return shortUrl
        } else {
            return link
        }
    }
}


