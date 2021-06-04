package com.formation.app;

import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.dao.jdbc.JdbcTripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import java.util.List;

public class Main {
//jdbc:mysql://localhost:3306 link
    public static void main(String[] args) {
        testDao();


    }//psvm


    public static  void testDao (){

        JdbcPlaceDao placeQueryTool = DaoFactory.createPlaceDao();
        placeQueryTool.pleaseImpMe();
        List<Place> placeList = placeQueryTool.findAll();

        //if error here output is fun
        JdbcTripDao tripQueryTool = DaoFactory.createTripDao();
        tripQueryTool.pleaseImpMe();
        List<Trip> tripList = tripQueryTool.findAll();

        //jdcbc Place Dao Testing
        System.out.println("Test place find all");
        for (int i = 0; i < placeList.size(); i++) {
            System.out.println(placeList.get(i).getID());
            System.out.println(placeList.get(i).getName());
        }
        System.out.println("success!!");


        System.out.println("Creation and id affectation");
        //Place pToCreate = new Place("Chateauroux");
        Place pToCreate2 = new Place(373737,"notTours");
        //placeQueryTool.create(pToCreate);
        placeQueryTool.create(pToCreate2);
        //System.out.println(pToCreate.getID());
        System.out.println(pToCreate2.getID());
        System.out.println("success !!");


        System.out.println("Fetching");
        Place fetchedPlace = placeQueryTool.findById((long)373737);
        System.out.println(fetchedPlace.getID());
        System.out.println(fetchedPlace.getName());
        System.out.println("Success !!");


        System.out.println("updating");
        System.out.println(placeQueryTool.findById((long)373737).getName());
        fetchedPlace.setName("Tours");
        System.out.println(fetchedPlace.getName());
        placeQueryTool.update(fetchedPlace);
        System.out.println(placeQueryTool.findById((long)373737).getName());
        System.out.println("Success !!");

        System.out.println("deletion");
        placeQueryTool.delete((long)373737);
        System.out.println("Success !!");

        placeList.clear();
        placeList = placeQueryTool.findAll();


        //jdcbc Trip Dao Testing

        System.out.println("Test trip find all");

        for (int i = 0; i < tripList.size(); i++) {
            System.out.println(tripList.get(i).getID());
            System.out.println(tripList.get(i).getName());
            System.out.println(tripList.get(i).getArrival_id()+" "+tripList.get(i).getDpt_id());
            System.out.println();

        }
        System.out.println("success!!");

        System.out.println("Creation and id affectation");
        //Trip tToCreate = new Trip("GenevaParis",(long)30,(long)27);
        Trip tToCreate2 = new Trip((long)999999,"TEST CREATE",(long)99,(long)99);
        //tripQueryTool.create(tToCreate);
        tripQueryTool.create(tToCreate2);
        //System.out.println(tToCreate.getID());
        System.out.println(tToCreate2.getID());
        System.out.println("success !!");



        System.out.println("Fetching");
        Trip fetchedTrip = tripQueryTool.findById((long)999999);
        System.out.println(fetchedTrip.getID());
        System.out.println(fetchedTrip.getName());
        System.out.println(fetchedTrip.getDpt_id());
        System.out.println(fetchedTrip.getArrival_id());
        System.out.println("Success !!");

        System.out.println("updating");
        System.out.println(tripQueryTool.findById((long)999999).getName());
        fetchedTrip.setName("MODIFIED CREATE");
        fetchedTrip.setDpt_id((long)1125);
        fetchedTrip.setArrival_id((long)1125);
        System.out.println(fetchedTrip.getName());
        System.out.println(fetchedTrip.getID());
        System.out.println(fetchedTrip.getDpt_id());
        System.out.println(fetchedTrip.getArrival_id());
        tripQueryTool.update(fetchedTrip);
        System.out.println(tripQueryTool.findById((long)999999).getName());
        System.out.println("Success !!");

        System.out.println("deletion");
        tripQueryTool.delete((long)999999);
        System.out.println("Success !!");
    }
}//class
