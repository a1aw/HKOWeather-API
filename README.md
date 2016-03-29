# HKOWeather-API [![Build Status](https://travis-ci.org/mob41/HKOWeather-API.svg?branch=master)](https://travis-ci.org/mob41/HKOWeather-API)
An API for fetching weather from Hong Kong Observatory.<br>
Version: 0.0.1-SNAPSHOT [[Latest Release]](https://github.com/mob41/HKOWeather-API/releases/latest) JavaDoc: [[Link]](http://mob41.github.io/HKOWeather-API/javadoc/)

## Dependency
The API depends on JSON. The old/deprecated API depends on ROME v1.0, JSoup v1.8.3, JDom v1.1.3

If you use the "HKOWeather-API-x.x.x-jar-with-dependencies.jar", the dependencies were packed inside the jar.<br>
If you clone/fork this project to your IDE, probably Maven will take care everything including dependency.
## Functions
1. (Deprecated) Get HKO Weather Image, Temperature with just one function.
2. Get temperature, humidity, wind speed, day 1-7 weather report, etc.
3. Automatic interval fetching weather report

 __**New API vs Old(deprecated) API**__
 1. Get weather, code from old deprecated API: (The old API only can get temperature)
 <pre>
 System.out.println(HKO.getTemp(23)); //The number 23 is a index from a HTML Table. So if the index is changed. The code is probably unusable.
 </pre>
 2. Get weather, code from new API:
 <pre>
 System.out.println("Temp: " + new WeatherManager().fetchWeatherReport().getTemp());
 //or
 WeatherManager man = new WeatherManager();
 man.fetchWeatherReport();
 System.out.println(""
				+ "Weather Station Code: " + report.getStationCode()
				+ "\nWeather Station Name in EN: " + report.getStationNameInEN()
				+ "\nWeather Station Name in ZH: " + report.getStationNameInZH()
				+ "\nThe temperature is: " + report.getTemp()
				+ "\nThe around temperature is: " + report.getTempAround()
				+ "\nHumidity: " + report.getHumidity()
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
 </pre>
 Mostly all the weather-related data are fetched.<br>
 Besides, you can update the weather with a time interval.
 <pre>
 man.setFetchInterval(30000);
 man.startFetchInterval();
 </pre>

## Example
More examples: [API Tests](https://github.com/mob41/HKOWeather-API/tree/master/src/test/java/com/mob41/hkoweather/tests)
<pre>
WeatherManager man = new WeatherManager("HKO");
System.out.println("The temperature: " + man.getWeatherReport().getTemp());
</pre>

## Deprecation
The whole <b>HKO</b> class is deprecated.
The code from the old release is unusable if the RSS feed changed the indexes of the table columns.