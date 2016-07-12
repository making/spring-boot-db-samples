package com.example.dbflute.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.cbean.cq.ciq.*;
import com.example.dbflute.cbean.*;
import com.example.dbflute.cbean.cq.*;

/**
 * The base condition-query of PIZZA.
 * @author DBFlute(AutoGenerator)
 */
public class BsPizzaCQ extends AbstractBsPizzaCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PizzaCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPizzaCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from PIZZA) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public PizzaCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected PizzaCIQ xcreateCIQ() {
        PizzaCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected PizzaCIQ xnewCIQ() {
        return new PizzaCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join PIZZA on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public PizzaCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        PizzaCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _id;
    public ConditionValue xdfgetId()
    { if (_id == null) { _id = nCV(); }
      return _id; }
    protected ConditionValue xgetCValueId() { return xdfgetId(); }

    public Map<String, PizzaToppingsCQ> xdfgetId_ExistsReferrer_PizzaToppingsList() { return xgetSQueMap("id_ExistsReferrer_PizzaToppingsList"); }
    public String keepId_ExistsReferrer_PizzaToppingsList(PizzaToppingsCQ sq) { return xkeepSQue("id_ExistsReferrer_PizzaToppingsList", sq); }

    public Map<String, PizzaToppingsCQ> xdfgetId_NotExistsReferrer_PizzaToppingsList() { return xgetSQueMap("id_NotExistsReferrer_PizzaToppingsList"); }
    public String keepId_NotExistsReferrer_PizzaToppingsList(PizzaToppingsCQ sq) { return xkeepSQue("id_NotExistsReferrer_PizzaToppingsList", sq); }

    public Map<String, PizzaToppingsCQ> xdfgetId_SpecifyDerivedReferrer_PizzaToppingsList() { return xgetSQueMap("id_SpecifyDerivedReferrer_PizzaToppingsList"); }
    public String keepId_SpecifyDerivedReferrer_PizzaToppingsList(PizzaToppingsCQ sq) { return xkeepSQue("id_SpecifyDerivedReferrer_PizzaToppingsList", sq); }

    public Map<String, PizzaToppingsCQ> xdfgetId_QueryDerivedReferrer_PizzaToppingsList() { return xgetSQueMap("id_QueryDerivedReferrer_PizzaToppingsList"); }
    public String keepId_QueryDerivedReferrer_PizzaToppingsList(PizzaToppingsCQ sq) { return xkeepSQue("id_QueryDerivedReferrer_PizzaToppingsList", sq); }
    public Map<String, Object> xdfgetId_QueryDerivedReferrer_PizzaToppingsListParameter() { return xgetSQuePmMap("id_QueryDerivedReferrer_PizzaToppingsList"); }
    public String keepId_QueryDerivedReferrer_PizzaToppingsListParameter(Object pm) { return xkeepSQuePm("id_QueryDerivedReferrer_PizzaToppingsList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_Id_Asc() { regOBA("ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_Id_Desc() { regOBD("ID"); return this; }

    protected ConditionValue _name;
    public ConditionValue xdfgetName()
    { if (_name == null) { _name = nCV(); }
      return _name; }
    protected ConditionValue xgetCValueName() { return xdfgetName(); }

    /** 
     * Add order-by as ascend. <br>
     * NAME: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_Name_Asc() { regOBA("NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * NAME: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_Name_Desc() { regOBD("NAME"); return this; }

    protected ConditionValue _price;
    public ConditionValue xdfgetPrice()
    { if (_price == null) { _price = nCV(); }
      return _price; }
    protected ConditionValue xgetCValuePrice() { return xdfgetPrice(); }

    /** 
     * Add order-by as ascend. <br>
     * PRICE: {DECIMAL(19, 2)}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_Price_Asc() { regOBA("PRICE"); return this; }

    /**
     * Add order-by as descend. <br>
     * PRICE: {DECIMAL(19, 2)}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_Price_Desc() { regOBD("PRICE"); return this; }

    protected ConditionValue _baseId;
    public ConditionValue xdfgetBaseId()
    { if (_baseId == null) { _baseId = nCV(); }
      return _baseId; }
    protected ConditionValue xgetCValueBaseId() { return xdfgetBaseId(); }

    /** 
     * Add order-by as ascend. <br>
     * BASE_ID: {IX, NotNull, BIGINT(19), FK to BASE}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_BaseId_Asc() { regOBA("BASE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * BASE_ID: {IX, NotNull, BIGINT(19), FK to BASE}
     * @return this. (NotNull)
     */
    public BsPizzaCQ addOrderBy_BaseId_Desc() { regOBD("BASE_ID"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsPizzaCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsPizzaCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        PizzaCQ bq = (PizzaCQ)bqs;
        PizzaCQ uq = (PizzaCQ)uqs;
        if (bq.hasConditionQueryBase()) {
            uq.queryBase().reflectRelationOnUnionQuery(bq.queryBase(), uq.queryBase());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * BASE by my BASE_ID, named 'base'.
     * @return The instance of condition-query. (NotNull)
     */
    public BaseCQ queryBase() {
        return xdfgetConditionQueryBase();
    }
    public BaseCQ xdfgetConditionQueryBase() {
        String prop = "base";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryBase()); xsetupOuterJoinBase(); }
        return xgetQueRlMap(prop);
    }
    protected BaseCQ xcreateQueryBase() {
        String nrp = xresolveNRP("PIZZA", "base"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new BaseCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "base", nrp);
    }
    protected void xsetupOuterJoinBase() { xregOutJo("base"); }
    public boolean hasConditionQueryBase() { return xhasQueRlMap("base"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, PizzaCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(PizzaCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, PizzaCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(PizzaCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, PizzaCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(PizzaCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, PizzaCQ> _myselfExistsMap;
    public Map<String, PizzaCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(PizzaCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, PizzaCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(PizzaCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return PizzaCB.class.getName(); }
    protected String xCQ() { return PizzaCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
