package edu.wctc;
public class Wall {
    private double Width;
    private double Height;

    public Wall(double width, double height){
        Width = width;
        Height = height;
    }

    public double getWidth(){
        return Width;
    }

    public double getHeight(){
        return Height;
    }

    public double getArea(){ //multiplying w * h to het area
        return Width * Height;
    }
}

/*
public	--	Wall	double width, double height	Constructor that initializes width and height fields with its parameters.
public	double	getWidth	--	Returns the width field.
public	double	getHeight	--	Returns the height field.
public	double	getArea	--	Returns the calculated area of the wall.

*/