import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void run(){
        ArrayList<PostInfo> postInfos = createPostInfoList();
        System.out.print("Indtast venligst postnummer: ");
        String brugerSvar = getUserInputString();

        boolean isPostNumFound = false;

        for (int i = 0; i < postInfos.size(); i++) {
            PostInfo postInfoObject = postInfos.get(i);
            String postInfoNumber = postInfoObject.getPostNummer();
            if (postInfoNumber.equals(brugerSvar)) {
                isPostNumFound = true;
                System.out.println("Nr. " + (i+1)  + ":\t" + postInfoObject);
            }
        }
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
