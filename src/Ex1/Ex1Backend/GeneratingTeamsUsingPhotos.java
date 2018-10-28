package Ex1.Ex1Backend;


import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;

import Ex1.FifaWorldCupData;
import Ex1.FifaWorldCupDataFileManager;
import Ex1.Team;

public class GeneratingTeamsUsingPhotos {

    public static void main(String[] args) throws IOException {
        FifaWorldCupData fifa = new FifaWorldCupDataFileManager(".\\teams.bin",".\\games.bin");

       File dir = new File("./Photos");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                fifa.saveTeam(new Team(child.getName().replaceAll(".png",""),Color.color(Math.random(), Math.random(),Math.random()),
                        Color.color(Math.random(),Math.random(),Math.random())));
            }
        }


        for(int i = 0 ; i <= fifa.getNumOfTeams() ; i++){
        	try
        	{
            System.out.println(fifa.nextTeam());
        	}
        	catch(Exception e)
        	{
        	System.out.println(i);		
        	}
        }
        System.out.println("---------------------------------------------------------------------------------");

        for(int i = 0 ; i <= fifa.getNumOfTeams() ; i++){
            System.out.println(fifa.previousTeam());
        }

    }
}
