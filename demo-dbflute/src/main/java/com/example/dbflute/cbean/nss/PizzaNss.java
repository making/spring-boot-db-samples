package com.example.dbflute.cbean.nss;

import com.example.dbflute.cbean.cq.PizzaCQ;

/**
 * The nest select set-upper of PIZZA.
 * @author DBFlute(AutoGenerator)
 */
public class PizzaNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final PizzaCQ _query;
    public PizzaNss(PizzaCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * BASE by my BASE_ID, named 'base'.
     */
    public void withBase() {
        _query.xdoNss(() -> _query.queryBase());
    }
}
