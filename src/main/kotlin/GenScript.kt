import com.charleskorn.kaml.Yaml
import kotlinweekly.model.Issue
import kotlinweekly.model.Item
import java.io.File
import java.net.URL

fun main() {
    val file = File("src/sample.yaml")
    val result = Yaml.default.parse(Issue.serializer(), file.readText())

    var html = createHeader(result.number.toString(), result.date)
    html += createTitle(result.title)
    result.announcements?.let { html += createAnnouncements(result.announcements) }
    result.articles?.let { html += createArticles(result.articles) }
    result.sponsored?.let {  html += createSponsored(result.sponsored) }
    result.android?.let { html += createAndroid(result.android) }
    result.kotlinMultiplatformArticles?.let { html += createMultiplatform(result.kotlinMultiplatformArticles) }
    result.videos?.let { html += createVideos(result.videos) }
    result.jobs?.let { html += createJobs(result.jobs) }
    result.podcast?.let { html += createPodcast(result.podcast) }

    html += createFooter()
    print(html)
}

fun createHeader(number: String, date: String): String {
    return "<h1 style=\"text-align: center;\"><span style=\"font-size:18px\"><strong><span " +
            "style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\">ISSUE</span></strong> " +
            "<span style=\"color:#FFFFFF\"><span style=\"background-color:#7874b4; margin:20px 5px 20px 5px; padding:5px 5px 5px 5px\">#" + number + "</span></span></span></h1>\n" +
            "\n" +
            "<div style=\"text-align: center; line-height: 50%; margin:10px 0px 0px 0px;\">" +
            "<span style=\"color:#D3D3D3\"><span style=\"font-size:12px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\">" +
            date + "</span></span></span><br />\n" +
            "&nbsp;</div>\n"
}

fun createTitle(title: String): String {
    return "<p><span style=\"font-size:14px\"><span style=\"font-family:helvetica neue\">$title</span></span></p>\n"
}

fun createAnnouncements(articles: List<Item>): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"\n" +
            "    width:30%;\n" +
            "\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><img data-file-id=\"2573165\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/b61142be-473c-436a-84ad-8338e13e31da.png\" style=\"border: 0px  ; width: 65px; height: 65px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#7874b4; padding:5px 5px 5px 5px\">Announcements</span></span></span></span></strong></p>\n" +
            "</div>\n"
    html += "<div style=\"  \n" +
            "    width:70%;\n" +
            "    float:left;\n" +
            "    \"><br />\n"

    for (article in articles) {
        html += "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#7874b4\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        var url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#7874b4\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }
    html += "</div></div>"

    return html
}

fun createArticles(articles: List<Item>): String {
    var html = "\n" +
            "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><br />\n" +
            "<img data-file-id=\"2573169\" height=\"64\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/aecc15c5-3b55-4f56-b171-6c933eabb173.png\" style=\"border: 0px initial ; width: 65px; height: 64px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#f1646c; padding:5px 5px 5px 5px\">Articles</span></span></span></span></strong></p>\n" +
            "</div>\n"
    html += "<div style=\"  \n" +
            "    width:70%;\n" +
            "    float:left;\n" +
            "    \"><br />\n"

    for (article in articles) {
        html += "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#f1646c\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        var url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#f1646c\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }
    html += "</div></div>"

    return html
}

fun createAndroid(articles: List<Item>): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><br />\n" +
            "<img data-file-id=\"2573205\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/d6dd1767-fc87-4f29-8899-ab4caae6903d.png\" style=\"border: 0px initial ; width: 65px; height: 65px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#79c5b4; padding:5px 5px 5px 5px\">Android</span></span></span></span></strong></p>\n" +
            "</div>"
    html += "<div style=\"  \n" +
            "    width:70%;\n" +
            "    float:left;\n" +
            "    \"><br />\n"
    for (article in articles) {
        html += "<div style=\"  \n" +
                "    width:70%;\n" +
                "    float:left;\n" +
                "    \"><br />\n" +
                "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#79c5b4\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        val url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#79c5b4\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }

    html += "</div></div></div></div>"
    return html
}

fun createSponsored(sponsored: Item): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"background-color:#f0f0f0;\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><img data-file-id=\"2573201\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/57e35131-d16d-4d0c-a6a6-ff0c005d0c16.png\" style=\"border: 0px  ; width: 79px; height: 40px; margin: 0px;\" width=\"79\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#b3a34f; padding:5px 5px 5px 5px\">Sponsored</span></span></span></span></strong></p>\n" +
            "</div>"
    val url = URL(sponsored.link)
    html += "<div style=\"  background-color:#f0f0f0;\n" +
            "    width:66%;\n" +
            "    float:left; padding:5px 5px 5px 10px\n" +
            "    \"><a href=\""+sponsored.link+"\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#b3a34f\">"+sponsored.text+"</span></span></span></strong></a><br />\n" +
            ""+sponsored.description+"<br />\n" +
            "<a href=\""+url.host+"\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#b3a34f\">getstream.io</span></strong></a></div>\n" +
            "</div>\n"
    return html
}

