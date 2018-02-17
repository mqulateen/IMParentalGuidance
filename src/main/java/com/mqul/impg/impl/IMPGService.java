package com.mqul.impg.impl;

import com.mqul.impg.data.Parser;
import com.mqul.impg.data.Scraper;
import com.mqul.impg.model.PGModel;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IMPGService
{
    /**
     * scraper imdb webpage for parental guidance data (on movie ref provided)
     * parse scraped data into more readable POJO's
     *
     * @param imdbRef
     * @return
     * @throws IOException
     */
    public List<PGModel> pullPGData(String imdbRef) throws IOException
    {
        if(imdbRef == null || imdbRef.isEmpty())
        {
            throw new IllegalArgumentException("imdbRef cannot be empty");
        }

        final Document document = new Scraper().scrape(imdbRef);

        final List<PGModel> pgModelList = new Parser().parseDocument(document);

        return pgModelList;
    }
}
