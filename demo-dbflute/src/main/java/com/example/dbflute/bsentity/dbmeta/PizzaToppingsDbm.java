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
 * The DB meta of PIZZA_TOPPINGS. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PizzaToppingsDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PizzaToppingsDbm _instance = new PizzaToppingsDbm();
    private PizzaToppingsDbm() {}
    public static PizzaToppingsDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((PizzaToppings)et).getPizzaId(), (et, vl) -> ((PizzaToppings)et).setPizzaId(ctl(vl)), "pizzaId");
        setupEpg(_epgMap, et -> ((PizzaToppings)et).getToppingsId(), (et, vl) -> ((PizzaToppings)et).setToppingsId(ctl(vl)), "toppingsId");
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
        setupEfpg(_efpgMap, et -> ((PizzaToppings)et).getPizza(), (et, vl) -> ((PizzaToppings)et).setPizza((OptionalEntity<Pizza>)vl), "pizza");
        setupEfpg(_efpgMap, et -> ((PizzaToppings)et).getTopping(), (et, vl) -> ((PizzaToppings)et).setTopping((OptionalEntity<Topping>)vl), "topping");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PIZZA_TOPPINGS";
    protected final String _tableDispName = "PIZZA_TOPPINGS";
    protected final String _tablePropertyName = "pizzaToppings";
    protected final TableSqlName _tableSqlName = new TableSqlName("PIZZA_TOPPINGS", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPizzaId = cci("PIZZA_ID", "PIZZA_ID", null, null, Long.class, "pizzaId", null, true, false, true, "BIGINT", 19, 0, null, false, null, null, "pizza", null, null, false);
    protected final ColumnInfo _columnToppingsId = cci("TOPPINGS_ID", "TOPPINGS_ID", null, null, Long.class, "toppingsId", null, true, false, true, "BIGINT", 19, 0, null, false, null, null, "topping", null, null, false);

    /**
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPizzaId() { return _columnPizzaId; }
    /**
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnToppingsId() { return _columnToppingsId; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnPizzaId());
        ls.add(columnToppingsId());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnPizzaId());
        ls.add(columnToppingsId());
        return hpcpui(ls);
    }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return true; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * PIZZA by my PIZZA_ID, named 'pizza'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignPizza() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnPizzaId(), PizzaDbm.getInstance().columnId());
        return cfi("FK78L5QTFERC9QHFKKGYV99LMST", "pizza", this, PizzaDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "pizzaToppingsList", false);
    }
    /**
     * TOPPING by my TOPPINGS_ID, named 'topping'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignTopping() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnToppingsId(), ToppingDbm.getInstance().columnId());
        return cfi("FK7TCTI2CXAU3CSVBUWXN0SCB93", "topping", this, ToppingDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "pizzaToppingsList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.exentity.PizzaToppings"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.cbean.PizzaToppingsCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.exbhv.PizzaToppingsBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<PizzaToppings> getEntityType() { return PizzaToppings.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public PizzaToppings newEntity() { return new PizzaToppings(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((PizzaToppings)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((PizzaToppings)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
