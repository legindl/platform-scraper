package Miosz.newsPlatform_Scraper.BLL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {

    public String scrapeNews(String url){
        String fullNews = null;

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.title());
        Elements newsParagraphs = doc.select("section.articlebody > p");
        for (Element paragraph : newsParagraphs) {
            fullNews = fullNews + " " + paragraph.text();
        }


        return fullNews;
    }
}
