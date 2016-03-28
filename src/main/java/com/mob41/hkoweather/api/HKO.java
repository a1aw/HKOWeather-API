package com.mob41.hkoweather.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


/**
 * <h4>Hong Kong Observatory Weather RSS Feed API for Java</h4>
 * <p>
 * HKO doesn't have a open-source API for its weather report.
 * (Except the paid-service of the XML weather system)
 * <p>
 * This is a API for Java Developers in Hong Kong to get weather
 * reports of HKO.
 * <p>
 * This API depends on:
 * <br>
 * ROME v1.0, JSoup v1.8.3, JDOM v1.1.3
 * @author Anthony Law (mob41)
 * @deprecated <br>
 * The code is unusable if the RSS feed changed the indexes of the<br>
 * table columns.<br>
 * <br>
 * Instead, you are recommended to use a WeatherManager to get the weather:
 * <pre>
 * WeatherManager man = new WeatherManager("HKO");
 * man.fetchWeatherReport();
 * WeatherReport report = man.getWeatherReport();
 * System.out.println(report.getTemp());
 * </pre>
 */

public class HKO {
	
	/**
	 * Hong Kong Observatory Temperature RSS Feed URL (Updated Hourly)
	 * 
	 */
	private static final String hkoFeedURL = "http://rss.weather.gov.hk/rss/CurrentWeather_uc.xml";

	/**
	    * To get RSS feed from Hong Kong Observatory RSS Feed Weather Report.
	    * 
	    * In SyndFeed Type, provided by ROME.
	    * 
	    * @return Returns a SyndFeed of HKO Weather RSS feed. If the RSS server is down or no connection, the function will return null;
	    * 
	    * @throws IOException Wrong XML Format Wrong XML Format
	    * @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. Could not connect to RSS feed, Wrong RSS Feed Format.
	    * @throws IllegalArgumentException Wrong RSS Feed Format. Wrong RSS Feed Format.
	    * @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	    */
	public static SyndFeed getRSS() throws IllegalArgumentException, FeedException, IOException
	{
		SyndFeedInput input = new SyndFeedInput();
		URL feedurl = new URL(hkoFeedURL);
		SyndFeed feed;
		feed = input.build(new XmlReader(feedurl));
		return feed;
	}
	
	/**
	    * Get the hourly weather status image from the RSS Feed Weather Report.
	    * <p>
	    * You don't need to use getRSS() again as this function reads the readings of RSS itself.
	    * <br>
	    * If it received null from the getTempDescription(), it returns null, to prevent NullPointerException.
	    * @return BufferedImage: The Weather status image from the RSS Feed Weather Report.
	    * 
	    * @throws IOException Wrong XML Format Wrong XML Format
	    * @throws MalformedURLException The target RSS Feed URL format is wrong
	    * @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	 * @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. Could not connect to RSS feed, Wrong RSS Feed Format.
	 * @throws IllegalArgumentException Wrong RSS Feed Format. Wrong RSS Feed Format.
	    */
	public static BufferedImage getWeatherImage() throws MalformedURLException, IOException, IllegalArgumentException, FeedException
	{
		Document desc = getTempDescription();
		if (desc == null){
			return null;
		}
		Element img = desc.select("img").first();
		String url = img.absUrl("src");
		BufferedImage bimg = null;
		bimg = ImageIO.read(new URL(url));
		return bimg;
	}
	
	/**
	    * Get the Temperature from the RSS Feed Weather Report.
	    * 
	    * @param locationState  it is the number of a specific table object in the RSS report. The number cannot be 0. 
	    * Or a IndexOutOfBounds Exception will happen. locationState represents a place which is monitored of its weather by HKO. The locationState should only
	    * ranging to 1 - 26.
	    * 
	    * @return The temperature from the RSS feed weather report.
	    * It returns 5000 (Impossible outdoor temperature) to tell there is a error, no connection, etc...
	    * 
	    * @throws ParseException The string (Table Column that includes the temperature and the text) doesn't have any integer.
	    * @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	 * @throws IOException Wrong XML Format 
	 * @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. 
	 * @throws IllegalArgumentException Wrong RSS Feed Format. 
	    */
	public static int getTemp(int locationState) throws ParseException, IllegalArgumentException, FeedException, IOException
	{
		locationState--;
		Iterator<Element> ite = getTempTableCol();
		if (ite == null){
			return 5000;
		}
		for (int i = 0; i < locationState; i++)
		{
			ite.next();
		}
		int temp = 0;
		temp = ((Number)NumberFormat.getInstance().parse(ite.next().text())).intValue();
		return temp;
	}
	
