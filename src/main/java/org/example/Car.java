package org.example;

import java.awt.*;

public abstract class Car implements Movable {
    public boolean turboOn;
    public double trimFactor = 1;
    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    public String modelName; // The car model name
    public String direction; // Current direction of the car
    public double position_x; // Current x position of the car
    public double position_y; // Current y position of the car
    int getNrDoors(){
        return nrDoors;
    }
    double getEnginePower(){
        return enginePower;
    }
    double getCurrentSpeed(){
        return currentSpeed;
    }
    Color getColor(){
        return color;
    }
    void setColor(Color clr){
        color = clr;
    }
    void startEngine(){
        currentSpeed = 0.1;
    }
    void stopEngine(){
        currentSpeed = 0;
    }
    void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    private double speedFactor(){
        double turbo = trimFactor;
        if(turboOn) turbo *= 1.3;
        return enginePower * 0.01 * turbo;
    }
    void gas(double amount){
        if (amount >= 0 && amount <= 1) incrementSpeed(amount);
        else throw new IllegalArgumentException("Amount outside of interval");
    }
    void brake(double amount){
        if (amount >= 0 && amount <= 1) decrementSpeed(amount);
        else throw new IllegalArgumentException("Amount outside of interval");
    }
    @Override
    public void move() {
        switch(direction) {
            case "up":
                position_y -= getCurrentSpeed();
                break;
            case "left":
                position_x -= getCurrentSpeed();
                break;
            case "down":
                position_y += getCurrentSpeed();
                break;
            case "right":
                position_x += getCurrentSpeed();
                break;
        }
    }
    @Override
    public void turnLeft() {
        switch(direction) {
            case "up":
                direction = "left";
                break;
            case "left":
                direction = "down";
                break;
            case "down":
                direction = "right";
                break;
            case "right":
                direction = "up";
                break;
        }
    }
    @Override
    public void turnRight() {
        switch(direction) {
            case "up":
                direction = "right";
                break;
            case "right":
                direction = "down";
                break;
            case "down":
                direction = "left";
                break;
            case "left":
                direction = "up";
                break;
        }
    }
}
