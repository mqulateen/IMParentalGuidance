package com.mqul.impg.constants;

public enum CategoryType
{
    NUDITY("advisory-nudity"),
    VIOLENCE("advisory-violence"),
    PROFANITY("advisory-profanity"),
    ALCOHOL("advisory-alcohol"),
    FRIGHTENING("advisory-frightening");

    private final String type;

    CategoryType(String type)
    {
        this.type = type;
    }

    public static CategoryType getCategoryByType(String type)
    {
        for(CategoryType cat : values())
        {
            if(cat.type.equalsIgnoreCase(type))
            {
                return cat;
            }
        }

        throw new IllegalArgumentException("could not find category for type: " + type);
    }
}
