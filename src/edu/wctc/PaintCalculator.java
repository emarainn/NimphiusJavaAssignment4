package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class PaintCalculator {
    List<Room> roomList = new ArrayList<>(); //creating new list

    public void addRoom(double length, double width, double height){
        //Creates a room object and adds it to its list field.
        roomList.add(new Room(width, length, height));//adds them to the list of Rooms
    }

    @Override
    public String toString() {
        String list = null;
        if (roomList.isEmpty()) {
            return "No Rooms";
        } else{
            for (Room room : roomList) {
                return roomList.toString();
            }
            list = roomList.toString();
        }
        return list;
    }
}
