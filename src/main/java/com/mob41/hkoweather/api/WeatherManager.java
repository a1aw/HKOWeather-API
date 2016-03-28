package com.mob41.hkoweather.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import com.mob41.hkoweather.exception.FetchWeatherException;
import com.mob41.hkoweather.exception.InvaildReportException;
import com.mob41.hkoweather.exception.InvaildStationException;
import com.mob41.hkoweather.thread.WeatherFetchInterval;

/***
 * <h4>WeatherManager</h4>
 * <pre>public class WeatherManager</pre>
 * A weather manager which manages the weather report.<br>
 * Automatically fetching weather report from HKO if specified.
 * @author Anthony
 *
 */
public class WeatherManager {
	
	private static final String url = "http://pda.weather.gov.hk/locspc/android_data/regional_weather_";
	private static final String fileType = ".xml";
	private static final String[] knownLocations = {"HKO", "WTS"};
	private static final int defaultLocation = 0;
	private static final int defaultInterval = 60000;
	
	private Thread thread;
	
	private WeatherFetchInterval runnable;
	
	private int fetchInterval = defaultInterval;
	
	private String station = knownLocations[defaultLocation];
	
	private WeatherReport report;
	
	/***
	 * <h4>WeatherManager</h4>
	 * <pre>public WeatherManager() throws InvaildStationException</pre>
	 * Create a new weather manager.<br>
	 * <br>
	 * Using default Tsim Sha Tsui HKO Weather Station.
	 * @throws InvaildStationException if default station code goes wrong.
	 */
	public WeatherManager() throws InvaildStationException{
		this(knownLocations[defaultLocation]);
	}
	
	/***
	 * <h4>WeatherManager</h4>
	 * <pre>public WeatherManager(int station) throws InvaildStationException</pre>
	 * Create a new weather manager.
	 * @param station - Specify a weather station code's INDEX
	 * @throws InvaildStationException if the specified index was invalid.
	 */
	public WeatherManager(int station) throws InvaildStationException{
		this.station = knownLocations[station];
	}
	
	/***
	 * <h4>WeatherManager</h4>
	 * <pre>public WeatherManager(String station) throws InvaildStationException</pre>
	 * Create a new weather manager
	 * @param station - Specify a weather station code, e.g. HKO, WTS
	 * @throws InvaildStationException if the specified was invalidd.
	 */
	public WeatherManager(String station) throws InvaildStationException{
		int index = getStationIndex(station);
		if (index == -1){
			throw new InvaildStationException("The station code you specified was invalid.");
		}
		this.station = station;
	}
	
	/***
	 * <h4>getWeatherReport</h4>
	 * <pre>public WeatherReport getWeatherReport()</pre>
	 * Get the weather report of the weather manager.<br>
	 * You have to call this function: 
	 * <pre>fetchWeatherReport()</pre> 
	 * to get the weather report. Or you will receive a
	 * non-initialized WeatherReport.
	 * @return <b>WeatherReport</b> - A weather report fetched from HKO or a non-initialized variable.
	 */
	public WeatherReport getWeatherReport(){
		return report;
	}
	
	/***
	 * <h4>loadReport</h4>
	 * <pre>public void loadReport(WeatherReport report)</pre>
	 * Load a weather report to the manager.
	 * @param report A weather report generated or created.
	 */
	public void loadReport(WeatherReport report){
		this.report = report;
	}
	
	/***
	 * <h4>setFetchInterval</h4>
	 * <pre>public void setFetchInterval(int ms)</pre>
	 * Set the fetching interval of the weather report.<br>
	 * To start the interval, remember to call:
	 * <pre>
	 * startFetchInterval()
	 * </pre>
	 * @param ms Interval in milliseconds.
	 */
	public void setFetchInterval(int ms){
		this.fetchInterval = ms;
	}
	
	/***
	 * <h4>resetFetchInterval</h4>
	 * <pre>public void resetFetchInterval(int ms)</pre>
	 * Resets the interval to default interval. (60000 ms)
	 */
	public void resetFetchInterval(){
		this.fetchInterval = defaultInterval;
	}
	
	/***
	 * <h4>startFetchInterval</h4>
	 * <pre>public void startFetchInterval()</pre>
	 * Start fetch interval thread.
	 */
	public void startFetchInterval(){
		runnable = new WeatherFetchInterval(thread, this, fetchInterval);
		thread = new Thread(runnable);
		thread.setName("FetchInterval-" + thread.getId());
		thread.start();
	}
	
	/***
	 * <h4>stopFetchInterval</h4>
	 * <pre>public void stopFetchInterval()</pre>
	 * Stop fetch interval thread.
	 */
	public void stopFetchInterval(){
		runnable.stop();
		thread.interrupt();
	}
	
	/***
	 * <h4>fetchWeatherReport</h4>
	 * <pre>public WeatherReport fetchWeatherReport()</pre>
	 * Fetch the weather report from Hong Kong Observatory.<br>
	 * with the weather station specified before.
	 * @return <b>WeatherReport</b> - with all the weather-related data.
	 * @throws FetchWeatherException Could not fetch the weather report successfully.
	 * @throws InvaildReportException The report fetched was invalid.
	 */
	public WeatherReport fetchWeatherReport() throws FetchWeatherException, InvaildReportException{
		URLConnection connection;
		try {
			connection = new URL(url + station + fileType).openConnection();
			connection.setDoOutput(false);
			connection.getInputStream();
			
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			try {

				br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			JSONObject json = new JSONObject(sb.toString());
			report = new WeatherReport(this.station);
			report.setStationCode(json.getString("StationCode"));
			report.setStationName_en(json.getString("StationNameEn"));
			report.setStationName_zh(json.getString("StationNameZh"));
			report.setUpdateTime(json.getString("BulletinTime"));
			report.setTemp(Float.parseFloat(json.getString("Temperature")));
			report.setTempAround(Integer.parseInt(json.getString("Temperature_AroundtoOdd")));
			report.setHumidity(Integer.parseInt(json.getString("RH")));
			report.setWindDirectionCode(json.getString("WindDirectionCode"));
			report.setWindDirection_en_shortform(json.getString("WindDirectionShortformEn"));
			return report;
		} catch (MalformedURLException e1) {
			throw new FetchWeatherException("The specified station code was invalid.");
		} catch (IOException e1) {
			throw new FetchWeatherException("Could not connect to server.");
		} catch (JSONException e1){
			throw new InvaildReportException("The weather report fetched was invalid.");
		}
	}
	
	private static int getStationIndex(String station){
		for (int i = 0; i < knownLocations.length; i++){
			if (knownLocations[i].equals(station)){
				return i;
			}
		}
		return -1;
	}
	
}
