import java.io.*;

public class checking {

    public boolean checkID(int id) throws IOException {
        FileInputStream fstream = new FileInputStream("accounts.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;


        while((strLine = br.readLine()) != null)   {
            // Print the content on the console
            if(id==Integer.parseInt(strLine)){

                return true;
            }
        }


        fstream.close();

        return false;

    }

}
