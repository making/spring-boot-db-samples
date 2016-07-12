package com.example.dbflute.allcommon;

import javax.sql.DataSource;

import org.dbflute.bhv.core.InvokerAssistant;
import org.dbflute.bhv.core.context.ResourceParameter;
import org.dbflute.bhv.core.melodicsql.MelodicSqlAnalyzerFactory;
import org.dbflute.bhv.core.supplement.SequenceCacheHandler;
import org.dbflute.bhv.core.supplement.SequenceCacheKeyGenerator;
import org.dbflute.bhv.exception.BehaviorExceptionThrower;
import org.dbflute.bhv.exception.DefaultSQLExceptionHandlerFactory;
import org.dbflute.bhv.exception.SQLExceptionHandlerFactory;
import org.dbflute.cbean.cipher.GearedCipherManager;
import org.dbflute.cbean.sqlclause.SqlClauseCreator;
import org.dbflute.dbmeta.DBMetaProvider;
import org.dbflute.dbway.DBDef;
import org.dbflute.jdbc.DataSourceHandler;
import org.dbflute.jdbc.HandlingDataSourceWrapper;
import org.dbflute.jdbc.SQLExceptionDigger;
import org.dbflute.jdbc.StatementConfig;
import org.dbflute.jdbc.StatementFactory;
import org.dbflute.optional.RelationOptionalFactory;
import org.dbflute.outsidesql.OutsideSqlOption;
import org.dbflute.outsidesql.factory.DefaultOutsideSqlExecutorFactory;
import org.dbflute.outsidesql.factory.OutsideSqlExecutorFactory;
import org.dbflute.s2dao.extension.TnBeanMetaDataFactoryExtension;
import org.dbflute.s2dao.jdbc.TnResultSetHandlerFactory;
import org.dbflute.s2dao.jdbc.TnResultSetHandlerFactoryImpl;
import org.dbflute.s2dao.jdbc.TnStatementFactoryImpl;
import org.dbflute.s2dao.metadata.TnBeanMetaDataFactory;
import org.dbflute.twowaysql.factory.SqlAnalyzerFactory;

/**
 * @author DBFlute(AutoGenerator)
 */
public class ImplementedInvokerAssistant implements InvokerAssistant {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected static final String[] DEFAULT_CLIENT_INVOKE_NAMES
        = new String[] { "Page", "Action", "Controller", "ControllerImpl", "Task", "Test" };

    protected static final String[] DEFAULT_BYPASS_INVOKE_NAMES
        = new String[] { "Service", "ServiceImpl", "Facade", "FacadeImpl", "Logic", "LogicImpl" };

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    protected DataSource _dataSource;
    protected DBFluteInitializer _introduction;

    // -----------------------------------------------------
    //                                        Lazy Component
    //                                        --------------
    protected volatile DBMetaProvider _dbmetaProvider;
    protected volatile SqlClauseCreator _sqlClauseCreator;
    protected volatile StatementFactory _statementFactory;
    protected volatile TnBeanMetaDataFactory _beanMetaDataFactory;
    protected volatile TnResultSetHandlerFactory _resultSetHandlerFactory;
    protected volatile RelationOptionalFactory _relationOptionalFactory;
    protected volatile SqlAnalyzerFactory _sqlAnalyzerFactory;
    protected volatile OutsideSqlExecutorFactory _outsideSqlExecutorFactory;
    protected volatile SQLExceptionHandlerFactory _sqlExceptionHandlerFactory;
    protected volatile SequenceCacheHandler _sequenceCacheHandler;

    // -----------------------------------------------------
    //                                       Disposable Flag
    //                                       ---------------
    protected volatile boolean _disposable;

    // ===================================================================================
    //                                                                 Assistant Main Work
    //                                                                 ===================
    // -----------------------------------------------------
    //                                         Current DBDef
    //                                         -------------
    /** {@inheritDoc} */
    public DBDef assistCurrentDBDef() {
        return DBCurrent.getInstance().currentDBDef();
    }

    // -----------------------------------------------------
    //                                           Data Source
    //                                           -----------
    /** {@inheritDoc} */
    public DataSource assistDataSource() { // DI component
        // this instance will be cached in SQL executions
        // so the handler should be set before initialization of DBFlute
        // (and it means you cannot switch data source after initialization)
        DataSourceHandler handler = DBFluteConfig.getInstance().getDataSourceHandler();
        return handler != null ? new HandlingDataSourceWrapper(_dataSource, handler) : _dataSource;
    }

