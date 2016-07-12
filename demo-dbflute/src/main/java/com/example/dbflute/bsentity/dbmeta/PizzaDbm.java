package com.example.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.example.dbflute.allcommon.*;
import com.example.dbflute.exentity.*;

/**
 * The DB meta of PIZZA. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PizzaDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PizzaDbm _instance = new PizzaDbm();
    private PizzaDbm() {}
    public static PizzaDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Pizza)et).getId(), (et, vl) -> ((Pizza)et).setId(ctl(vl)), "id");
        setupEpg(_epgMap, et -> ((Pizza)et).getName(), (et, vl) -> ((Pizza)et).setName((String)vl), "name");
        setupEpg(_epgMap, et -> ((Pizza)et).getPrice(), (et, vl) -> ((Pizza)et).setPrice(ctb(vl)), "price");
        setupEpg(_epgMap, et -> ((Pizza)et).getBaseId(), (et, vl) -> ((Pizza)et).setBaseId(ctl(vl)), "baseId");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((Pizza)et).getBase(), (et, vl) -> ((Pizza)et).setBase((OptionalEntity<Base>)vl), "base");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PIZZA";
    protected final String _tableDispName = "PIZZA";
    protected final String _tablePropertyName = "pizza";
    protected final TableSqlName _tableSqlName = new TableSqlName("PIZZA", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("ID", "ID", null, null, Long.class, "id", null, true, true, true, "BIGINT", 19, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_D4B9D890_E68B_4359_BAC4_49DF061BD1B1", false, null, null, null, "pizzaToppingsList", null, false);
    protected final ColumnInfo _columnName = cci("NAME", "NAME", null, null, String.class, "name", null, false, false, false, "VARCHAR", 255, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnPrice = cci("PRICE", "PRICE", null, null, java.math.BigDecimal.class, "price", null, false, false, false, "DECIMAL", 19, 2, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnBaseId = cci("BASE_ID", "BASE_ID", null, null, Long.class, "baseId", null, false, false, true, "BIGINT", 19, 0, null, false, null, null, "base", null, null, false);

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
    /**
     * PRICE: {DECIMAL(19, 2)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPrice() { return _columnPrice; }
    /**
     * BASE_ID: {IX, NotNull, BIGINT(19), FK to BASE}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBaseId() { return _columnBaseId; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnName());
        ls.add(columnPrice());
        ls.add(columnBaseId());
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
    /**
     * BASE by my BASE_ID, named 'base'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignBase() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnBaseId(), BaseDbm.getInstance().columnId());
        return cfi("FKM6KAI6C5EVR38DUYFH06UE29U", "base", this, BaseDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "pizzaList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * PIZZA_TOPPINGS by PIZZA_ID, named 'pizzaToppingsList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerPizzaToppingsList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnId(), PizzaToppingsDbm.getInstance().columnPizzaId());
        return cri("FK78L5QTFERC9QHFKKGYV99LMST", "pizzaToppingsList", this, PizzaToppingsDbm.getInstance(), mp, false, "pizza");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.exentity.Pizza"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.cbean.PizzaCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.exbhv.PizzaBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Pizza> getEntityType() { return Pizza.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Pizza newEntity() { return new Pizza(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Pizza)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Pizza)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
