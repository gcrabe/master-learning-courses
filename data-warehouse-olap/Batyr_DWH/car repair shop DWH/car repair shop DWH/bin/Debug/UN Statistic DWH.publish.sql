﻿/*
Deployment script for MSBI_CrimeStatistic_Kirill_Evseev

This code was generated by a tool.
Changes to this file may cause incorrect behavior and will be lost if
the code is regenerated.
*/

GO
SET ANSI_NULLS, ANSI_PADDING, ANSI_WARNINGS, ARITHABORT, CONCAT_NULL_YIELDS_NULL, QUOTED_IDENTIFIER ON;

SET NUMERIC_ROUNDABORT OFF;


GO
:setvar DatabaseName "MSBI_CrimeStatistic_Kirill_Evseev"
:setvar DefaultFilePrefix "MSBI_CrimeStatistic_Kirill_Evseev"
:setvar DefaultDataPath "C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQL2014MDX\MSSQL\DATA\"
:setvar DefaultLogPath "C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQL2014MDX\MSSQL\DATA\"

GO
:on error exit
GO
/*
Detect SQLCMD mode and disable script execution if SQLCMD mode is not supported.
To re-enable the script after enabling SQLCMD mode, execute the following:
SET NOEXEC OFF; 
*/
:setvar __IsSqlCmdEnabled "True"
GO
IF N'$(__IsSqlCmdEnabled)' NOT LIKE N'True'
    BEGIN
        PRINT N'SQLCMD mode must be enabled to successfully execute this script.';
        SET NOEXEC ON;
    END


GO
USE [$(DatabaseName)];


GO
PRINT N'Dropping [stg].[DF_Test1_UNCD_Cleaned_sysDateCreated]...';


GO
ALTER TABLE [stg].[UNCrimeData_Cleaned] DROP CONSTRAINT [DF_Test1_UNCD_Cleaned_sysDateCreated];


GO
PRINT N'Dropping [stg].[DF_STG_POPULTAION_Cleaned]...';


GO
ALTER TABLE [stg].[WBPopulationData_Cleaned] DROP CONSTRAINT [DF_STG_POPULTAION_Cleaned];


GO
PRINT N'Starting rebuilding table [stg].[UNCrimeData_Cleaned]...';


GO
BEGIN TRANSACTION;

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

SET XACT_ABORT ON;

CREATE TABLE [stg].[tmp_ms_xx_UNCrimeData_Cleaned] (
    [UNCrimeDataKey] INT            IDENTITY (1, 1) NOT NULL,
    [Region]         NVARCHAR (255) NULL,
    [SubRegion]      NVARCHAR (255) NULL,
    [Country]        NVARCHAR (255) NULL,
    [total2003]      NVARCHAR (255) NULL,
    [total2004]      NVARCHAR (255) NULL,
    [total2005]      NVARCHAR (255) NULL,
    [total2006]      NVARCHAR (255) NULL,
    [total2007]      NVARCHAR (255) NULL,
    [total2008]      NVARCHAR (255) NULL,
    [total2009]      NVARCHAR (255) NULL,
    [total2010]      NVARCHAR (255) NULL,
    [total2011]      NVARCHAR (255) NULL,
    [total2012]      NVARCHAR (255) NULL,
    [total2013]      NVARCHAR (255) NULL,
    [total2014]      NVARCHAR (255) NULL,
    [rate2003]       NVARCHAR (255) NULL,
    [rate2004]       NVARCHAR (255) NULL,
    [rate2005]       NVARCHAR (255) NULL,
    [rate2006]       NVARCHAR (255) NULL,
    [rate2007]       NVARCHAR (255) NULL,
    [rate2008]       NVARCHAR (255) NULL,
    [rate2009]       NVARCHAR (255) NULL,
    [rate2010]       NVARCHAR (255) NULL,
    [rate2011]       NVARCHAR (255) NULL,
    [rate2012]       NVARCHAR (255) NULL,
    [rate2013]       NVARCHAR (255) NULL,
    [rate2014]       NVARCHAR (255) NULL,
    [SysDateCreated] DATETIME       CONSTRAINT [DF_Test1_UNCD_Cleaned_sysDateCreated] DEFAULT (getdate()) NULL,
    [SysSourceName]  NVARCHAR (255) NULL,
    CONSTRAINT [tmp_ms_xx_constraint_PK_stg_UNCrimeData_Cleaned1] PRIMARY KEY CLUSTERED ([UNCrimeDataKey] ASC)
);

