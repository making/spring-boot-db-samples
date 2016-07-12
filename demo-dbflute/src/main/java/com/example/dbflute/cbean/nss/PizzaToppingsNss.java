package com.example.dbflute.cbean.nss;

import com.example.dbflute.cbean.cq.PizzaToppingsCQ;

/**
 * The nest select set-upper of PIZZA_TOPPINGS.
 * @author DBFlute(AutoGenerator)
 */
public class PizzaToppingsNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final PizzaToppingsCQ _query;
    public PizzaToppingsNss(PizzaToppingsCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * PIZZA by my PIZZA_ID, named 'pizza'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PizzaNss withPizza() {
        _query.xdoNss(() -> _query.queryPizza());
        return new PizzaNss(_query.queryPizza());
    }
    /**
     * With nested relation columns to select clause. <br>
     * TOPPING by my TOPPINGS_ID, named 'topping'.
     */
    public void withTopping() {
        _query.xdoNss(() -> _query.queryTopping());
    }
}
