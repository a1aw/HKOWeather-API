package com.mob41.hkoweather.tests;

import com.mob41.hkoweather.api.WeatherManager;
import com.mob41.hkoweather.api.WeatherReport;

public class GetTempTest {

	public static void main(String[] args) throws Exception {
		WeatherManager man = new WeatherManager("HKO");
		man.fetchWeatherReport();
		WeatherReport report = man.getWeatherReport();
		System.out.println("Weather Station Code: " + report.getStationCode());
		System.out.println("Weather Station Name in EN: " + report.getStationNameInEN());
		System.out.println("Weather Station Name in ZH: " + report.getStationNameInZH());
		System.out.println("The temperature is: " + report.getTemp());
	}

}