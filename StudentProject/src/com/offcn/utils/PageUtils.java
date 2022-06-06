package com.offcn.utils;

public class PageUtils {
    
    private int pageSize;//页面容量 
    private int startIndex;//分页起始索引
    private int curPage;//当前页
    private int prevPage;//上一页
    private int nextPage;//下一页
    private int endPage;//尾页
    private int rows;//总记录数

    public PageUtils(int rows,String curPage) {
        this.rows = rows;
        pageSize=3;
        initCurPage(curPage);
        initPrevPage();
        initEndPage();
        initNextPage();
        initStartIndex();
    }

    public void initStartIndex(){
        startIndex = (curPage - 1) * pageSize;
    };//分页起始索引

    public void initCurPage(String curPage){
        if (curPage == null || "".equals(curPage)){
            this.curPage = 1;
        }else {
            this.curPage=Integer.parseInt(curPage);
        }
    };//当前页

    public void initPrevPage(){
        if (curPage > 1){
            prevPage = curPage -1;
        }else {
            prevPage = 1;
        }
    };//上一页

    public void initNextPage(){
        if (curPage >= 1 && curPage < endPage){
            nextPage = curPage + 1;
        }else {
            nextPage = endPage;
        }
    };//下一页

    public void initEndPage(){
        endPage = (rows % pageSize == 0 ? rows / pageSize :rows / pageSize + 1 );
    };//尾页


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", curPage=" + curPage +
                ", prevPage=" + prevPage +
                ", nextPage=" + nextPage +
                ", endPage=" + endPage +
                ", rows=" + rows +
                '}';
    }
}
