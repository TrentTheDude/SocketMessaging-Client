package me.trent.client.eums;

public enum DataType {

    UNKNOWN(0, "UNKNOWN"),
    STRING(1, "STRING"),
    FILE(2, "FILE"),


    ;

    String name;
    int id;

    DataType(int id, String name){
        this.id = id;
        this.name = name;
    }

    public DataType parseType(String name){
        return DataType.valueOf(name);
    }
    public DataType parseType(int id){
        for (DataType types : DataType.values()){
            if (types.getId() == id){
                return types;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
