import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    // Programmet sættes igang
    public static void run(){
        // Bygger en ArrayListe af PostInfo objekter ud fra metoden creatPostInfoList()
        ArrayList<PostInfo> postInfos = createPostInfoList();
        // Beder brugeren om at indtaste et nummer
        System.out.print("Indtast venligst postnummer: ");
        // Gemmer brugerens svar via metoden getUserInputString()
        String brugerSvar = getUserInputString();

        // Laver en boolean der holder øje emd om postnummeret blev fundet
        boolean isPostNumFound = false;

        // For hver postInfo i postInfoListen spørger vi om brugerens svar og postInfoNummeret er ens
        for (int i = 0; i < postInfos.size(); i++) {
            PostInfo postInfoObject = postInfos.get(i);
            String postInfoNumber = postInfoObject.getPostNummer();
            if (postInfoNumber.equals(brugerSvar)) {
                // Hvis vi finder et match til brugerens svar, så sætter vi isPostNumFound til true og printer pladsnummer, samt postInfoObjekt
                isPostNumFound = true;
                System.out.println("Nr. " + (i+1)  + ":\t" + postInfoObject);
            }
        }
        // Hvis brugerens svar ikke er fundet printes der brugerens svar ikke er valid
        if (!isPostNumFound) {
            System.out.println(brugerSvar + " is not a valid answer!");
        }




    }

    private static ArrayList<PostInfo> createPostInfoList() {
        ArrayList<PostInfo> postInfos = new ArrayList<>();

        try {
            Scanner fileScan = new Scanner(new File("Postnummer/src/liste.csv"));


            while (fileScan.hasNextLine()){
                String postInfoLine = fileScan.nextLine();
                PostInfo postInfoObject = createPostInfo(postInfoLine);


                postInfos.add(postInfoObject);
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return postInfos;
    }

    private static PostInfo createPostInfo(String postInfoLine) {
        Scanner lineScan = new Scanner(postInfoLine);
        lineScan.useDelimiter(";");
        String postNummer = lineScan.next();
        String by = lineScan.next();
        return new PostInfo(postNummer, by);
    }

    private static String getUserInputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
