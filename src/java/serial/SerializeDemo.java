import java.io.*;

public class SerializeDemo
{
   public static void main(String [] args)
   {
      Employee e = new Employee();
      e.name = "Reyan Ali";
      e.address = "Phokka Kuan, Ambehta Peer";
      e.SSN = 11122333;
      e.number = 101;
      String tmp_dir = "/tmp/employee.ser";
      String data_dir = getAppDataDirectory(tmp_dir, true);
      System.out.println("app dir "+data_dir);
      try
      {
         FileOutputStream fileOut = new FileOutputStream(data_dir);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
      } catch (java.io.FileNotFoundException fnfe)
      {
         System.out.println("fnfe");
         fnfe.printStackTrace();
      } catch(IOException i)
      {
          i.printStackTrace();
      }
   }

   private static String getAppDataDirectory(String subDirectory, boolean create) {

    String appDataDirectory;
    try {
        appDataDirectory = System.getenv("APPDATA"); //Windows
        //todo - could try "ALLUSERSPROFILE"
        if (appDataDirectory != null) {
            appDataDirectory += File.separator + subDirectory + File.separator;
        }
        else { //appDataDirectory is null
            appDataDirectory = System.getenv("HOME"); //Unix
            if (appDataDirectory != null) {
                appDataDirectory +=  File.separator + subDirectory + File.separator;
            }
            else { //appDataDirectory is still null
                throw new Exception("Could not access APPDATA or HOME environment variables");
            }
        }
    }
    catch(Exception e) {
        e.printStackTrace();
        appDataDirectory = "";
    }

    if (create && appDataDirectory != null && appDataDirectory.length() > 0) {
        try {
            File dir = new File(appDataDirectory);
            dir.mkdir();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    //log("appDataDirectory: " + appDataDirectory);
    return appDataDirectory;
}
}