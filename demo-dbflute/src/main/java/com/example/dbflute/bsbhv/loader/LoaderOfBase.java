package com.example.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.example.dbflute.exbhv.*;
import com.example.dbflute.exentity.*;
import com.example.dbflute.cbean.*;

/**
 * The referrer loader of BASE as TABLE. <br>
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
 *     PIZZA
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     pizzaList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfBase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Base> _selectedList;
    protected BehaviorSelector _selector;
    protected BaseBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfBase ready(List<Base> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected BaseBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(BaseBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Pizza> _referrerPizza;

    /**
     * Load referrer of pizzaList by the set-upper of referrer. <br>
     * PIZZA by BASE_ID, named 'pizzaList'.
     * <pre>
     * <span style="color: #0000C0">baseBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">baseList</span>, <span style="color: #553000">baseLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">baseLoader</span>.<span style="color: #CC4747">loadPizza</span>(<span style="color: #553000">pizzaCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">pizzaCB</span>.setupSelect...
     *         <span style="color: #553000">pizzaCB</span>.query().set...
     *         <span style="color: #553000">pizzaCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">pizzaLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    pizzaLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Base base : <span style="color: #553000">baseList</span>) {
     *     ... = base.<span style="color: #CC4747">getPizzaList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setBaseId_InScope(pkList);
     * cb.query().addOrderBy_BaseId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfPizza> loadPizza(ReferrerConditionSetupper<PizzaCB> refCBLambda) {
        myBhv().loadPizza(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerPizza = refLs);
        return hd -> hd.handle(new LoaderOfPizza().ready(_referrerPizza, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Base> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
