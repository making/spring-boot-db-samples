package com.example.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.example.dbflute.exbhv.*;
import com.example.dbflute.exentity.*;
import com.example.dbflute.cbean.*;

/**
 * The referrer loader of PIZZA as TABLE. <br>
 * <pre>
 * [primary key]
 *     ID
 *
 * [column]
 *     ID, NAME, PRICE, BASE_ID
 *
 * [sequence]
 *     
 *
 * [identity]
 *     ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     BASE
 *
 * [referrer table]
 *     PIZZA_TOPPINGS
 *
 * [foreign property]
 *     base
 *
 * [referrer property]
 *     pizzaToppingsList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfPizza {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Pizza> _selectedList;
    protected BehaviorSelector _selector;
    protected PizzaBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfPizza ready(List<Pizza> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected PizzaBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(PizzaBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<PizzaToppings> _referrerPizzaToppings;

    /**
     * Load referrer of pizzaToppingsList by the set-upper of referrer. <br>
     * PIZZA_TOPPINGS by PIZZA_ID, named 'pizzaToppingsList'.
     * <pre>
     * <span style="color: #0000C0">pizzaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">pizzaList</span>, <span style="color: #553000">pizzaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">pizzaLoader</span>.<span style="color: #CC4747">loadPizzaToppings</span>(<span style="color: #553000">toppingsCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">toppingsCB</span>.setupSelect...
     *         <span style="color: #553000">toppingsCB</span>.query().set...
     *         <span style="color: #553000">toppingsCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">toppingsLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    toppingsLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Pizza pizza : <span style="color: #553000">pizzaList</span>) {
     *     ... = pizza.<span style="color: #CC4747">getPizzaToppingsList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setPizzaId_InScope(pkList);
     * cb.query().addOrderBy_PizzaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfPizzaToppings> loadPizzaToppings(ReferrerConditionSetupper<PizzaToppingsCB> refCBLambda) {
        myBhv().loadPizzaToppings(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerPizzaToppings = refLs);
        return hd -> hd.handle(new LoaderOfPizzaToppings().ready(_referrerPizzaToppings, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfBase _foreignBaseLoader;
    public LoaderOfBase pulloutBase() {
        if (_foreignBaseLoader == null)
        { _foreignBaseLoader = new LoaderOfBase().ready(myBhv().pulloutBase(_selectedList), _selector); }
        return _foreignBaseLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Pizza> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
