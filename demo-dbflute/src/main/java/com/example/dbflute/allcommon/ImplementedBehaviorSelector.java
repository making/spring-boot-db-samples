package com.example.dbflute.allcommon;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dbflute.bhv.BehaviorReadable;
import org.dbflute.bhv.BehaviorSelector;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.exception.IllegalBehaviorStateException;
import org.dbflute.util.DfTraceViewUtil;
import org.dbflute.util.DfTypeUtil;
import org.dbflute.util.Srl;

import org.springframework.context.ApplicationContext;

/**
 * The implementation of behavior selector.
 * @author DBFlute(AutoGenerator)
 */
public class ImplementedBehaviorSelector implements BehaviorSelector {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The logger instance for this class. (NotNull) */
    private static final Logger _log = LoggerFactory.getLogger(ImplementedBehaviorSelector.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The concurrent cache of behavior. */
    protected final Map<Class<? extends BehaviorReadable>, BehaviorReadable> _behaviorCache = newConcurrentHashMap();

    /** The container of Spring. */
    protected ApplicationContext _container;

    // ===================================================================================
    //                                                                          Initialize
    //                                                                          ==========
    /**
     * Initialize condition-bean meta data.
     */
    public void initializeConditionBeanMetaData() {
        final Map<String, DBMeta> dbmetaMap = DBMetaInstanceHandler.getUnmodifiableDBMetaMap();
        final Collection<DBMeta> dbmetas = dbmetaMap.values();
        long before = 0;
        if (_log.isInfoEnabled()) {
            before = System.currentTimeMillis();
            _log.info("...Initializing condition-bean meta data");
        }
        int count = 0;
        for (DBMeta dbmeta : dbmetas) {
            try {
                final BehaviorReadable bhv = byName(dbmeta.getTableDbName());
                bhv.warmUpCommand();
                ++count;
            } catch (IllegalBehaviorStateException ignored) { // means the behavior is suppressed
                if (_log.isDebugEnabled()) {
                    _log.debug("No behavior for " + dbmeta.getTableDbName());
                }
            }
        }
        if (_log.isInfoEnabled()) {
            long after = System.currentTimeMillis();
            _log.info("CB initialized: " + count + " [" + DfTraceViewUtil.convertToPerformanceView(after - before) + "]");
        }
    }

    // ===================================================================================
    //                                                                            Selector
    //                                                                            ========
    /**
     * Select behavior instance by the type.
     * @param <BEHAVIOR> The type of behavior.
     * @param behaviorType Behavior type. (NotNull)
     * @return The selected instance of the behavior. (NotNull)
     */
    @SuppressWarnings("unchecked")
    public <BEHAVIOR extends BehaviorReadable> BEHAVIOR select(Class<BEHAVIOR> behaviorType) {
        BEHAVIOR bhv = (BEHAVIOR) _behaviorCache.get(behaviorType);
        if (bhv != null) {
            return bhv;
        }
        synchronized (_behaviorCache) {
            bhv = (BEHAVIOR) _behaviorCache.get(behaviorType);
            if (bhv != null) {
                // a previous thread might have initialized
                // or reading might failed by same-time writing
                return bhv;
            }
            bhv = (BEHAVIOR) getComponent(behaviorType);
            _behaviorCache.put(behaviorType, bhv);
            return bhv;
        }
    }

    /**
     * Select behavior (as readable type) by name.
     * @param tableFlexibleName The flexible-name of table. (NotNull)
     * @return The instance of found behavior. (NotNull)
     * @throws org.dbflute.exception.DBMetaNotFoundException When the table is not found.
     * @throws org.dbflute.exception.IllegalBehaviorStateException When the behavior class is suppressed.
     */
    public BehaviorReadable byName(String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName", tableFlexibleName);
        final DBMeta dbmeta = DBMetaInstanceHandler.findDBMeta(tableFlexibleName);
        return select(getBehaviorType(dbmeta));
    }

    /**
     * Get behavior-type by DB meta.
     * @param dbmeta The instance of DB meta for the behavior. (NotNull)
     * @return The type of behavior (as readable type). (NotNull)
     * @throws org.dbflute.exception.IllegalBehaviorStateException When the behavior class is suppressed.
     */
    @SuppressWarnings("unchecked")
    protected Class<BehaviorReadable> getBehaviorType(DBMeta dbmeta) {
        final String behaviorTypeName = dbmeta.getBehaviorTypeName();
        if (behaviorTypeName == null) {
            String msg = "The dbmeta.getBehaviorTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class<BehaviorReadable> behaviorType;
        try {
            behaviorType = (Class<BehaviorReadable>) Class.forName(behaviorTypeName);
        } catch (ClassNotFoundException e) {
            throw new IllegalBehaviorStateException("The class does not exist: " + behaviorTypeName, e);
        }
        return behaviorType;
    }

    // ===================================================================================
    //                                                                           Component
    //                                                                           =========
    protected <COMPONENT> COMPONENT getComponent(Class<COMPONENT> componentType) { // only for behavior
        assertObjectNotNull("componentType", componentType);
        assertObjectNotNull("_container", _container);
		return _container.getBean(componentType);
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected String replace(String str, String fromStr, String toStr) {
        return Srl.replace(str, fromStr, toStr);
    }

    protected String initUncap(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    protected String toClassTitle(Object obj) {
        return DfTypeUtil.toClassTitle(obj);
    }

    protected <KEY, VALUE> ConcurrentHashMap<KEY, VALUE> newConcurrentHashMap() {
        return new ConcurrentHashMap<KEY, VALUE>();
    }

    // ===================================================================================
    //                                                                              Assert
    //                                                                              ======
    // -----------------------------------------------------
    //                                         Assert Object
    //                                         -------------
    /**
     * Assert that the object is not null.
     * @param variableName The variable name for message. (NotNull)
     * @param value The value the checked variable. (NotNull)
     * @throws IllegalArgumentException When the variable name or the variable is null.
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=null value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }

    // -----------------------------------------------------
    //                                         Assert String
    //                                         -------------
    /**
     * Assert that the entity is not null and not trimmed empty.
     * @param variableName The variable name for message. (NotNull)
     * @param value The value the checked variable. (NotNull)
     * @throws IllegalArgumentException When the argument is null or empty.
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        assertObjectNotNull("variableName", variableName);
        assertObjectNotNull("value", value);
        if (value.trim().length() == 0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public void setContainer(ApplicationContext container) {
        this._container = container;
    }
}
