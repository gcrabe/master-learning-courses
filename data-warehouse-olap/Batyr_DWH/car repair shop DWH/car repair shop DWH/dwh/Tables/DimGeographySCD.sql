CREATE TABLE [dwh].[DimGeographySCD] (
    [DimCountryKey]   INT            IDENTITY (1, 1) NOT NULL,
    [Region]          NVARCHAR (255) NULL,
    [SubRegion]       NVARCHAR (255) NULL,
    [Country]         NVARCHAR (255) NULL,
    [IsCurrent]       BIT            NULL,
    [DateStart]       DATETIME       NULL,
    [DateEnd]         DATETIME       NULL,
    [sysDateCreated]  DATETIME       CONSTRAINT [DF_DWH_DimGeographySCD_CreateDate] DEFAULT (getdate()) NULL,
    [sysDateModified] DATETIME       CONSTRAINT [DF_DWH_DimGeographySCD_ModifiedDate] DEFAULT (getdate()) NULL,
    CONSTRAINT [PK_dwh_DimGeographySCD] PRIMARY KEY CLUSTERED ([DimCountryKey] ASC)
);

