CREATE TABLE [dwh].[DimGeography] (
    [DimGeographyKey] INT            IDENTITY (1, 1) NOT NULL,
    [Region]          NVARCHAR (255) NULL,
    [SubRegion]       NVARCHAR (255) NULL,
    [Country]         NVARCHAR (255) NULL,
    [SysDateCreated]  DATETIME       CONSTRAINT [DF_DWH_DimGeography_CreateDate] DEFAULT (getdate()) NULL,
    [SysDateChanged]  DATETIME       CONSTRAINT [DF_DWH_DimGeography_ModifiedDate] DEFAULT (getdate()) NULL,
    PRIMARY KEY CLUSTERED ([DimGeographyKey] ASC)
);

