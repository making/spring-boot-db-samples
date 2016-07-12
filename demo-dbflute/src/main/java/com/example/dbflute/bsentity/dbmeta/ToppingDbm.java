package com.example.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.example.dbflute.allcommon.*;
import com.example.dbflute.exentity.*;

/**
 * The DB meta of TOPPING. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class ToppingDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final ToppingDbm _instance = new ToppingDbm();
    private ToppingDbm() {}
    public static ToppingDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((Topping)et).getId(), (et, vl) -> ((Topping)et).setId(ctl(vl)), "id");
        setupEpg(_epgMap, et -> ((Topping)et).getName(), (et, vl) -> ((Topping)et).setName((String)vl), "name");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "TOPPING";
    protected final String _tableDispName = "TOPPING";
    protected final String _tablePropertyName = "topping";
    protected final TableSqlName _tableSqlName = new TableSqlName("TOPPING", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("ID", "ID", null, null, Long.class, "id", null, true, true, true, "BIGINT", 19, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_A283C780_467C_4212_A3B4_0FE6AAFE58A5", false, null, null, null, "pizzaToppingsList", null, false);
    protected final ColumnInfo _columnName = cci("NAME", "NAME", null, null, String.class, "name", null, false, false, false, "VARCHAR", 255, 0, null, false, null, null, null, null, null, false);

    /**
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnId() { return _columnId; }
    /**
     * NAME: {VARCHAR(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnName() { return _columnName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * PIZZA_TOPPINGS by TOPPINGS_ID, named 'pizzaToppingsList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerPizzaToppingsList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnId(), PizzaToppingsDbm.getInstance().columnToppingsId());
        return cri("FK7TCTI2CXAU3CSVBUWXN0SCB93", "pizzaToppingsList", this, PizzaToppingsDbm.getInstance(), mp, false, "topping");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.exentity.Topping"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.cbean.ToppingCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.exbhv.ToppingBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Topping> getEntityType() { return Topping.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Topping newEntity() { return new Topping(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Topping)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Topping)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
