package com.example.dbflute.allcommon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dbflute.dbway.DBDef;

/**
 * @author DBFlute(AutoGenerator)
 */
public class DBCurrent {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The logger instance for this class. (NotNull) */
    private static final Logger _log = LoggerFactory.getLogger(DBCurrent.class);

    /** Singleton instance. */
    private static final DBCurrent _instance = new DBCurrent();

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final String _projectName = "pizzadb";
    protected final String _projectPrefix = "";
    protected final String _generationGapBasePrefix = "Bs";

    protected DBDef _currentDBDef;
    {
        _currentDBDef = DBDef.codeOf("h2");
        if (_currentDBDef == null) {
            _currentDBDef = DBDef.Unknown;
        }
    }
	
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     */
    private DBCurrent() {
    }

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    /**
     * Get singleton instance.
     * @return Singleton instance. (NotNull)
     */
    public static DBCurrent getInstance() {
        return _instance;
    }

    // ===================================================================================
    //                                                                        Project Name
    //                                                                        ============
    /**
     * Get project name of the database (DBFlute client).
     * @return The name string, lower case in many cases. e.g. maihamadb (NotNull)
     */
    public String projectName() {
        return _projectName;
    }

    /**
     * Get project prefix of the database, used as class name. (normally empty)
     * Normally empty string, only when prejextPrefix is set in basicInfoMap.dfprop.
     * @return The prefix string, camel case in many cases. e.g. Resola (ResolaStationCB) (NotNull, EmptyAllowed)
     */
    public String projectPrefix() {
        return _projectPrefix;
    }

    /**
     * Get base prefix of the database for generation gap. (normally 'Bs')
     * @return The prefix string, camel case in many cases. e.g. Bs (BsMemberCB) (NotNull, EmptyAllowed)
     */
    public String generationGapBasePrefix() {
        return _generationGapBasePrefix;
    }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public void initializeCurrentDBDef(DBDef currentDBDef) {
	    if (_log.isInfoEnabled()) {
		    _log.info("...Setting currentDBDef: " + currentDBDef);
		}
		if (currentDBDef == null) {
		    String msg = "The argument 'currentDBDef' should not be null!";
		    throw new IllegalArgumentException(msg);
		}
        _currentDBDef = currentDBDef;
    }

    /**
     * Get current DB definition saved in this object.
     * @return The object of DB definition. (NotNull)
     */
    public DBDef currentDBDef() {
        return _currentDBDef;
    }

    /**
     * Is the current DB specified DB?
     * @param currentDBDef The DB definition of current DB. (NullAllowed: if null, returns false)
     * @return The determination, true or false.
     */
    public boolean isCurrentDBDef(DBDef currentDBDef) {
	    return _currentDBDef.equals(currentDBDef);
    }
}