IF EXISTS (SELECT TOP 1 1 
           FROM   [stg].[UNCrimeData_Cleaned])
    BEGIN
        SET IDENTITY_INSERT [stg].[tmp_ms_xx_UNCrimeData_Cleaned] ON;
        INSERT INTO [stg].[tmp_ms_xx_UNCrimeData_Cleaned] ([UNCrimeDataKey], [Region], [SubRegion], [Country], [total2003], [total2004], [total2005], [total2006], [total2007], [total2008], [total2009], [total2010], [total2011], [total2012], [total2013], [total2014], [rate2003], [rate2004], [rate2005], [rate2006], [rate2007], [rate2008], [rate2009], [rate2010], [rate2011], [rate2012], [rate2013], [rate2014], [SysDateCreated], [SysSourceName])
        SELECT   [UNCrimeDataKey],
                 [Region],
                 [SubRegion],
                 [Country],
                 [total2003],
                 [total2004],
                 [total2005],
                 [total2006],
                 [total2007],
                 [total2008],
                 [total2009],
                 [total2010],
                 [total2011],
                 [total2012],
                 [total2013],
                 [total2014],
                 [rate2003],
                 [rate2004],
                 [rate2005],
                 [rate2006],
                 [rate2007],
                 [rate2008],
                 [rate2009],
                 [rate2010],
                 [rate2011],
                 [rate2012],
                 [rate2013],
                 [rate2014],
                 [SysDateCreated],
                 [SysSourceName]
        FROM     [stg].[UNCrimeData_Cleaned]
        ORDER BY [UNCrimeDataKey] ASC;
        SET IDENTITY_INSERT [stg].[tmp_ms_xx_UNCrimeData_Cleaned] OFF;
    END

DROP TABLE [stg].[UNCrimeData_Cleaned];

EXECUTE sp_rename N'[stg].[tmp_ms_xx_UNCrimeData_Cleaned]', N'UNCrimeData_Cleaned';

EXECUTE sp_rename N'[stg].[tmp_ms_xx_constraint_PK_stg_UNCrimeData_Cleaned1]', N'PK_stg_UNCrimeData_Cleaned', N'OBJECT';

COMMIT TRANSACTION;

SET TRANSACTION ISOLATION LEVEL READ COMMITTED;


GO
PRINT N'Starting rebuilding table [stg].[WBPopulationData_Cleaned]...';


GO
BEGIN TRANSACTION;

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

SET XACT_ABORT ON;

CREATE TABLE [stg].[tmp_ms_xx_WBPopulationData_Cleaned] (
    [WBPopulationDataKey] INT            IDENTITY (1, 1) NOT NULL,
    [CountryName]         NVARCHAR (255) NULL,
    [CountryCode]         NVARCHAR (255) NULL,
    [IndicatorName]       NVARCHAR (255) NULL,
    [IndicatorCode]       NVARCHAR (255) NULL,
    [1960]                NVARCHAR (255) NULL,
    [1961]                NVARCHAR (255) NULL,
    [1962]                NVARCHAR (255) NULL,
    [1963]                NVARCHAR (255) NULL,
    [1964]                NVARCHAR (255) NULL,
    [1965]                NVARCHAR (255) NULL,
    [1966]                NVARCHAR (255) NULL,
    [1967]                NVARCHAR (255) NULL,
    [1968]                NVARCHAR (255) NULL,
    [1969]                NVARCHAR (255) NULL,
    [1970]                NVARCHAR (255) NULL,
    [1971]                NVARCHAR (255) NULL,
    [1972]                NVARCHAR (255) NULL,
    [1973]                NVARCHAR (255) NULL,
    [1974]                NVARCHAR (255) NULL,
    [1975]                NVARCHAR (255) NULL,
    [1976]                NVARCHAR (255) NULL,
    [1977]                NVARCHAR (255) NULL,
    [1978]                NVARCHAR (255) NULL,
    [1979]                NVARCHAR (255) NULL,
    [1980]                NVARCHAR (255) NULL,
    [1981]                NVARCHAR (255) NULL,
    [1982]                NVARCHAR (255) NULL,
    [1983]                NVARCHAR (255) NULL,
    [1984]                NVARCHAR (255) NULL,
    [1985]                NVARCHAR (255) NULL,
    [1986]                NVARCHAR (255) NULL,
    [1987]                NVARCHAR (255) NULL,
    [1988]                NVARCHAR (255) NULL,
    [1989]                NVARCHAR (255) NULL,
    [1990]                NVARCHAR (255) NULL,
    [1991]                NVARCHAR (255) NULL,
    [1992]                NVARCHAR (255) NULL,
    [1993]                NVARCHAR (255) NULL,
    [1994]                NVARCHAR (255) NULL,
    [1995]                NVARCHAR (255) NULL,
    [1996]                NVARCHAR (255) NULL,
    [1997]                NVARCHAR (255) NULL,
    [1998]                NVARCHAR (255) NULL,
    [1999]                NVARCHAR (255) NULL,
    [2000]                NVARCHAR (255) NULL,
    [2001]                NVARCHAR (255) NULL,
    [2002]                NVARCHAR (255) NULL,
    [2003]                NVARCHAR (255) NULL,
    [2004]                NVARCHAR (255) NULL,
    [2005]                NVARCHAR (255) NULL,
    [2006]                NVARCHAR (255) NULL,
    [2007]                NVARCHAR (255) NULL,
    [2008]                NVARCHAR (255) NULL,
    [2009]                NVARCHAR (255) NULL,
    [2010]                NVARCHAR (255) NULL,
    [2011]                NVARCHAR (255) NULL,
    [2012]                NVARCHAR (255) NULL,
    [2013]                NVARCHAR (255) NULL,
    [2014]                NVARCHAR (255) NULL,
    [2015]                NVARCHAR (255) NULL,
    [SysDateCreated]      DATETIME       CONSTRAINT [DF_STG_POPULTAION_Cleaned] DEFAULT (getdate()) NULL,
    [SysSourceName]       NVARCHAR (255) NULL,
    CONSTRAINT [tmp_ms_xx_constraint_PK_stg_FactPopulationCleaned1] PRIMARY KEY CLUSTERED ([WBPopulationDataKey] ASC)
);

