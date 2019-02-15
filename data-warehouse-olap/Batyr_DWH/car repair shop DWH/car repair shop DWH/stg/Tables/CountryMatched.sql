CREATE TABLE [stg].[CountryMatched] (
    [CountryMatchedKey] INT            IDENTITY (1, 1) NOT NULL,
    [Country]           NVARCHAR (255) NULL,
    [Country1]          NVARCHAR (255) NULL,
    [Similarity]        FLOAT (53)     NULL,
    [Confidence]        FLOAT (53)     NULL,
    [SimCountry]        FLOAT (53)     NULL,
    [SysDateCreated]    DATETIME       DEFAULT (getdate()) NOT NULL,
    [SysDateChanged]    DATETIME       DEFAULT (getdate()) NOT NULL,
    PRIMARY KEY CLUSTERED ([CountryMatchedKey] ASC)
);

