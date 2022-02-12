package documents;
import warnings.Error;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JFileChooser;

import databaseManagement.FileManagement;
/**
 * This class opens a dialog and gets the path of the file to be read.
 * <p>
 * Then it sends the file to another class to get it uploaded in database.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class UploadFile {
	/**
	 * It opens a dialog box, user can select the file path.
	 * File from that path will be loaded and later uploaded.
	 * @param eventID id of the event in which we are going to upload the file.
	 * 
	 */
	public void upload_file(int eventID)  {
		JFileChooser chooseFile = new JFileChooser();
	    int check = chooseFile.showOpenDialog(null);
		Error message = new Error();
		if(check == 0)
		{
			File file = new File(chooseFile.getSelectedFile().getAbsolutePath());
	 
			FileManagement upload = new FileManagement();
		 
	 		try {
				upload.upload_file_in_database(file, eventID , file.getName());
	 		} catch (FileNotFoundException e) { 
				message.errorMessage("File Not found");
			} catch (SQLException e) { 
				message.errorMessage("Wrong File Type");
			}  
		}
	}
}
