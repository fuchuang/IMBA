package com.IMBA.model;

import java.util.List;

public class SearchResult<T>  {
    private List<?> objectList;
    private int totalpage;
    private int totalnums;

    public List<?> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<?> objectList) {
        this.objectList = objectList;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalnums() {
        return totalnums;
    }

    public void setTotalnums(int totalnums) {
        this.totalnums = totalnums;
    }
}
