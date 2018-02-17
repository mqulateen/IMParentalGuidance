package com.mqul.impg.constants;

public enum StatusType
{
    NONE("None"),
    MILD("Mild"),
    MODERATE("Moderate"),
    SEVERE("Severe");

    private final String severity;

    StatusType(String severity)
    {
        this.severity = severity;
    }

    public static StatusType getStatusBySeverity(String severity)
    {
        for(StatusType status : values())
        {
            if (status.severity.equalsIgnoreCase(severity))
            {
                return status;
            }
        }

        return NONE;
    }

    public String getSeverity()
    {
        return this.severity;
    }
}
