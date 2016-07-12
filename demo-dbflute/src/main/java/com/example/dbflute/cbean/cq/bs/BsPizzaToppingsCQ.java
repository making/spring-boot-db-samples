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
 * The base condition-query of PIZZA_TOPPINGS.
 * @author DBFlute(AutoGenerator)
 */
public class BsPizzaToppingsCQ extends AbstractBsPizzaToppingsCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PizzaToppingsCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPizzaToppingsCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from PIZZA_TOPPINGS) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public PizzaToppingsCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected PizzaToppingsCIQ xcreateCIQ() {
        PizzaToppingsCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected PizzaToppingsCIQ xnewCIQ() {
        return new PizzaToppingsCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join PIZZA_TOPPINGS on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public PizzaToppingsCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        PizzaToppingsCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _pizzaId;
    public ConditionValue xdfgetPizzaId()
    { if (_pizzaId == null) { _pizzaId = nCV(); }
      return _pizzaId; }
    protected ConditionValue xgetCValuePizzaId() { return xdfgetPizzaId(); }

    /** 
     * Add order-by as ascend. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @return this. (NotNull)
     */
    public BsPizzaToppingsCQ addOrderBy_PizzaId_Asc() { regOBA("PIZZA_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @return this. (NotNull)
     */
    public BsPizzaToppingsCQ addOrderBy_PizzaId_Desc() { regOBD("PIZZA_ID"); return this; }

    protected ConditionValue _toppingsId;
    public ConditionValue xdfgetToppingsId()
    { if (_toppingsId == null) { _toppingsId = nCV(); }
      return _toppingsId; }
    protected ConditionValue xgetCValueToppingsId() { return xdfgetToppingsId(); }

    /** 
     * Add order-by as ascend. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @return this. (NotNull)
     */
    public BsPizzaToppingsCQ addOrderBy_ToppingsId_Asc() { regOBA("TOPPINGS_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @return this. (NotNull)
     */
    public BsPizzaToppingsCQ addOrderBy_ToppingsId_Desc() { regOBD("TOPPINGS_ID"); return this; }

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
    public BsPizzaToppingsCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsPizzaToppingsCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        PizzaToppingsCQ bq = (PizzaToppingsCQ)bqs;
        PizzaToppingsCQ uq = (PizzaToppingsCQ)uqs;
        if (bq.hasConditionQueryPizza()) {
            uq.queryPizza().reflectRelationOnUnionQuery(bq.queryPizza(), uq.queryPizza());
        }
        if (bq.hasConditionQueryTopping()) {
            uq.queryTopping().reflectRelationOnUnionQuery(bq.queryTopping(), uq.queryTopping());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * PIZZA by my PIZZA_ID, named 'pizza'.
     * @return The instance of condition-query. (NotNull)
     */
    public PizzaCQ queryPizza() {
        return xdfgetConditionQueryPizza();
    }
    public PizzaCQ xdfgetConditionQueryPizza() {
        String prop = "pizza";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryPizza()); xsetupOuterJoinPizza(); }
        return xgetQueRlMap(prop);
    }
    protected PizzaCQ xcreateQueryPizza() {
        String nrp = xresolveNRP("PIZZA_TOPPINGS", "pizza"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new PizzaCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "pizza", nrp);
    }
    protected void xsetupOuterJoinPizza() { xregOutJo("pizza"); }
    public boolean hasConditionQueryPizza() { return xhasQueRlMap("pizza"); }

    /**
     * Get the condition-query for relation table. <br>
     * TOPPING by my TOPPINGS_ID, named 'topping'.
     * @return The instance of condition-query. (NotNull)
     */
    public ToppingCQ queryTopping() {
        return xdfgetConditionQueryTopping();
    }
    public ToppingCQ xdfgetConditionQueryTopping() {
        String prop = "topping";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryTopping()); xsetupOuterJoinTopping(); }
        return xgetQueRlMap(prop);
    }
    protected ToppingCQ xcreateQueryTopping() {
        String nrp = xresolveNRP("PIZZA_TOPPINGS", "topping"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new ToppingCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "topping", nrp);
    }
    protected void xsetupOuterJoinTopping() { xregOutJo("topping"); }
    public boolean hasConditionQueryTopping() { return xhasQueRlMap("topping"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, PizzaToppingsCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(PizzaToppingsCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return PizzaToppingsCB.class.getName(); }
    protected String xCQ() { return PizzaToppingsCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
