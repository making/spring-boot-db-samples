package com.example.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.allcommon.*;
import com.example.dbflute.cbean.*;
import com.example.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of PIZZA_TOPPINGS.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsPizzaToppingsCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsPizzaToppingsCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "PIZZA_TOPPINGS";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaId The value of pizzaId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setPizzaId_Equal(Long pizzaId) {
        doSetPizzaId_Equal(pizzaId);
    }

    protected void doSetPizzaId_Equal(Long pizzaId) {
        regPizzaId(CK_EQ, pizzaId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaId The value of pizzaId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPizzaId_NotEqual(Long pizzaId) {
        doSetPizzaId_NotEqual(pizzaId);
    }

    protected void doSetPizzaId_NotEqual(Long pizzaId) {
        regPizzaId(CK_NES, pizzaId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaId The value of pizzaId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPizzaId_GreaterThan(Long pizzaId) {
        regPizzaId(CK_GT, pizzaId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaId The value of pizzaId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPizzaId_LessThan(Long pizzaId) {
        regPizzaId(CK_LT, pizzaId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaId The value of pizzaId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPizzaId_GreaterEqual(Long pizzaId) {
        regPizzaId(CK_GE, pizzaId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaId The value of pizzaId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPizzaId_LessEqual(Long pizzaId) {
        regPizzaId(CK_LE, pizzaId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param minNumber The min number of pizzaId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of pizzaId. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setPizzaId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setPizzaId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param minNumber The min number of pizzaId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of pizzaId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setPizzaId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValuePizzaId(), "PIZZA_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaIdList The collection of pizzaId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setPizzaId_InScope(Collection<Long> pizzaIdList) {
        doSetPizzaId_InScope(pizzaIdList);
    }

    protected void doSetPizzaId_InScope(Collection<Long> pizzaIdList) {
        regINS(CK_INS, cTL(pizzaIdList), xgetCValuePizzaId(), "PIZZA_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     * @param pizzaIdList The collection of pizzaId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setPizzaId_NotInScope(Collection<Long> pizzaIdList) {
        doSetPizzaId_NotInScope(pizzaIdList);
    }

    protected void doSetPizzaId_NotInScope(Collection<Long> pizzaIdList) {
        regINS(CK_NINS, cTL(pizzaIdList), xgetCValuePizzaId(), "PIZZA_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     */
    public void setPizzaId_IsNull() { regPizzaId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA}
     */
    public void setPizzaId_IsNotNull() { regPizzaId(CK_ISNN, DOBJ); }

    protected void regPizzaId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValuePizzaId(), "PIZZA_ID"); }
    protected abstract ConditionValue xgetCValuePizzaId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsId The value of toppingsId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setToppingsId_Equal(Long toppingsId) {
        doSetToppingsId_Equal(toppingsId);
    }

    protected void doSetToppingsId_Equal(Long toppingsId) {
        regToppingsId(CK_EQ, toppingsId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsId The value of toppingsId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setToppingsId_NotEqual(Long toppingsId) {
        doSetToppingsId_NotEqual(toppingsId);
    }

    protected void doSetToppingsId_NotEqual(Long toppingsId) {
        regToppingsId(CK_NES, toppingsId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsId The value of toppingsId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setToppingsId_GreaterThan(Long toppingsId) {
        regToppingsId(CK_GT, toppingsId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsId The value of toppingsId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setToppingsId_LessThan(Long toppingsId) {
        regToppingsId(CK_LT, toppingsId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsId The value of toppingsId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setToppingsId_GreaterEqual(Long toppingsId) {
        regToppingsId(CK_GE, toppingsId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsId The value of toppingsId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setToppingsId_LessEqual(Long toppingsId) {
        regToppingsId(CK_LE, toppingsId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param minNumber The min number of toppingsId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of toppingsId. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setToppingsId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setToppingsId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param minNumber The min number of toppingsId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of toppingsId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setToppingsId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueToppingsId(), "TOPPINGS_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsIdList The collection of toppingsId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setToppingsId_InScope(Collection<Long> toppingsIdList) {
        doSetToppingsId_InScope(toppingsIdList);
    }

    protected void doSetToppingsId_InScope(Collection<Long> toppingsIdList) {
        regINS(CK_INS, cTL(toppingsIdList), xgetCValueToppingsId(), "TOPPINGS_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     * @param toppingsIdList The collection of toppingsId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setToppingsId_NotInScope(Collection<Long> toppingsIdList) {
        doSetToppingsId_NotInScope(toppingsIdList);
    }

    protected void doSetToppingsId_NotInScope(Collection<Long> toppingsIdList) {
        regINS(CK_NINS, cTL(toppingsIdList), xgetCValueToppingsId(), "TOPPINGS_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     */
    public void setToppingsId_IsNull() { regToppingsId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING}
     */
    public void setToppingsId_IsNotNull() { regToppingsId(CK_ISNN, DOBJ); }

    protected void regToppingsId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueToppingsId(), "TOPPINGS_ID"); }
    protected abstract ConditionValue xgetCValueToppingsId();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PizzaToppingsCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, PizzaToppingsCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PizzaToppingsCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, PizzaToppingsCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PizzaToppingsCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, PizzaToppingsCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PizzaToppingsCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, PizzaToppingsCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PizzaToppingsCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, PizzaToppingsCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;PizzaToppingsCB&gt;() {
     *     public void query(PizzaToppingsCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PizzaToppingsCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, PizzaToppingsCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        PizzaToppingsCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(PizzaToppingsCQ sq);

    protected PizzaToppingsCB xcreateScalarConditionCB() {
        PizzaToppingsCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected PizzaToppingsCB xcreateScalarConditionPartitionByCB() {
        PizzaToppingsCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected PizzaToppingsCB newMyCB() {
        return new PizzaToppingsCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return PizzaToppingsCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
