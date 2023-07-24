package com.bowen.community.entity;


//封装分页相关信息
public class Page {
    //传入当前页码
    private int current = 1;

    //页面数据上限
    private int limit = 10;

    //数据总数,用于计算总页码
    private int max;

    //查询路径,分页链接
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >=1 ) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if (max >= 0) {
            this.max = max;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页(在全部数据中)的起始行
    public int getOffset(){

        return current * limit - limit;
    }

    //获取总页数
    public int getTotal(){
        if (max % limit == 0){
            return max/limit;
        }
        else {
            return max/limit + 1;
        }
    }

    //页码显示的起始页
    public int getFrom(){
        int from = current - 2;
        if (from < 1){
            return 1;
        }else {
            return from;
        }
    }

    //页码显示的截至页
    public int getTo(){
        int to = current + 2;
        if (to > getTotal()){
            return getTotal();
        }else {
            return to;
        }
    }
}
