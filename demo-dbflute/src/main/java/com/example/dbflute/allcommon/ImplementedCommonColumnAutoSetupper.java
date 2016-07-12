package com.example.dbflute.allcommon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.dbflute.Entity;
import org.dbflute.hook.CommonColumnAutoSetupper;

/**
 * The basic implementation of the auto set-upper of common column.
 * @author DBFlute(AutoGenerator)
 */
public class ImplementedCommonColumnAutoSetupper implements CommonColumnAutoSetupper {

    // =====================================================================================
    //                                                                            Definition
    //                                                                            ==========
    /** The logger instance for this class. (NotNull) */
    private static final Logger _log = LoggerFactory.getLogger(ImplementedCommonColumnAutoSetupper.class);

    // =====================================================================================
    //                                                                                Set up
    //                                                                                ======
    /** {@inheritDoc} */
    public void handleCommonColumnOfInsertIfNeeds(Entity targetEntity) {
    }

    /** {@inheritDoc} */
    public void handleCommonColumnOfUpdateIfNeeds(Entity targetEntity) {
    }

    // =====================================================================================
    //                                                                               Logging
    //                                                                               =======
    protected boolean isInternalDebugEnabled() {
        return DBFluteConfig.getInstance().isInternalDebug() && _log.isDebugEnabled();
    }

    protected void logSettingUp(EntityDefinedCommonColumn entity, String keyword) {
        _log.debug("...Setting up column columns of " + entity.asTableDbName() + " before " + keyword);
    }
}
