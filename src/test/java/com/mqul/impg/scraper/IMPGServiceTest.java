package com.mqul.impg.scraper;

import com.mqul.impg.impl.IMPGService;
import com.mqul.impg.model.PGModel;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.mqul.impg.constants.CategoryType.*;
import static com.mqul.impg.constants.StatusType.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IMPGServiceTest
{
    private static IMPGService impg = new IMPGService();

    @Test
    public void testImplResponse() throws IOException
    {
        final String imdbRef = "1825683";

        final List<PGModel> pgModelList = impg.pullPGData(imdbRef);

        assertThat(pgModelList, notNullValue());
        assertThat(pgModelList, hasSize(5));
    }

    @Test
    public void testImplResponseCategory() throws IOException
    {
        final String imdbRef = "4701724";

        final List<PGModel> pgModelList = impg.pullPGData(imdbRef);

        assertThat(pgModelList, hasSize(5));
        assertThat(pgModelList.get(0).getCategoryType(), isOneOf(NUDITY, VIOLENCE, PROFANITY, ALCOHOL, FRIGHTENING));
    }

    @Test
    public void testImplResponseStatus() throws IOException
    {
        final String imdbRef = "0408236";

        final List<PGModel> pgModelList = impg.pullPGData(imdbRef);

        assertThat(pgModelList, hasSize(5));
        assertThat(pgModelList.get(0).getOverallStatus(), isOneOf(NONE, MILD, MODERATE, SEVERE));
    }

    @Test
    public void testImplResponseFailsForActorRef() throws IOException
    {
        final String imdbRef = "0001758";

        final List<PGModel> pgModelList = impg.pullPGData(imdbRef);

        for(PGModel pgModel : pgModelList)
            assertThat(pgModel.isEmpty(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImplResponseFailsForNoRef() throws IOException
    {
        final String imdbRef = "";

        final List<PGModel> pgModelList = impg.pullPGData(imdbRef);
    }
}
