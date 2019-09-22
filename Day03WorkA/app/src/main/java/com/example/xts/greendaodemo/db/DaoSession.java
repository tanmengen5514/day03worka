package com.example.xts.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.tan.en.day03worka.bean.DatasBean;

import com.example.xts.greendaodemo.db.DatasBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig datasBeanDaoConfig;

    private final DatasBeanDao datasBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        datasBeanDaoConfig = daoConfigMap.get(DatasBeanDao.class).clone();
        datasBeanDaoConfig.initIdentityScope(type);

        datasBeanDao = new DatasBeanDao(datasBeanDaoConfig, this);

        registerDao(DatasBean.class, datasBeanDao);
    }
    
    public void clear() {
        datasBeanDaoConfig.clearIdentityScope();
    }

    public DatasBeanDao getDatasBeanDao() {
        return datasBeanDao;
    }

}
