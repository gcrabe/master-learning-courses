CREATE PARTITION SCHEME [Ps_UNStatisticDWH_FactCrime]
    AS PARTITION [Pf_UNStatisticDWH_FactCrime]
    TO ([dwh_Fact_Crime_Archive], [dwh_Fact_Crime_Current], [dwh_Fact_Crime_Current], [dwh_Fact_Crime_Current], [dwh_Fact_Crime_Current]);

