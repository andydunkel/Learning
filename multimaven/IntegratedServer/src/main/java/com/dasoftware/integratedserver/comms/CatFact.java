package com.dasoftware.integratedserver.comms;

/**
 * Data class for cat facts
 */
public class CatFact {

    private String fact = "";
    private int length = 0;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        var s = fact + " - " +  length;
        return s;
    }
}