IF EXISTS (SELECT TOP 1 1 
           FROM   [stg].[WBPopulationData_Cleaned])
    BEGIN
        SET IDENTITY_INSERT [stg].[tmp_ms_xx_WBPopulationData_Cleaned] ON;
        INSERT INTO [stg].[tmp_ms_xx_WBPopulationData_Cleaned] ([WBPopulationDataKey], [CountryName], [CountryCode], [IndicatorName], [IndicatorCode], [1960], [1961], [1962], [1963], [1964], [1965], [1966], [1967], [1968], [1969], [1970], [1971], [1972], [1973], [1974], [1975], [1976], [1977], [1978], [1979], [1980], [1981], [1982], [1983], [1984], [1985], [1986], [1987], [1988], [1989], [1990], [1991], [1992], [1993], [1994], [1995], [1996], [1997], [1998], [1999], [2000], [2001], [2002], [2003], [2004], [2005], [2006], [2007], [2008], [2009], [2010], [2011], [2012], [2013], [2014], [2015], [SysDateCreated], [SysSourceName])
        SELECT   [WBPopulationDataKey],
                 [CountryName],
                 [CountryCode],
                 [IndicatorName],
                 [IndicatorCode],
                 [1960],
                 [1961],
                 [1962],
                 [1963],
                 [1964],
                 [1965],
                 [1966],
                 [1967],
                 [1968],
                 [1969],
                 [1970],
                 [1971],
                 [1972],
                 [1973],
                 [1974],
                 [1975],
                 [1976],
                 [1977],
                 [1978],
                 [1979],
                 [1980],
                 [1981],
                 [1982],
                 [1983],
                 [1984],
                 [1985],
                 [1986],
                 [1987],
                 [1988],
                 [1989],
                 [1990],
                 [1991],
                 [1992],
                 [1993],
                 [1994],
                 [1995],
                 [1996],
                 [1997],
                 [1998],
                 [1999],
                 [2000],
                 [2001],
                 [2002],
                 [2003],
                 [2004],
                 [2005],
                 [2006],
                 [2007],
                 [2008],
                 [2009],
                 [2010],
                 [2011],
                 [2012],
                 [2013],
                 [2014],
                 [2015],
                 [SysDateCreated],
                 [SysSourceName]
        FROM     [stg].[WBPopulationData_Cleaned]
        ORDER BY [WBPopulationDataKey] ASC;
        SET IDENTITY_INSERT [stg].[tmp_ms_xx_WBPopulationData_Cleaned] OFF;
    END

DROP TABLE [stg].[WBPopulationData_Cleaned];

EXECUTE sp_rename N'[stg].[tmp_ms_xx_WBPopulationData_Cleaned]', N'WBPopulationData_Cleaned';

EXECUTE sp_rename N'[stg].[tmp_ms_xx_constraint_PK_stg_FactPopulationCleaned1]', N'PK_stg_FactPopulationCleaned', N'OBJECT';

COMMIT TRANSACTION;

SET TRANSACTION ISOLATION LEVEL READ COMMITTED;


GO
PRINT N'Update complete.';


GO