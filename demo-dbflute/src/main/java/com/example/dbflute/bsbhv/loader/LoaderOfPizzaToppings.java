package com.example.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.example.dbflute.exbhv.*;
import com.example.dbflute.exentity.*;

/**
 * The referrer loader of PIZZA_TOPPINGS as TABLE. <br>
 * <pre>
 * [primary key]
 *     PIZZA_ID, TOPPINGS_ID
 *
 * [column]
 *     PIZZA_ID, TOPPINGS_ID
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     PIZZA, TOPPING
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     pizza, topping
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfPizzaToppings {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<PizzaToppings> _selectedList;
    protected BehaviorSelector _selector;
    protected PizzaToppingsBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfPizzaToppings ready(List<PizzaToppings> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected PizzaToppingsBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(PizzaToppingsBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfPizza _foreignPizzaLoader;
    public LoaderOfPizza pulloutPizza() {
        if (_foreignPizzaLoader == null)
        { _foreignPizzaLoader = new LoaderOfPizza().ready(myBhv().pulloutPizza(_selectedList), _selector); }
        return _foreignPizzaLoader;
    }

    protected LoaderOfTopping _foreignToppingLoader;
    public LoaderOfTopping pulloutTopping() {
        if (_foreignToppingLoader == null)
        { _foreignToppingLoader = new LoaderOfTopping().ready(myBhv().pulloutTopping(_selectedList), _selector); }
        return _foreignToppingLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<PizzaToppings> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