    // -----------------------------------------------------
    //                                       DBMeta Provider
    //                                       ---------------
    /** {@inheritDoc} */
    public DBMetaProvider assistDBMetaProvider() { // lazy component
        if (_dbmetaProvider != null) {
            return _dbmetaProvider;
        }
        synchronized (this) {
            if (_dbmetaProvider != null) {
                return _dbmetaProvider;
            }
            _dbmetaProvider = createDBMetaProvider();
        }
        return _dbmetaProvider;
    }

    protected DBMetaProvider createDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // -----------------------------------------------------
    //                                    SQL Clause Creator
    //                                    ------------------
    /** {@inheritDoc} */
    public SqlClauseCreator assistSqlClauseCreator() { // lazy component
        if (_sqlClauseCreator != null) {
            return _sqlClauseCreator;
        }
        synchronized (this) {
            if (_sqlClauseCreator != null) {
                return _sqlClauseCreator;
            }
            _sqlClauseCreator = createSqlClauseCreator();
        }
        return _sqlClauseCreator;
    }

    protected SqlClauseCreator createSqlClauseCreator() {
        SqlClauseCreator creator = DBFluteConfig.getInstance().getSqlClauseCreator();
        if (creator != null) {
            return creator;
        }
        return newImplementedSqlClauseCreator(); // as default
    }

    protected ImplementedSqlClauseCreator newImplementedSqlClauseCreator() {
        return new ImplementedSqlClauseCreator();
    }

    // -----------------------------------------------------
    //                                     Statement Factory
    //                                     -----------------
    /** {@inheritDoc} */
    public StatementFactory assistStatementFactory() { // lazy component
        if (_statementFactory != null) {
            return _statementFactory;
        }
        synchronized (this) {
            if (_statementFactory != null) {
                return _statementFactory;
            }
            _statementFactory = createStatementFactory();
        }
        return _statementFactory;
    }

    protected StatementFactory createStatementFactory() {
        final TnStatementFactoryImpl factory = newStatementFactoryImpl();
        factory.setDefaultStatementConfig(assistDefaultStatementConfig());
        DBFluteConfig config = DBFluteConfig.getInstance();
        factory.setInternalDebug(config.isInternalDebug());
        factory.setCursorSelectFetchSize(config.getCursorSelectFetchSize());
        factory.setEntitySelectFetchSize(config.getEntitySelectFetchSize());
        factory.setUsePagingByCursorSkipSynchronizedFetchSize(config.isUsePagingByCursorSkipSynchronizedFetchSize());
        factory.setFixedPagingByCursorSkipSynchronizedFetchSize(config.getFixedPagingByCursorSkipSynchronizedFetchSize());
        return factory;
    }

    protected TnStatementFactoryImpl newStatementFactoryImpl() {
        return new TnStatementFactoryImpl();
    }

    // -----------------------------------------------------
    //                                Bean Meta Data Factory
    //                                ----------------------
    /** {@inheritDoc} */
    public TnBeanMetaDataFactory assistBeanMetaDataFactory() { // lazy component
        if (_beanMetaDataFactory != null) {
            return _beanMetaDataFactory;
        }
        synchronized (this) {
            if (_beanMetaDataFactory != null) {
                return _beanMetaDataFactory;
            }
            _beanMetaDataFactory = createBeanMetaDataFactory();
        }
        return _beanMetaDataFactory;
    }

    protected TnBeanMetaDataFactory createBeanMetaDataFactory() {
        RelationOptionalFactory relationOptionalFactory = assistRelationOptionalFactory();
        final TnBeanMetaDataFactoryExtension factory = newBeanMetaDataFactoryExtension(relationOptionalFactory);
        factory.setDataSource(_dataSource);
        factory.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        return factory;
    }

    protected TnBeanMetaDataFactoryExtension newBeanMetaDataFactoryExtension(RelationOptionalFactory relationOptionalFactory) {
        return new TnBeanMetaDataFactoryExtension(relationOptionalFactory);
    }

    // -----------------------------------------------------
    //                            Result Set Handler Factory
    //                            --------------------------
    /** {@inheritDoc} */
    public TnResultSetHandlerFactory assistResultSetHandlerFactory() { // lazy component
        if (_resultSetHandlerFactory != null) {
            return _resultSetHandlerFactory;
        }
        synchronized (this) {
            if (_resultSetHandlerFactory != null) {
                return _resultSetHandlerFactory;
            }
            _resultSetHandlerFactory = createResultSetHandlerFactory();
        }
        return _resultSetHandlerFactory;
    }

    protected TnResultSetHandlerFactory createResultSetHandlerFactory() {
        return newResultSetHandlerFactoryImpl();
    }

