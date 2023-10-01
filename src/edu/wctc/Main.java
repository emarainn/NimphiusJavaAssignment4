package edu.wctc;
import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        userInput();
    }
    public static void userInput() throws IOException, ClassNotFoundException {
        //Calling printMenu
        printMenu();
        System.out.print("Enter Menu Option: ");
        String choice = sc.nextLine(); //allows for user input

        switch (choice){
            case "1":
                createRoom();
                break;
            case "2":
                System.out.println(paintCalculator.toString());
                userInput();
                break;
            case "3":
                readFile();
                break;
            case "4":
                writeFile();
                break;
            case "5":
                System.out.println("Bye");
                System.exit(1);
                break;
        }
    }
    private static void printMenu(){
        System.out.println("Menu Options:" +
                "\n--------------" +
                "\n1. Add Room" +
                "\n2. View Rooms" +
                "\n3. Read Rooms From File" +
                "\n4. Write Rooms to File" +
                "\n5. Exit Program");
    }

    //I don't think I understood this ...
    private static double promptForDimension(String dimensionName) throws IOException, ClassNotFoundException {
        //Prints a prompt for the user to enter the given dimension and returns their response.
        String dimesnion = null;
            System.out.print("\nDimension Options: " +
                    "\n\tw - Width" +
                    "\n\tl - Length" +
                    "\n\th - Height" +
                    "\n\tx - To Move On" +
                    "\nEnter Dimension Letter: ");
            dimesnion = sc.nextLine().toLowerCase();

            do {
                if (dimesnion.equals("w")) {
                    System.out.print("Enter Width:");
                    double width = Integer.parseInt(sc.nextLine());
                    System.out.println("Width = " + width);
                    return width;
                } else if (dimesnion.equals("l")) {
                    System.out.print("Enter Length:");
                    double length = Integer.parseInt(sc.nextLine());
                    System.out.println("Length = " + length);
                    return length;
                } else if (dimesnion.equals("h")) {
                    System.out.print("Enter Height:");
                    double height = Integer.parseInt(sc.nextLine());
                    System.out.println("Height = " + height);
                    return height;
                } else if (dimesnion.equals("x")) {
                    userInput();
                } else
                    System.out.println("Invalid Input");
                promptForDimension(dimesnion);
            }while (dimensionName != null);
                return 0;
    }

    private static void createRoom() throws IOException, ClassNotFoundException {
    //Prompts the user to enter length, width, and height. Tells the paint calculator
    //to add a room using given dimensions.
        System.out.print("Enter Width: ");
        double width = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Length: ");
        double length = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Height: ");
        double height = Integer.parseInt(sc.nextLine());
        paintCalculator.addRoom(width, length, height);

        userInput();
    }

    private static void readFile() throws IOException, ClassNotFoundException {
        File filename = new File ("paintFile.txt");

        try{
            Scanner fileScanner = new Scanner(filename);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                System.out.println("Room with area: " + line);
            }
        }catch (Exception e){
            System.out.println("File Not Found");
        }
        userInput();
    }

    //I got help for read and write...
    private static void writeFile() throws IOException, ClassNotFoundException {
        FileWriter writer = new FileWriter("paintFile.txt", true);
        PrintWriter printer = new PrintWriter(writer);
        for (Room room : paintCalculator.roomList) printer.println(room.getArea());
        printer.flush();
        printer.close();
        System.out.println("Added to File");

        userInput();
    }
}
