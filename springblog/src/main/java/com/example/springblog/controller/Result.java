package com.example.springblog.controller;

public class Result {
    Object data;
    int stste;

    public Result(Object data, int stste) {
        this.data = data;
        this.stste = stste;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStste() {
        return stste;
    }

    public void setStste(int stste) {
        this.stste = stste;
    }
}
