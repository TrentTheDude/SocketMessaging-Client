package me.trent.client.eums;

public enum MessageType {

    UNKNOWN(0, "UNKNOWN"),
    MESSAGE(1, "MESSAGE"),
    GET(2, "GET"),
    PUT(3, "PUT")


    ;

    String name;
    int id;

    MessageType(int id, String name){
        this.id = id;
        this.name = name;
    }

    public MessageType parseType(String name){
        return MessageType.valueOf(name); //todo; might have to change this to a for loop later...
    }
    public MessageType parseType(int id){
        for (MessageType types : MessageType.values()){
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
