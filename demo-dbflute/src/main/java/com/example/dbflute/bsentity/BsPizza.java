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
 * The entity of PIZZA as TABLE. <br>
 * <pre>
 * [primary-key]
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long id = entity.getId();
 * String name = entity.getName();
 * java.math.BigDecimal price = entity.getPrice();
 * Long baseId = entity.getBaseId();
 * entity.setId(id);
 * entity.setName(name);
 * entity.setPrice(price);
 * entity.setBaseId(baseId);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPizza extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _id;

    /** NAME: {VARCHAR(255)} */
    protected String _name;

    /** PRICE: {DECIMAL(19, 2)} */
    protected java.math.BigDecimal _price;

    /** BASE_ID: {IX, BIGINT(19), FK to BASE} */
    protected Long _baseId;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "PIZZA";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_id == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** BASE by my BASE_ID, named 'base'. */
    protected OptionalEntity<Base> _base;

    /**
     * [get] BASE by my BASE_ID, named 'base'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'base'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Base> getBase() {
        if (_base == null) { _base = OptionalEntity.relationEmpty(this, "base"); }
        return _base;
    }

    /**
     * [set] BASE by my BASE_ID, named 'base'.
     * @param base The entity of foreign property 'base'. (NullAllowed)
     */
    public void setBase(OptionalEntity<Base> base) {
        _base = base;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** PIZZA_TOPPINGS by PIZZA_ID, named 'pizzaToppingsList'. */
    protected List<PizzaToppings> _pizzaToppingsList;

    /**
     * [get] PIZZA_TOPPINGS by PIZZA_ID, named 'pizzaToppingsList'.
     * @return The entity list of referrer property 'pizzaToppingsList'. (NotNull: even if no loading, returns empty list)
     */
    public List<PizzaToppings> getPizzaToppingsList() {
        if (_pizzaToppingsList == null) { _pizzaToppingsList = newReferrerList(); }
        return _pizzaToppingsList;
    }

    /**
     * [set] PIZZA_TOPPINGS by PIZZA_ID, named 'pizzaToppingsList'.
     * @param pizzaToppingsList The entity list of referrer property 'pizzaToppingsList'. (NullAllowed)
     */
    public void setPizzaToppingsList(List<PizzaToppings> pizzaToppingsList) {
        _pizzaToppingsList = pizzaToppingsList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsPizza) {
            BsPizza other = (BsPizza)obj;
            if (!xSV(_id, other._id)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _id);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_base != null && _base.isPresent())
        { sb.append(li).append(xbRDS(_base, "base")); }
        if (_pizzaToppingsList != null) { for (PizzaToppings et : _pizzaToppingsList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "pizzaToppingsList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_id));
        sb.append(dm).append(xfND(_name));
        sb.append(dm).append(xfND(_price));
        sb.append(dm).append(xfND(_baseId));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_base != null && _base.isPresent())
        { sb.append(dm).append("base"); }
        if (_pizzaToppingsList != null && !_pizzaToppingsList.isEmpty())
        { sb.append(dm).append("pizzaToppingsList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Pizza clone() {
        return (Pizza)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @return The value of the column 'ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getId() {
        checkSpecifiedProperty("id");
        return _id;
    }

    /**
     * [set] ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @param id The value of the column 'ID'. (basically NotNull if update: for the constraint)
     */
    public void setId(Long id) {
        registerModifiedProperty("id");
        _id = id;
    }

    /**
     * [get] NAME: {VARCHAR(255)} <br>
     * @return The value of the column 'NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getName() {
        checkSpecifiedProperty("name");
        return _name;
    }

    /**
     * [set] NAME: {VARCHAR(255)} <br>
     * @param name The value of the column 'NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setName(String name) {
        registerModifiedProperty("name");
        _name = name;
    }

    /**
     * [get] PRICE: {DECIMAL(19, 2)} <br>
     * @return The value of the column 'PRICE'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getPrice() {
        checkSpecifiedProperty("price");
        return _price;
    }

    /**
     * [set] PRICE: {DECIMAL(19, 2)} <br>
     * @param price The value of the column 'PRICE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPrice(java.math.BigDecimal price) {
        registerModifiedProperty("price");
        _price = price;
    }

    /**
     * [get] BASE_ID: {IX, BIGINT(19), FK to BASE} <br>
     * @return The value of the column 'BASE_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Long getBaseId() {
        checkSpecifiedProperty("baseId");
        return _baseId;
    }

    /**
     * [set] BASE_ID: {IX, BIGINT(19), FK to BASE} <br>
     * @param baseId The value of the column 'BASE_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setBaseId(Long baseId) {
        registerModifiedProperty("baseId");
        _baseId = baseId;
    }
}
