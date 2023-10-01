package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Wall> wallList = new ArrayList<>(); //creating new list

    //Constructor that creates four Wall objects
    public Room(double width, double length, double height){
        //width and height,
        wallList.add(new Wall(width, height));//adds them to the list of Walls
        wallList.add(new Wall(width, height));
        // length and height
        wallList.add(new Wall(length, height));
        wallList.add(new Wall(length, height));
    }
    public double getArea(){

        //Calculating Total Area
        double calculatedArea = wallList.get(0).getArea()
                + wallList.get(1).getArea()
                + wallList.get(2).getArea()
                + wallList.get(3).getArea();

        return calculatedArea;
    }

    @Override
    public String toString(){
        return "The area of the room is: " + getArea();
    }
}