    protected TnResultSetHandlerFactoryImpl newResultSetHandlerFactoryImpl() {
        return new TnResultSetHandlerFactoryImpl();
    }

    // -----------------------------------------------------
    //                             Relation Optional Factory
    //                             -------------------------
    /** {@inheritDoc} */
    public RelationOptionalFactory assistRelationOptionalFactory() {
        if (_relationOptionalFactory != null) {
            return _relationOptionalFactory;
        }
        synchronized (this) {
            if (_relationOptionalFactory != null) {
                return _relationOptionalFactory;
            }
            _relationOptionalFactory = createRelationOptionalFactory();
        }
        return _relationOptionalFactory;
    }

    protected RelationOptionalFactory createRelationOptionalFactory() {
        return newRelationOptionalFactory();
    }

    protected RelationOptionalFactory newRelationOptionalFactory() {
        return new RelationOptionalFactory();
    }

    // -----------------------------------------------------
    //                                  SQL Analyzer Factory
    //                                  --------------------
    /** {@inheritDoc} */
    public SqlAnalyzerFactory assistSqlAnalyzerFactory() { // lazy component
        if (_sqlAnalyzerFactory != null) {
            return _sqlAnalyzerFactory;
        }
        synchronized (this) {
            if (_sqlAnalyzerFactory != null) {
                return _sqlAnalyzerFactory;
            }
            _sqlAnalyzerFactory = createSqlAnalyzerFactory();
        }
        return _sqlAnalyzerFactory;
    }

    protected SqlAnalyzerFactory createSqlAnalyzerFactory() {
        return newMelodicSqlAnalyzerFactory();
    }

    protected MelodicSqlAnalyzerFactory newMelodicSqlAnalyzerFactory() {
        return new MelodicSqlAnalyzerFactory();
    }

    // -----------------------------------------------------
    //                               First OutsideSql Option
    //                               -----------------------
    /** {@inheritDoc} */
    public OutsideSqlOption assistFirstOutsideSqlOption(String tableDbName) {
        return prepareFirstOutsideSqlOption(tableDbName);
    }

    protected OutsideSqlOption prepareFirstOutsideSqlOption(String tableDbName) {
        if (DBFluteConfig.getInstance().isNonSpecifiedColumnAccessAllowed()) {
            OutsideSqlOption option = new OutsideSqlOption();
            option.setTableDbName(tableDbName);
            return option.enableNonSpecifiedColumnAccess();
        }
        return null; // no instance (lazy-loaded) as default
    }

    // -----------------------------------------------------
    //                           OutsideSql Executor Factory
    //                           ---------------------------
    /** {@inheritDoc} */
    public OutsideSqlExecutorFactory assistOutsideSqlExecutorFactory() {
        if (_outsideSqlExecutorFactory != null) {
            return _outsideSqlExecutorFactory;
        }
        synchronized (this) {
            if (_outsideSqlExecutorFactory != null) {
                return _outsideSqlExecutorFactory;
            }
            _outsideSqlExecutorFactory = createOutsideSqlExecutorFactory();
        }
        return _outsideSqlExecutorFactory;
    }

    protected OutsideSqlExecutorFactory createOutsideSqlExecutorFactory() {
        OutsideSqlExecutorFactory factory = DBFluteConfig.getInstance().getOutsideSqlExecutorFactory();
        if (factory != null) {
            return factory;
        }
        return newDefaultOutsideSqlExecutorFactory(); // as default
    }

    protected DefaultOutsideSqlExecutorFactory newDefaultOutsideSqlExecutorFactory() {
        return new DefaultOutsideSqlExecutorFactory();
    }

    // -----------------------------------------------------
    //                                   SQLException Digger
    //                                   -------------------
    /** {@inheritDoc} */
    public SQLExceptionDigger assistSQLExceptionDigger() {
        return createSQLExceptionDigger();
    }

    protected SQLExceptionDigger createSQLExceptionDigger() {
        return DBFluteConfig.getInstance().getSQLExceptionDigger();
    }

    // -----------------------------------------------------
    //                          SQLException Handler Factory
    //                          ----------------------------
    /** {@inheritDoc} */
    public SQLExceptionHandlerFactory assistSQLExceptionHandlerFactory() { // lazy component
        if (_sqlExceptionHandlerFactory != null) {
            return _sqlExceptionHandlerFactory;
        }
        synchronized (this) {
            if (_sqlExceptionHandlerFactory != null) {
                return _sqlExceptionHandlerFactory;
            }
            _sqlExceptionHandlerFactory = createSQLExceptionHandlerFactory();
        }
        return _sqlExceptionHandlerFactory;
    }

