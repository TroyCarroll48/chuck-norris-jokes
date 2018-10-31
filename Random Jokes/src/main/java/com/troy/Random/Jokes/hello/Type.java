package com.troy.Random.Jokes.hello;

public class Type {



    private String type;
    private Value value;

    public Type(){
    }

    public Type(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String  getType() {
        return type;
    }

    public void setType(String type) {
        this.type =type;
    }

    public Value getvalue() {
        return value;
    }

    public void setvalue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
