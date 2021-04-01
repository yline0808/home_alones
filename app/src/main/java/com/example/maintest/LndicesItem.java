package com.example.maintest;

import java.io.Serializable;

public class LndicesItem implements Serializable {
    String gu;
    float gi;

    public LndicesItem() {
    }

    public LndicesItem(String gu, float gi) {
        this.gu = gu;
        this.gi = gi;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public float getGi() {
        return gi;
    }

    public void setGi(float gi) {
        this.gi = gi;
    }

    @Override
    public String toString() {
        return "IndicesItem{" +
                "gu='" + gu + '\'' +
                ", gi=" + gi +
                '}';
    }
}