    protected SQLExceptionHandlerFactory createSQLExceptionHandlerFactory() {
        return newDefaultSQLExceptionHandlerFactory();
    }

    protected DefaultSQLExceptionHandlerFactory newDefaultSQLExceptionHandlerFactory() {
        return new DefaultSQLExceptionHandlerFactory();
    }

    // -----------------------------------------------------
    //                                Sequence Cache Handler
    //                                ----------------------
    /** {@inheritDoc} */
    public SequenceCacheHandler assistSequenceCacheHandler() { // lazy component
        if (_sequenceCacheHandler != null) {
            return _sequenceCacheHandler;
        }
        synchronized (this) {
            if (_sequenceCacheHandler != null) {
                return _sequenceCacheHandler;
            }
            _sequenceCacheHandler = createSequenceCacheHandler();
        }
        return _sequenceCacheHandler;
    }

    protected SequenceCacheHandler createSequenceCacheHandler() {
        SequenceCacheHandler handler = newSequenceCacheHandler();
        SequenceCacheKeyGenerator generator = DBFluteConfig.getInstance().getSequenceCacheKeyGenerator();
        if (generator != null) {
            handler.setSequenceCacheKeyGenerator(generator);
        }
        handler.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        return handler;
    }

    protected SequenceCacheHandler newSequenceCacheHandler() {
        return new SequenceCacheHandler();
    }

    // -----------------------------------------------------
    //                                     SQL File Encoding
    //                                     -----------------
    /** {@inheritDoc} */
    public String assistSqlFileEncoding() {
        return "UTF-8";
    }

    // -----------------------------------------------------
    //                               Statement Configuration
    //                               -----------------------
    /** {@inheritDoc} */
    public StatementConfig assistDefaultStatementConfig() {
        return DBFluteConfig.getInstance().getDefaultStatementConfig();
    }

    // -----------------------------------------------------
    //                            Behavior Exception Thrower
    //                            --------------------------
    /** {@inheritDoc} */
    public BehaviorExceptionThrower assistBehaviorExceptionThrower() {
        return new BehaviorExceptionThrower();
    }

    // -----------------------------------------------------
    //                                 Geared Cipher Manager
    //                                 ---------------------
    /** {@inheritDoc} */
    public GearedCipherManager assistGearedCipherManager() {
        return DBFluteConfig.getInstance().getGearedCipherManager();
    }

    // -----------------------------------------------------
    //                                    Resource Parameter
    //                                    ------------------
    /** {@inheritDoc} */
    public ResourceParameter assistResourceParameter() {
        return createResourceParameter();
    }

    protected ResourceParameter createResourceParameter() {
        ResourceParameter parameter = newResourceParameter();
        parameter.setOutsideSqlPackage(DBFluteConfig.getInstance().getOutsideSqlPackage());
        parameter.setMappingDateTimeZoneProvider(DBFluteConfig.getInstance().getMappingDateTimeZoneProvider());
        parameter.setLogDatePattern(DBFluteConfig.getInstance().getLogDatePattern());
        parameter.setLogTimestampPattern(DBFluteConfig.getInstance().getLogTimestampPattern());
        parameter.setLogTimePattern(DBFluteConfig.getInstance().getLogTimePattern());
        parameter.setLogTimeZoneProvider(DBFluteConfig.getInstance().getLogTimeZoneProvider());
        parameter.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        return parameter;
    }

    protected ResourceParameter newResourceParameter() {
        return new ResourceParameter();
    }

    // -----------------------------------------------------
    //                                          Invoke Names
    //                                          ------------
    /** {@inheritDoc} */
    public String[] assistClientInvokeNames() {
        return DEFAULT_CLIENT_INVOKE_NAMES;
    }

    /** {@inheritDoc} */
    public String[] assistByPassInvokeNames() {
        return DEFAULT_BYPASS_INVOKE_NAMES;
    }

    // ===================================================================================
    //                                                                             Dispose
    //                                                                             =======
    /** {@inheritDoc} */
    public void toBeDisposable(final DisposableProcess callerProcess) { // for HotDeploy
        // do nothing: unsupported at this DI container
    }

    public boolean isDisposable() {
        return _disposable;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public void setDataSource(DataSource dataSource) {
        _dataSource = dataSource;
    }

    // to check the initializer is an instance of DBFluteInitializer
    // when the initializer is extended by DBFlute property
    // so this variable is actually unused in this class
    // (needs to be injected only when the DI container is set by its DI setting file)
    public void setIntroduction(DBFluteInitializer introduction) {
        _introduction = introduction;
    }
}
