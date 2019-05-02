import java.io.File;

public class FileRename {
	public static void main(String[] args) {
		File f = new File("D:\\archives\\Friends.S03.1996.BDRip.1080p.Ukr.Eng.AC3.Hurtom.TNU.Tenax555");
		File[] listFiles = f.listFiles();
		int i = 1;
		for (File file : listFiles) {
			String filename = file.getName();
			if(filename.contains(".mkv")) {
				file.renameTo(new File(f.getPath()+"/Friends.S03E"+String.format("%02d", i)+".mkv"));
				i++;
			}
			
		}
	}
}
