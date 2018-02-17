package com.mqul.impg.model;

import com.mqul.impg.constants.CategoryType;
import com.mqul.impg.constants.StatusType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PGModel implements Serializable
{
    private String title;
    private StatusType overallStatus;
    private String overallVote;
    private List<String> comments;
    private Map<StatusType, Integer> votesByStatusType;
    private CategoryType categoryType;

    public PGModel(String title, StatusType overallStatus, String overallVote, List<String> comments,
                   Map<StatusType, Integer> votesByStatusType, CategoryType categoryType)
    {
        this.title = title;
        this.overallStatus = overallStatus;
        this.overallVote = overallVote;
        this.comments = comments;
        this.votesByStatusType = votesByStatusType;
        this.categoryType = categoryType;
    }

    public String getTitle()
    {
        return title;
    }

    public StatusType getOverallStatus()
    {
        return overallStatus;
    }

    public String getOverallVote()
    {
        return overallVote;
    }

    public List<String> getComments()
    {
        return comments;
    }

    public Map<StatusType, Integer> getVotesByStatusType()
    {
        return votesByStatusType;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public boolean isEmpty()
    {
        return overallStatus == StatusType.NONE
            && overallVote.isEmpty()
            && comments.isEmpty();
    }

    @Override
    public String toString()
    {
        return "PGModel{" +
                "title='" + title + '\'' + '\n' +
                ", overallStatus=" + overallStatus + '\n' +
                ", overallVote='" + overallVote + '\'' + '\n' +
                ", comments=" + comments + '\n' +
                ", votesByStatusType=" + votesByStatusType + '\n' +
                ", categoryType=" + categoryType +
                '}';
    }
}
