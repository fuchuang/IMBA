package com.IMBA.entity;

import java.util.Date;

public class elective_collections extends elective_collectionsKey {
    private Date collectionTime;

    private Integer collecterId;

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Integer getCollecterId() {
        return collecterId;
    }

    public void setCollecterId(Integer collecterId) {
        this.collecterId = collecterId;
    }
}