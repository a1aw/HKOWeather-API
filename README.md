# HKOWeather-API
An API for fetching weather from Hong Kong Observatory.

## Functions
1. (Deprecated) Get HKO Weather Image, Temperature with just one function.
2. Get temperature, humidity, wind speed, day 1-7 weather report, etc.
3. Automatic interval fetching weather report

## JavaDoc
A javadoc is also uploaded for reference.
[http://mob41.github.io/HKOWeather-API/javadoc/](http://mob41.github.io/HKOWeather-API/javadoc/)

## Example
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