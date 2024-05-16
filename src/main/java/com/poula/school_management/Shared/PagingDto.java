package com.poula.school_management.Shared;

import java.util.ArrayList;
import java.util.List;

public class PagingDto<T> {
    protected List<T> entities = new ArrayList<>();
    protected Long totalNumber;
    protected int currentPage;
    protected int totalNumberOfPages;

    public PagingDto() {
    }

    public PagingDto(List<T> entities, Long totalNumber, int currentPage, int totalNumberOfPages) {
        this.entities = entities;
        this.totalNumber = totalNumber;
        this.currentPage = currentPage;
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public Long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }


}
