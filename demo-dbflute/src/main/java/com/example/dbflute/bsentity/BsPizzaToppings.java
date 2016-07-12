package com.example.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.example.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.exentity.*;

/**
 * The entity of PIZZA_TOPPINGS as TABLE. <br>
 * <pre>
 * [primary-key]
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long pizzaId = entity.getPizzaId();
 * Long toppingsId = entity.getToppingsId();
 * entity.setPizzaId(pizzaId);
 * entity.setToppingsId(toppingsId);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPizzaToppings extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA} */
    protected Long _pizzaId;

    /** TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING} */
    protected Long _toppingsId;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "PIZZA_TOPPINGS";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_pizzaId == null) { return false; }
        if (_toppingsId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** PIZZA by my PIZZA_ID, named 'pizza'. */
    protected OptionalEntity<Pizza> _pizza;

    /**
     * [get] PIZZA by my PIZZA_ID, named 'pizza'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'pizza'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Pizza> getPizza() {
        if (_pizza == null) { _pizza = OptionalEntity.relationEmpty(this, "pizza"); }
        return _pizza;
    }

    /**
     * [set] PIZZA by my PIZZA_ID, named 'pizza'.
     * @param pizza The entity of foreign property 'pizza'. (NullAllowed)
     */
    public void setPizza(OptionalEntity<Pizza> pizza) {
        _pizza = pizza;
    }

    /** TOPPING by my TOPPINGS_ID, named 'topping'. */
    protected OptionalEntity<Topping> _topping;

    /**
     * [get] TOPPING by my TOPPINGS_ID, named 'topping'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'topping'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Topping> getTopping() {
        if (_topping == null) { _topping = OptionalEntity.relationEmpty(this, "topping"); }
        return _topping;
    }

    /**
     * [set] TOPPING by my TOPPINGS_ID, named 'topping'.
     * @param topping The entity of foreign property 'topping'. (NullAllowed)
     */
    public void setTopping(OptionalEntity<Topping> topping) {
        _topping = topping;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsPizzaToppings) {
            BsPizzaToppings other = (BsPizzaToppings)obj;
            if (!xSV(_pizzaId, other._pizzaId)) { return false; }
            if (!xSV(_toppingsId, other._toppingsId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _pizzaId);
        hs = xCH(hs, _toppingsId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_pizza != null && _pizza.isPresent())
        { sb.append(li).append(xbRDS(_pizza, "pizza")); }
        if (_topping != null && _topping.isPresent())
        { sb.append(li).append(xbRDS(_topping, "topping")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_pizzaId));
        sb.append(dm).append(xfND(_toppingsId));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_pizza != null && _pizza.isPresent())
        { sb.append(dm).append("pizza"); }
        if (_topping != null && _topping.isPresent())
        { sb.append(dm).append("topping"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public PizzaToppings clone() {
        return (PizzaToppings)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA} <br>
     * @return The value of the column 'PIZZA_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getPizzaId() {
        checkSpecifiedProperty("pizzaId");
        return _pizzaId;
    }

    /**
     * [set] PIZZA_ID: {PK, NotNull, BIGINT(19), FK to PIZZA} <br>
     * @param pizzaId The value of the column 'PIZZA_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPizzaId(Long pizzaId) {
        registerModifiedProperty("pizzaId");
        _pizzaId = pizzaId;
    }

    /**
     * [get] TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING} <br>
     * @return The value of the column 'TOPPINGS_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getToppingsId() {
        checkSpecifiedProperty("toppingsId");
        return _toppingsId;
    }

    /**
     * [set] TOPPINGS_ID: {PK, IX, NotNull, BIGINT(19), FK to TOPPING} <br>
     * @param toppingsId The value of the column 'TOPPINGS_ID'. (basically NotNull if update: for the constraint)
     */
    public void setToppingsId(Long toppingsId) {
        registerModifiedProperty("toppingsId");
        _toppingsId = toppingsId;
    }
}
