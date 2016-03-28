package com.mob41.hkoweather.tests;

import org.junit.Test;

import com.mob41.hkoweather.api.WeatherManager;
import com.mob41.hkoweather.api.WeatherReport;

public class GetTempTest {

	@Test
	public void test() throws Exception {
		WeatherManager man = new WeatherManager();
		man.fetchWeatherReport();
		WeatherReport report = man.getWeatherReport();
		System.out.println("---------------------------------------------");
		System.out.println("   WEATHER REPORT FETCHED");
		System.out.println("---------------------------------------------");
		System.out.println(""
				+ "Weather Station Code: " + report.getStationCode()
				+ "\nWeather Station Name in EN: " + report.getStationNameInEN()
				+ "\nWeather Station Name in ZH: " + report.getStationNameInZH()
				+ "\nThe temperature is: " + report.getTemp()
				+ "\nThe around temperature is: " + report.getTempAround()
				+ "\nHumidity: " + report.getHumidity() + "%"
				+ "\nWind Direction code: " + report.getWindDirectionCode()
				+ "\nWind Direction English: " + report.getWindDirectionInEN()
				+ "\nWind Direction Chinese: " + report.getWindDirectionInZH()
				+ "\nWind Direction Shortform English: " + report.getWindDirectionShortformInEN()
				+ "\nWind Direction Shortform Chinese: " + report.getWindDirectionShortformInZH()
				+ "\nWind Speed: " + report.getWindSpeed()
				+ "\nMean Sea Level Pressure: " + report.getMeanSeaLevelPressure()
				+ "\nTen Min Mean Visibility: " + report.getTenMinuteMeanVisibility()
				+ "\nMax Temp: " + report.getMaxTemp()
				+ "\nMin Temp: " + report.getMinTemp()
				+ "\nMax Temp Around: " + report.getMaxTempAround()
				+ "\nMin Temp Around: " + report.getMinTempAround()
				+ "\nHome Max Temp: " + report.getHomeMaxTemp()
				+ "\nHome Min Temp: " + report.getHomeMinTemp()
				);
		System.out.println("---------------------------------------------");
		System.out.println("    END GET WEATHER TEST");
		System.out.println("---------------------------------------------");
	}

}