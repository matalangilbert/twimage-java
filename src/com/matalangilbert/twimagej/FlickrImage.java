package com.matalangilbert.twimagej;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.REST;
import com.aetrion.flickr.Transport;
import com.aetrion.flickr.photos.Photo;
import com.aetrion.flickr.photos.PhotoList;
import com.aetrion.flickr.photos.PhotosInterface;
import com.aetrion.flickr.photos.SearchParameters;



/**
 * Wrapper class for the Flickr API.
 * Requires a flickrj.properties file in the root of the application directory. See README for more details.
 * @author Mat Alan Gilbert
 */
public class FlickrImage {
	private static String _apiKey=null;
	private static String _secret=null;
	private final int NUMBER_OF_IMAGES = 400;
	
	private BufferedImage _mediumImage=null;;
	
	public FlickrImage() {
		if (_apiKey == null) {
			LoadProperties();
		}
	}
	
	/**
	 * Get the next medium sized image from Flickr.
	 * @return a new medium sized image
	 */
	public BufferedImage getNextMediumImage() {
		UpdateImage();
		return _mediumImage;
	}
	
	//TODO: refactor to method-level SRP
	private void UpdateImage() {
		try {
			Transport t = new REST();
			Flickr f = new Flickr(_apiKey,_secret,t);
			
			// set up Flickr search query
			SearchParameters searchParams = new SearchParameters();
			searchParams.setSort(SearchParameters.INTERESTINGNESS_DESC);
			searchParams.setSafeSearch("2");
			String[] tags = new String[]{"happy", 
					"smile",
					"yes"};
			searchParams.setTags(tags);
			
			PhotosInterface photosInterface = f.getPhotosInterface(); // use to search photos - see Flickr api for more details.
			PhotoList photoList = photosInterface.search(searchParams, NUMBER_OF_IMAGES, 1); // search Flickr
			Random rand = new Random();
			
			Photo photo = (Photo)photoList.get(rand.nextInt(NUMBER_OF_IMAGES)); // select random image from search results.
			
			_mediumImage = ImageIO.read(new URL(photo.getMediumUrl())); // download and buffer medium-sized image.
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FlickrException e) {
			e.printStackTrace();
		}
	}
	
	private static void LoadProperties() {
		Properties flickrProperties = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("flickrj.properties");
			flickrProperties.load(in);
			in.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Flickr properties file not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!flickrProperties.containsKey("apiKey") || 
					!flickrProperties.containsKey("secret")) {
				System.out.println("Flickr properties not found");
				System.exit(-1);
			} else {
				_apiKey = flickrProperties.getProperty("apiKey");
				_secret = flickrProperties.getProperty("secret");
			}
		}
	}
}
