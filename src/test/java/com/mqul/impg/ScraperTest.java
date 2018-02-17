package com.mqul.impg;

import com.mqul.impg.data.Scraper;
import org.jsoup.nodes.Document;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ScraperTest
{
    private final static String IMDB_REF = "1825683";
    private final static Scraper imdbScraper = new Scraper();

    @Ignore
    @Test
    public void testScraper() throws IOException
    {
        String data = imdbScraper.scrapeHTML(IMDB_REF);

        assertThat(data, notNullValue());
    }

    @Test
    public void testJSoupScraper() throws IOException
    {
        final Document data = imdbScraper.scrape(IMDB_REF);

        assertThat(data, notNullValue());
        assertThat(data.title(), is("Parents Guide - IMDb"));
        assertThat(data.body().text().isEmpty(), is(false));
    }
}
