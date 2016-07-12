package com.example.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.example.dbflute.exbhv.*;
import com.example.dbflute.exentity.*;
import com.example.dbflute.cbean.*;

/**
 * The referrer loader of TOPPING as TABLE. <br>
 * <pre>
 * [primary key]
 *     ID
 *
 * [column]
 *     ID, NAME
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
 *     
 *
 * [referrer table]
 *     PIZZA_TOPPINGS
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     pizzaToppingsList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfTopping {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Topping> _selectedList;
    protected BehaviorSelector _selector;
    protected ToppingBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfTopping ready(List<Topping> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected ToppingBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(ToppingBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<PizzaToppings> _referrerPizzaToppings;

    /**
     * Load referrer of pizzaToppingsList by the set-upper of referrer. <br>
     * PIZZA_TOPPINGS by TOPPINGS_ID, named 'pizzaToppingsList'.
     * <pre>
     * <span style="color: #0000C0">toppingBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">toppingList</span>, <span style="color: #553000">toppingLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">toppingLoader</span>.<span style="color: #CC4747">loadPizzaToppings</span>(<span style="color: #553000">toppingsCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">toppingsCB</span>.setupSelect...
     *         <span style="color: #553000">toppingsCB</span>.query().set...
     *         <span style="color: #553000">toppingsCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">toppingsLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    toppingsLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Topping topping : <span style="color: #553000">toppingList</span>) {
     *     ... = topping.<span style="color: #CC4747">getPizzaToppingsList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setToppingsId_InScope(pkList);
     * cb.query().addOrderBy_ToppingsId_Asc();
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
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Topping> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
