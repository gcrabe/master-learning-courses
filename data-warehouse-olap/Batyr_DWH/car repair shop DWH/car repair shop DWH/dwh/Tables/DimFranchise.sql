CREATE TABLE [dwh].[DimFranchise] (
    [DimFranchiseKey] INT            IDENTITY (1, 1) NOT NULL,
    [FranchiseName]   NVARCHAR (255) NULL,
    [SysDateCreated]  DATETIME       CONSTRAINT [DF_DWH_DimFranchise_CreateDate] DEFAULT (getdate()) NULL,
    [SysDateChanged]  DATETIME       CONSTRAINT [DF_DWH_DimFranchise_ModifiedDate] DEFAULT (getdate()) NULL,
    PRIMARY KEY CLUSTERED ([DimFranchiseKey] ASC)
);

