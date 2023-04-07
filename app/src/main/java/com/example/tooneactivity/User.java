package com.example.tooneactivity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class User {
    @Id
    private Long id;
    private String Name;

    private long profileId;

    @ToOne(joinProperty = "profileId")
    private Profile profile;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 710784880)
    public User(Long id, String Name, long profileId) {
        this.id = id;
        this.Name = Name;
        this.profileId = profileId;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public long getProfileId() {
        return this.profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    @Generated(hash = 71388887)
    private transient Long profile__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 207979020)
    public Profile getProfile() {
        long __key = this.profileId;
        if (profile__resolvedKey == null || !profile__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProfileDao targetDao = daoSession.getProfileDao();
            Profile profileNew = targetDao.load(__key);
            synchronized (this) {
                profile = profileNew;
                profile__resolvedKey = __key;
            }
        }
        return profile;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1352761329)
    public void setProfile(@NotNull Profile profile) {
        if (profile == null) {
            throw new DaoException(
                    "To-one property 'profileId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.profile = profile;
            profileId = profile.getId();
            profile__resolvedKey = profileId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
