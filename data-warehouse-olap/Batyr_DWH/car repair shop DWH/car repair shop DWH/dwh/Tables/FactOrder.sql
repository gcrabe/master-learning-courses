CREATE TABLE [dwh].[FactOrder] (
    [FactOrderKey]      INT             IDENTITY (1, 1) NOT NULL,
    [DimDateKey]        INT             NOT NULL,
    [DimGeographyKey]   INT             NOT NULL,
    [DimFranchiseKey]   INT             NOT NULL,
    [Count]        INT             NOT NULL,
    [Cost] DECIMAL (19, 4) NULL,
    [SysDateCreated]    DATETIME        CONSTRAINT [DF_DWH_FactCrime_CreateDate] DEFAULT (getdate()) NULL,
    [SysDateChanged]    DATETIME        CONSTRAINT [DF_DWH_FactCrime_ModifiedDate] DEFAULT (getdate()) NULL,
    CONSTRAINT [PK_FactCrime] PRIMARY KEY CLUSTERED ([FactOrderKey] ASC, [DimDateKey] ASC) ON [Primary]
);



