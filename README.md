# HKOWeather-API [![Build Status](https://travis-ci.org/mob41/HKOWeather-API.svg?branch=master)](https://travis-ci.org/mob41/HKOWeather-API)
An API for fetching weather from Hong Kong Observatory.
[Latest Release (No dependency control)](https://github.com/mob41/HKOWeather-API/releases/latest)

## Dependency
The API depends on JSON. The old/deprecated API depends on ROME v1.0, JSoup v1.8.3, JDom v1.1.3

If you clone/fork this project to your IDE, probably Maven will take care everything including dependency.
## Functions
1. (Deprecated) Get HKO Weather Image, Temperature with just one function.
2. Get temperature, humidity, wind speed, day 1-7 weather report, etc.
3. Automatic interval fetching weather report

## JavaDoc
A javadoc is also uploaded for reference.
[http://mob41.github.io/HKOWeather-API/javadoc/](http://mob41.github.io/HKOWeather-API/javadoc/)

## Example
More examples: [API Tests](https://github.com/mob41/HKOWeather-API/tree/master/src/test/java/com/mob41/hkoweather/tests)
<pre>
WeatherManager man = new WeatherManager("HKO");
man.fetchWeatherReport();
man.setFetchInterval("20000"); //Default 60 seconds (60000 ms)
man.startFetchInterval(); //The manager will start to fetch a new report every 20 seconds.
System.out.println("The temperature: " + man.getWeatherReport().getTemp());
</pre>

## Deprecation
The whole <b>HKO</b> class is deprecated.
The code from the old release is unusable if the RSS feed changed the indexes of the table columns.

Instead, you are recommended to use a WeatherManager to get the weather:
<pre>
WeatherManager man = new WeatherManager("HKO");
man.fetchWeatherReport();
WeatherReport report = man.getWeatherReport();
System.out.println(report.getTemp());
</pre>