	/**
	    * Get RSS Entries from the HKO Weather RSS Feed.
	    * 
	    * It is a API function for developers. It actually
	    * <br>
	    * does nothing.
	    * 
	    * @return List: Returns a list of SyndEntryImpl (Feed Entries)
	    * It returns null if RSS feed is null (No Connection, error etc...)
	    * 
	 	* @throws IOException Wrong XML Format 
	    * @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. 
	    * @throws IllegalArgumentException Wrong RSS Feed Format. 
	    * @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	    */
	public static List<SyndEntryImpl> getRSSEntries() throws IllegalArgumentException, FeedException, IOException{
		SyndFeed feed = getRSS();
		if (feed == null)
		{
			return null;
		}
		return feed.getEntries();
	}
	
	/**
	    * Get HKO Temperature RSS Description (HTML Table Code)
	    * <p>
	    * It is a API function for developers. It actually
	    * <br>
	    * does nothing.
	    * 
	    * @return Document: Returns a document with HKO Temperature Data parsed by Jsoup.
	    * It returns null if RSS entries are null (No Connection, error etc...)
	    * 
		* @throws IOException Wrong XML Format 
		* @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. 
		* @throws IllegalArgumentException Wrong RSS Feed Format. 
	 	* @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	    */
	public static Document getTempDescription() throws IllegalArgumentException, FeedException, IOException
	{
		List<SyndEntryImpl> entries = getRSSEntries();
		if (entries == null)
		{
			return null;
		}
		String hkorss = entries.get(0).getDescription().getValue();
		return Jsoup.parse(hkorss);
	}
	
	/**
	    * Get the table element from the HKO Temperature Data of the document parsed by Jsoup.
	    * <br>
	    * The collection of the table element is done using Jsoup.
	    * <p>
	    * It is a API function for developers. It actually
	    * <br>
	    * does nothing.
	    * 
	    * @return The Table Element with the Temperature Data.
	    * It returns null if the Temperature Data RSS Description is null. (No Connection, Not parsable, etc.)
	    * 
	    * @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	 * @throws IOException Wrong XML Format 
	 * @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. 
	 * @throws IllegalArgumentException Wrong RSS Feed Format. 
	    */
	public static Element getTempTable() throws IllegalArgumentException, FeedException, IOException
	{
		Document desc = getTempDescription();
		if (desc == null){
			return null;
		}
		return desc.select("table").first();
	}
	
	/**
	    * Get the Iterator of Element from the Temperature Data Table
	    * <p>
	    * It is a API function for developers. It actually
	    * <br>
	    * does nothing.
	    * 
	    * @return Return a iterator of all the columns of the table. (Jsoup call it elements)
	    * It returns null if the table is null. (No connection, error, not parsable, etc..)
	    * @deprecated <br>
	    * The code is unusable if the RSS feed changed the indexes of the<br>
	    * table columns.<br>
	    * <br>
	    * Instead, you are recommended to use a WeatherManager to get the weather:
	    * <pre>
	    * WeatherManager man = new WeatherManager("HKO");
	    * man.fetchWeatherReport();
	    * WeatherReport report = man.getWeatherReport();
	    * System.out.println(report.getTemp());
	    * </pre>
	    * @author Anthony Law(mob41)
	 * @throws IOException Wrong XML Format 
	 * @throws FeedException Could not connect to RSS feed, Wrong RSS Feed Format. 
	 * @throws IllegalArgumentException Wrong RSS Feed Format. 
	    */
	public static Iterator<Element> getTempTableCol() throws IllegalArgumentException, FeedException, IOException
	{
		Element table = getTempTable();
		if (table == null){
			return null;
		}
		return table.select("td[width=100]").iterator();
	}
}
