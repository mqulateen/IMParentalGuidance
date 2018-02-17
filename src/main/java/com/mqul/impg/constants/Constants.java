package com.mqul.impg.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants
{
    public static final String BASE_URL = "http://www.imdb.com/title/tt%s/parentalguide";

    public static final List<String> CATEGORIES = Collections.unmodifiableList(
        Arrays.asList("advisory-nudity", "advisory-violence", "advisory-profanity",
                "advisory-alcohol", "advisory-frightening")
    );

    public static final String PG_TITLE             = "ipl-list-title";
    public static final String PG_STATUS            = "ipl-status-pill";
    public static final String PG_OVERALL_VOTE      = "advisory-severity-vote__message";
    public static final String PG_COMMENTS          = "li.ipl-zebra-list__item";
    public static final String PG_INDIVIDUAL_VOTES  = "span.advisory-severity-vote__vote-button-container";

    public static final String SPACE  = " ";
}
