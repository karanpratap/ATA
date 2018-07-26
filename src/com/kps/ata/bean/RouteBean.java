/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.bean;

/**
 *
 * @author kps
 */
public class RouteBean {
    
    String routeID;
    String source, destination;
    int distance, travelDuration;

    public RouteBean(String routeID, String source, String destination, int distance, int travelDuration) {
        this.routeID = routeID;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.travelDuration = travelDuration;
    }

    public String getRouteID() {
        return routeID;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getTravelDuration() {
        return travelDuration;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setTravelDuration(int travelDuration) {
        this.travelDuration = travelDuration;
    }
    
}