fun createMultiplatform(articles: List<Item>): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><br />\n" +
            "<img data-file-id=\"2573205\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/d6dd1767-fc87-4f29-8899-ab4caae6903d.png\" style=\"border: 0px initial ; width: 65px; height: 65px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#79c5b4; padding:5px 5px 5px 5px\">Multiplatform</span></span></span></span></strong></p>\n" +
            "</div>"
    html += "<div style=\"  \n" +
            "    width:70%;\n" +
            "    float:left;\n" +
            "    \"><br />\n"
    for (article in articles) {
        html += "<div style=\"  \n" +
                "    width:70%;\n" +
                "    float:left;\n" +
                "    \"><br />\n" +
                "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#79c5b4\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        val url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#79c5b4\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }

    html += "</div></div></div></div>"
    return html
}

fun createJobs(articles: List<Item>): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"background-color:#f0f0f0;\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><img data-file-id=\"2573181\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/b3899433-4991-436c-b3ac-f4f309129ed3.jpg\" style=\"border: 0px  ; width: 65px; height: 65px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#1a3b47; padding:5px 5px 5px 5px\">Jobs</span></span></span></span></strong></p>\n" +
            "</div>"
    for (article in articles) {
        html += "<div style=\"background-color:#f0f0f0;\n" +
                "    width:70%;\n" +
                "    float:left;\n" +
                "    \"><br />\n" +
                "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#1a3b47\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        val url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#1a3b47\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }

    html += "</div></div></div></div>"
    return html
}

fun createVideos(articles: List<Item>): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><br />\n" +
            "<img data-file-id=\"2573177\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/85924742-e83e-4289-96e8-4dba7fa1a8a8.png\" style=\"border: 0px  ; width: 65px; height: 65px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#cc916e; padding:5px 5px 5px 5px\">Videos</span></span></span></span></strong></p>\n" +
            "</div>"
    html += "<div style=\"  \n" +
            "    width:70%;\n" +
            "    float:left;\n" +
            "    \"><br />\n"
    for (article in articles) {
        html += "<div style=\"  \n" +
                "    width:70%;\n" +
                "    float:left;\n" +
                "    \"><br />\n" +
                "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#cc916e\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        val url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#cc916e\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }

    html += "</div></div></div></div>"
    return html
}

fun createPodcast(articles: List<Item>): String {
    var html = "<div style=\"overflow: hidden;\">\n" +
            "<div style=\"\n" +
            "    width:30%;\n" +
            "    float:left\">\n" +
            "<p style=\"text-align: center;\"><br />\n" +
            "<img data-file-id=\"2573205\" height=\"65\" src=\"https://gallery.mailchimp.com/f39692e245b94f7fb693b6d82/images/d6dd1767-fc87-4f29-8899-ab4caae6903d.png\" style=\"border: 0px initial ; width: 65px; height: 65px; margin: 0px;\" width=\"65\" /><br />\n" +
            "<strong><span style=\"font-size:11px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><span style=\"color:#FFFFFF\"><span style=\"background-color:#79c5b4; padding:5px 5px 5px 5px\">Podcast</span></span></span></span></strong></p>\n" +
            "</div>"
    html += "<div style=\"  \n" +
            "    width:70%;\n" +
            "    float:left;\n" +
            "    \"><br />\n"
    for (article in articles) {
        html += "<div style=\"  \n" +
                "    width:70%;\n" +
                "    float:left;\n" +
                "    \"><br />\n" +
                "<a href=\"" + article.link + "\" style=\"text-decoration:none\" target=\"_blank\"><span style=\"font-size:16px\"><span style=\"font-family:helvetica neue,helvetica,arial,verdana,sans-serif\"><strong><span style=\"color:#79c5b4\">" + article.text + "</span></strong></span></span></a><br />\n" +
                "" + article.description + "<br />"
        val url = URL(article.link)
        html += "<a href=\"" + url.host + "\" style=\"text-decoration:none\" target=\"_blank\"><strong><span style=\"color:#79c5b4\">" + url.host + "</span></strong></a><br />\n" +
                "<br />"
    }

    html += "</div></div></div></div>"
    return html
}

fun createFooter(): String {
    return "\n" +
            "<p><u><strong>Contribute</strong></u></p>\n" +
            "\n" +
            "<p>We rely on sponsors to offer quality content every Sunday. If you would like to submit a sponsored link&nbsp;<a href=\"mailto:mailinglist@kotlinweekly.net?subject=Sponsoring%20for%20Kotlin%20Weekly\" target=\"_blank\">contact us</a>.</p>\n" +
            "\n" +
            "<p>If you want to submit an article for the next issue, please do also&nbsp;<a href=\"mailto:mailinglist@kotlinweekly.net?subject=Link%20for%20submission%20-%20Kotlin%20Weekly\" target=\"_blank\">drop us an email</a>.<br />\n" +
            "<br />\n" +
            "Thanks to&nbsp;<a data-saferedirecturl=\"https://www.google.com/url?q=https://www.jetbrains.com&amp;source=gmail&amp;ust=1574619446734000&amp;usg=AFQjCNF55EKdvRXZhaWpa1H0VQ-UJ5viiQ\" href=\"https://www.jetbrains.com/\" target=\"_blank\">JetBrains</a>&nbsp;for their support!</p>\n"
}