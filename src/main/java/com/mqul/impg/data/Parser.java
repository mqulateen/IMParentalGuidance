package com.mqul.impg.data;

import com.mqul.impg.constants.CategoryType;
import com.mqul.impg.constants.StatusType;
import com.mqul.impg.model.PGModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mqul.impg.constants.Constants.*;

public class Parser
{
    /**
     * parse JSoup Document into list of understandable POJO's
     *
     * @param document
     * @return
     */
    public List<PGModel> parseDocument(final Document document)
    {
        final List<PGModel> modelList =
        CATEGORIES.stream().map(cat -> {
            final Element section = document.getElementById(cat);
            final String title = section.getElementsByClass(PG_TITLE).first().html();
            final String status = section.getElementsByClass(PG_STATUS).first().html();
            final String vote = section.getElementsByClass(PG_OVERALL_VOTE).first().html();
            final Elements comments = section.select(PG_COMMENTS);

            final Element votes = section.select(PG_INDIVIDUAL_VOTES).first();

            return new PGModel(title.replace("amp;", ""),
                               StatusType.getStatusBySeverity(status),
                               vote,
                               cleanComments(comments),
                               parseVotes(votes),
                               CategoryType.getCategoryByType(cat));
        }).collect(Collectors.toList());

        return modelList;
    }

    /**
     * group votes by their type - i.e. type, count, type, count, ...
     *
     * @param votes
     * @return
     */
    private Map<StatusType, Integer> parseVotes(Element votes)
    {
        final String[] splitVotes = votes.text().split(SPACE);

        final Map<StatusType, Integer> votesMap = new HashMap<>();
        for(int i = 0; i < splitVotes.length; i+=2)
        {
            votesMap.put(
                StatusType.getStatusBySeverity(splitVotes[i]), Integer.parseInt(splitVotes[i+1])
            );
        }

        return votesMap;
    }

    /**
     * Remove the word edit - found at the end of each comment
     *
     * @param comments
     * @return
     */
    private List<String> cleanComments(Elements comments)
    {
        return comments.eachText().stream()
                .map(s -> s.substring(0, s.length()-5))
                .collect(Collectors.toList());
    }
}
