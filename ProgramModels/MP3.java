package ProgramModels;

import java.io.File;
import java.io.IOException;

import mp3agic.ID3v1;
import mp3agic.ID3v2;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;

public class MP3
{
	Mp3File mp3;
	ID3v1 ID3v1Tag;
	ID3v2 ID3v2Tag;
	
	public MP3(File MP3Location)
	{
		try
		{
			mp3 = new Mp3File(MP3Location.toString());
		}
		catch (UnsupportedTagException | InvalidDataException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(this.mp3.hasId3v2Tag())
		{
			this.ID3v2Tag = mp3.getId3v2Tag();
			this.ID3v2Tag = null;
		}
		else if(this.mp3.hasId3v1Tag())
		{
			this.ID3v1Tag = mp3.getId3v1Tag();
			this.ID3v1Tag = null;
		}
		else
		{
			this.ID3v1Tag = null;
			this.ID3v2Tag = null;
			//TODO Error out with no ID3 tag || Create ID3 Tag?
		}
	}
}