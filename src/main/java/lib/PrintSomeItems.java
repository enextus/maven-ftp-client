package lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class PrintSomeItems {

	public static void printFileDetails(FTPFile[] files) {
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("\n");
		for (FTPFile file : files) {
			String details = file.getName();
			if (file.isDirectory()) {
				details = "[" + details + "]";
			}
			details += "\t\t" + file.getSize();
			details += "\t\t" + dateFormatter.format(file.getTimestamp().getTime());

			System.out.println("Details: " + details);
		}
	}

	public static void printNames(String[] files) {
		System.out.println("\n");
		if (files != null && files.length > 0) {
			for (String aFile : files) {
				System.out.println("aFile: " + aFile);
			}
		}
	}

	public static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		System.out.println("\n");
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER REPLY: " + aReply);
			}
		}
	}

}
