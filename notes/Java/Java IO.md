
Bytes 8 bits	 		Char 16 bits	Bridge classes		     			
FileInputStream	 		FileReader 		InputStreamReader	 
FileOutputStream 		FileWriter 		OutputStreamWriter	   

Buffered Bytes     		Character streams 
BufferedInputStream		BufferedReader(new FileReader... 
BufferedOutputStream 	BufferedWriter(new FileWriter...  

**8 bits**
in = new FileInputStream("xanadu.txt");
out = new FileOutputStream("outagain.txt");
int c;
while ((c = in.read()) != -1)
{ 
    out.write(c);
}

**16 bits i18n**
in = new FileReader("xanadu.txt");
out = new FileWriter("characteroutput.txt");

**by line**
in = new BufferedReader(new FileReader("xanadu.txt"));
out = new PrintWriter(new FileWriter("characteroutput.txt"));
String l;

**buffered**
inputStream = new BufferedReader(new FileReader("xanadu.txt"));
outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
