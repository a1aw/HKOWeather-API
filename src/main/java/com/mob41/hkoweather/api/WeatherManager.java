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
 * <h3>WeatherManager</h3>
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
	
	public Thread thread;
	
	private WeatherFetchInterval runnable;
	
	private int fetchInterval = defaultInterval;
	
	private String station = knownLocations[defaultLocation];
	
	private WeatherReport report;
	
	/***
	 * <h3>WeatherManager</h3>
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
	 * <h3>WeatherManager</h3>
	 * <pre>public WeatherManager(int station) throws InvaildStationException</pre>
	 * Create a new weather manager.
	 * @param station - Specify a weather station code's INDEX
	 * @throws InvaildStationException if the specified index was invalid.
	 */
	public WeatherManager(int station) throws InvaildStationException{
		this.station = knownLocations[station];
	}
	
	/***
	 * <h3>WeatherManager</h3>
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
	 * <h3>getWeatherReport</h3>
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
	 * <h3>loadReport</h3>
	 * <pre>public void loadReport(WeatherReport report)</pre>
	 * Load a weather report to the manager.
	 * @param report A weather report generated or created.
	 */
	public void loadReport(WeatherReport report){
		this.report = report;
	}
	
	/***
	 * <h3>setFetchInterval</h3>
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
	 * <h3>resetFetchInterval</h3>
	 * <pre>public void resetFetchInterval(int ms)</pre>
	 * Resets the interval to default interval. (60000 ms)
	 */
	public void resetFetchInterval(){
		this.fetchInterval = defaultInterval;
	}
	
	/***
	 * <h3>startFetchInterval</h3>
	 * <pre>public void startFetchInterval()</pre>
	 * Start fetch interval thread.
	 */
	public void startFetchInterval(){
		runnable = new WeatherFetchInterval(this, fetchInterval);
		thread = new Thread(runnable);
		thread.setName("FetchInterval-" + thread.getId());
		thread.start();
	}
	
	/***
	 * <h3>stopFetchInterval</h3>
	 * <pre>public void stopFetchInterval()</pre>
	 * Stop fetch interval thread.
	 */
	public void stopFetchInterval(){
		runnable.stop();
		thread.interrupt();
	}
	
	/***
	 * <h3>fetchWeatherReport</h3>
	 * <pre>public WeatherReport fetchWeatherReport() throws FetchWeatherException, InvaildReportException</pre>
	 * Fetch the weather report from Hong Kong Observatory.<br>
	 * with the weather station specified before.<br>
	 * <br>
	 * Using the report inside the manager.
	 * @return <b>WeatherReport</b> - with all the weather-related data.
	 * @throws FetchWeatherException Could not fetch the weather report successfully.
	 * @throws InvaildReportException The report fetched was invalid.
	 */
	public WeatherReport fetchWeatherReport() throws FetchWeatherException, InvaildReportException{
		return fetchWeatherReport(this.report);
	}
	
	/***
	 * <h3>fetchWeatherReport</h3>
	 * <pre>public WeatherReport fetchWeatherReport(WeatherReport report) throws FetchWeatherException, InvaildReportException</pre>
	 * Fetch the weather report from Hong Kong Observatory.<br>
	 * with the weather station specified before.
	 * @param report Specify a weather report to be updated.
	 * @return <b>WeatherReport</b> - with all the weather-related data.
	 * @throws FetchWeatherException Could not fetch the weather report successfully.
	 * @throws InvaildReportException The report fetched was invalid.
	 */
	public WeatherReport fetchWeatherReport(WeatherReport report) throws FetchWeatherException, InvaildReportException{
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
			report = new WeatherReport(this);
			report.setStationCode(json.getString("StationCode"));
			report.setStationName_en(json.getString("StationNameEn"));
			report.setStationName_zh(json.getString("StationNameZh"));
			report.setUpdateTime(json.getString("BulletinTime"));
			report.setTemp(Float.parseFloat(json.getString("Temperature")));
			report.setTempAround(Integer.parseInt(json.getString("Temperature_AroundtoOdd")));
			report.setHumidity(Integer.parseInt(json.getString("RH")));
			report.setWindDirectionCode(json.getString("WindDirectionCode"));
			report.setWindDirection_en(json.getString("WindDirectionEn"));
			report.setWindDirection_en_shortform(json.getString("WindDirectionShortformEn"));
			report.setWindDirection_zh(json.getString("WindDirectionZh"));
			report.setWindDirection_zh_shortform(json.getString("WindDirectionShortformZh"));
			if (!json.get("WindSpeedKm").equals(null)){
				report.setWindSpeed(Float.parseFloat(json.getString("WindSpeedKm")));
			}
			report.setMeanSeaLevelPressure(Float.parseFloat(json.getString("MeanSeaLevelPressure")));
			report.setTenMinuteMeanVisibility(Integer.parseInt(json.getString("TenMinuteMeanVisibility")));
			report.setMaxTemp(Float.parseFloat(json.getString("MaxTemperature")));
			report.setMaxTempAround(Integer.parseInt(json.getString("MaxTemperature_AroundtoOdd")));
			report.setMinTemp(Float.parseFloat(json.getString("MinTemperature")));
			report.setMinTempAround(Integer.parseInt(json.getString("MinTemperature_AroundtoOdd")));
			report.setHomeMaxTemp(Integer.parseInt(json.getString("HomeMaxTemperature")));
			report.setHomeMinTemp(Integer.parseInt(json.getString("HomeMinTemperature")));
			return report;
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			throw new FetchWeatherException("The specified station code was invalid.");
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new FetchWeatherException("Could not connect to server.");
		} catch (JSONException e1){
			e1.printStackTrace();
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
