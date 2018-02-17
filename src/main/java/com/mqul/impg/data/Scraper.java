package com.mqul.impg.data;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.mqul.impg.constants.Constants.BASE_URL;

public class Scraper
{
    /**
     * using JSoup to generate a Document out of the HTML page, which can then easily be parsed
     *
     * @param imdbRef
     * @return
     * @throws IOException
     */
    public Document scrape(final String imdbRef) throws IOException
    {
        final String url = String.format(BASE_URL, imdbRef);

        final Document document = Jsoup.connect(url).get();

        return document;
    }

    /**
     * @Deprecated - using JSoup to scrape and parse HTML instead
     *
     * @param imdbRef
     * @return
     * @throws IOException
     */
    @Deprecated
    public String scrapeHTML(final String imdbRef) throws IOException
    {
        try(CloseableHttpClient httpClient = HttpClients.custom().build())
        {
            final String url = String.format(BASE_URL, imdbRef);

            final HttpGet doGet = new HttpGet(url);
            final CloseableHttpResponse response = httpClient.execute(doGet);

            return EntityUtils.toString(response.getEntity());
        }
    }
}
