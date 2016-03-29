package com.mob41.hkoweather.api;

public class WeatherReport {
	
	//Data from regional_weather_XXX.xml --START
	private String stationcode = null;
	
	private String stationNameEn = null;
	
	private String stationNameZh = null;
	
	private String updateTime = null;
	
	private float temp = 0;
	
	private int temp_around = 0;
	
	private int humidity = 0;
	
	private String windDirectionCode = null;
	
	private String windDirectionEn = null;
	
	private String windDirectionShortformEn = null;
	
	private String windDirectionZh = null;
	
	private String windDirectionShortformZh = null;
	
	private float windSpeedKm = 0;
	
	//private String windSpeedKnot = null;
	
	private float MeanSeaLevelPressure = 0;
	
	private int TenMinuteMeanVisibility = 0;
	
	private float MaxTemperature = 0;
	
	private int MaxTemperature_around = 0;
	
	private float MinTemperature = 0;
	
	private int MinTemperature_around = 0;
	
	private int HomeMaxTemperature = 0;
	
	private int HomeMinTemperature = 0;
	//--END
	
	//
	/***
	 * <h3>WeatherReport</h3>
	 * <pre>public WeatherReport(String stationcode)</pre>
	 * Create a new weather report.
	 * @param stationcode - To classify this weather report to a specific Weather Station.
	 */
	public WeatherReport(String stationcode){
		this.stationcode = stationcode;
	}
	
	/***
	 * <h3>setStationCode</h3>
	 * <pre>public void setStationCode(String stationcode)</pre>
	 * Set the weather station code of this report
	 * @param stationcode - Weather Station Code. e.g. HKO, WTS..etc
	 */
	public void setStationCode(String stationcode){
		this.stationcode = stationcode;
	}
	
	/***
	 * <h3>getStationCode</h3>
	 * <pre>public String getStationCode()</pre>
	 * Get the weather station code of this weather report.
	 * @return A weather station code. e.g. HKO, WTS...etc.
	 */
	public String getStationCode(){
		return this.stationcode;
	}
	
	/***
	 * <h3>setStationName_zh</h3>
	 * <pre>public void setStationName_zh(String name)</pre>
	 * Set the weather station's Chinese name of this report
	 * @param name - Weather Station's Chinese name.
	 */
	public void setStationName_zh(String name){
		this.stationNameZh = name;
	}
	
	/***
	 * <h3>getStationNameInZH</h3>
	 * <pre>public String getStationNameInZH()</pre>
	 * Get the weather station's Chinese name of this report
	 * @return Weather Station's Chinese name.
	 */
	public String getStationNameInZH(){
		return this.stationNameZh;
	}
	
	/***
	 * <h3>setStationName_en</h3>
	 * <pre>public void setStationName_en(String name)</pre>
	 * Set the weather station's English name of this report
	 * @param name - Weather Station's English name.
	 */
	public void setStationName_en(String name){
		this.stationNameEn = name;
	}
	
	/***
	 * <h3>getStationNameInEN</h3>
	 * <pre>public String getStationNameInEN()</pre>
	 * Get the weather staiton's English name of this report
	 * @return Weather Station's English name.
	 */
	public String getStationNameInEN(){
		return this.stationNameEn;
	}
	
	/***
	 * <h3>setUpdateTime</h3>
	 * <pre>public void setUpdateTime(String time)</pre>
	 * Set the update time of the weather of this report. (Provided by HKO)
	 * @param time - Time described in String.
	 */
	public void setUpdateTime(String time){
		this.updateTime = time;
	}
	
	/***
	 * <h3>getUpdateTime</h3>
	 * <pre>public String getUpdateTime()</pre>
	 * Get the update time of the weather of this report (Provided by HKO)
	 * @return Time described in String.
	 */
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	/***
	 * <h3>setTemp</h3>
	 * <pre>public void setTemp(float temp)</pre>
	 * Set the temperature of the weather of this report.
	 * @param temp - Float number of the temperature.
	 */
	public void setTemp(float temp){
		this.temp = temp;
	}
	
	/***
	 * <h3>getTemp</h3>
	 * <pre>public float getTemp()</pre>
	 * Get the temperature of the weather of this report.
	 * @return Float number of the temperature
	 */
	public float getTemp(){
		return this.temp;
	}
	
	/***
	 * <h3>setTempAround</h3>
	 * <pre>public void setTempAround(int temp)</pre>
	 * Set the temperature around (rounded) of the weather of this report.
	 * @param temp Integer of the temperature around (rounded) 
	 */
	public void setTempAround(int temp){
		this.temp_around = temp;
	}
	
	/***
	 * <h3>getTempAround</h3>
	 * <pre>public int getTempAround()</pre>
	 * Get the temperature around (rounded) of the weather of this report.
	 * @return Integer of the temperature around (rounded)
	 */
	public int getTempAround(){
		return this.temp_around;
	}
	
	/***
	 * <h3>setHumidity</h3>
	 * <pre>public void setHumidity(int humidity)</pre>
	 * Set the humidity of the weather of this report.
	 * @param humidity Humidity of the weather
	 */
	public void setHumidity(int humidity){
		this.humidity = humidity;
	}
	
	/***
	 * <h3>getHumidity</h3>
	 * <pre>public int getHumidity()</pre>
	 * Get the humidity of the weather of this report.
	 * @return Humidity of the weather of this report.
	 */
	public int getHumidity(){
		return this.humidity;
	}
	
	/***
	 * <h3>setWindDirectionCode</h3>
	 * <pre>setWindDirectionCode(String windDirectionCode)</pre>
	 * @param windDirectionCode Wind Direction Code. e.g. NE / SE, etc...
	 */
	public void setWindDirectionCode(String windDirectionCode){
		this.windDirectionCode = windDirectionCode;
	}
	
	/***
	 * <h3>getWindDirectionCode</h3>
	 * <pre>public String getWindDirectionCode()</pre>
	 * Get the Wind Direction Code from this report.
	 * @return Wind Direction Code.
	 */
	public String getWindDirectionCode(){
		return this.windDirectionCode;
	}
	
	/***
	 * <h3>setWindDirection_en</h3>
	 * <pre>public void setWindDirection_en(String windDirection_en)</pre>
	 * Set the Wind Direction in English to this report.
	 * @param windDirection_en Wind Direction Description in English
	 */
	public void setWindDirection_en(String windDirection_en){
		this.windDirectionEn = windDirection_en;
	}
	
	/***
	 * <h3>getWindDirectionInEn</h3>
	 * <pre>public String getWindDirectionInEN()</pre>
	 * Get the wind direction in English of this report.
	 * @return Wind Direction Description in English
	 */
	public String getWindDirectionInEN(){
		return this.windDirectionEn;
	}
	
	/***
	 * <h3>setWindDirection_en_shortform</h3>
	 * <pre>public void setWindDirection_en_shortform(String windDirection_en_shortform)</pre>
	 * Set the short-form of the wind direction in English to this report.
	 * @param windDirection_en_shortform Wind Direction Description Short-form
	 */
	public void setWindDirection_en_shortform(String windDirection_en_shortform){
		this.windDirectionShortformEn = windDirection_en_shortform;
	}
	
	/***
	 * <h3>getWindDirectionShortformInEN()</h3>
	 * <pre>public String getWindDirectionShortformInEN()</pre>
	 * Get the short-form of the wind direction in English of this report
	 * @return Wind Direction Description Short-form
	 */
	public String getWindDirectionShortformInEN(){
		return this.windDirectionShortformEn;
	}
	
	/***
	 * <h3>setWindDirection_zh</h3>
	 * <pre>public void setWindDirection_zh(String windDirection_zh)</pre>
	 * Set the Wind Direction Description in Chinese to this report
	 * @param windDirection_zh Wind Direction Description in Chinese
	 */
	public void setWindDirection_zh(String windDirection_zh){
		this.windDirectionZh = windDirection_zh;
	}
	
	/***
	 * <h3>getWindDirectionInZH</h3>
	 * <pre>public String getWindDirectionInZH()</pre>
	 * Get the Wind Direction Description in Chinese of this report
	 * @return Wind Direction Description in Chinese
	 */
	public String getWindDirectionInZH(){
		return this.windDirectionZh;
	}
	
	/***
	 * <h3>setWindDirection_zh_shortform</h3>
	 * <pre>public void setWindDirection_zh_shortform(String windDirection_zh_shortform)</pre>
	 * Set the short-form of the wind direction in Chinese to this report.
	 * @param windDirection_zh_shortform  Wind Direction Description Short-form
	 */
	public void setWindDirection_zh_shortform(String windDirection_zh_shortform){
		this.windDirectionShortformZh = windDirection_zh_shortform;
	}
	
	/***
	 * <h3>getWindDirectionShortformInZH</h3>
	 * <pre>public String getWindDirectionShortformInZH()</pre>
	 * Get the short-form of the wind direction in Chinese of this report.
	 * @return Wind Direction Description Short-form
	 */
	public String getWindDirectionShortformInZH(){
		return this.windDirectionShortformZh;
	}
	
	/***
	 * <h3>setWindSpeed</h3>
	 * <pre>public void setWindSpeed(float speedkm)</pre>
	 * Set the wind speed record to this report.
	 * @param speedkm Float number of wind speed
	 */
	public void setWindSpeed(float speedkm){
		this.windSpeedKm = speedkm;
	}
	
	/***
	 * <h3>getWindSpeed</h3>
	 * <pre>public float getWindSpeed()</pre>
	 * Get the wind speed record of this report.<br><br>
	 * <b>NOTE:</b> May return 0.0 if HKO reported NULL / NIL
	 * @return Float number of wind speed
	 */
	public float getWindSpeed(){
		return this.windSpeedKm;
	}
	
	/***
	 * <h3>setMeanSeaLevelPressure</h3>
	 * <pre>public void setMeanSeaLevelPressure(float pressure)</pre>
	 * Set the mean sea level pressure.
	 * @param pressure Float number of sea level pressure.
	 */
	public void setMeanSeaLevelPressure(float pressure){
		this.MeanSeaLevelPressure = pressure;
	}
	
	/***
	 * <h3>getMeanSeaLevelPressure</h3>
	 * <pre>public float getMeanSeaLevelPressure()</pre>
	 * Get the mean sea level pressure.
	 * @return Float number of sea level pressure.
	 */
	public float getMeanSeaLevelPressure(){
		return this.MeanSeaLevelPressure;
	}
	
	/***
	 * <h3>setTenMinuteMeanVisibility</h3>
	 * <pre>public void setTenMinuteMeanVisibility(int visibility)</pre>
	 * Set the mean visibility from the weather station during ten minutes.
	 * @param visibility Visibility
	 */
	public void setTenMinuteMeanVisibility(int visibility){
		this.TenMinuteMeanVisibility = visibility;
	}
	
	/***
	 * <h3>getTenMinuteMeanVisibility</h3>
	 * <pre>public void getTenMinuteMeanVisibility()</pre>
	 * Get the mean visibility from the weather station during ten minutes.
	 * @return Integer of Mean Visibility
	 */
	public int getTenMinuteMeanVisibility(){
		return this.TenMinuteMeanVisibility;
	}
	
	/***
	 * <h3>setMaxTemp</h3>
	 * <pre>public void setMaxTemp(float temp)</pre>
	 * Set the maximum temperature record to this report.
	 * @param temp Float number of maximum temperature
	 */
	public void setMaxTemp(float temp){
		this.MaxTemperature = temp;
	}
	
	/***
	 * <h3>getMaxTemp</h3>
	 * <pre>public void getMaxTemp()</pre>
	 * Get the maximum temperature record of this report.
	 * @return Float number of maximum temperature
	 */
	public float getMaxTemp(){
		return this.MaxTemperature;
	}
	
	/***
	 * <h3>setMaxTempAround</h3>
	 * <pre>public void setMaxTempAround(int temp)</pre>
	 * Similar to max. temperature, but it is rounded off.
	 * @param temp Integer of Max. Temperature Around
	 */
	public void setMaxTempAround(int temp){
		this.MaxTemperature_around = temp;
	}
	
	/***
	 * <h3>getMaxTempAround</h3>
	 * <pre>public int getMaxTempAround()</pre>
	 * Similar to max. temperature, but it is rounded off.
	 * @return Integer of Max. Temperature Around
	 */
	public int getMaxTempAround(){
		return this.MaxTemperature_around;
	}
	
	/***
	 * <h3>setMinTemp</h3>
	 * <pre>public void setMinTemp(float temp)</pre>
	 * Set the minimum temperature record to this report.
	 * @param temp Float number of minimum temperature
	 */
	public void setMinTemp(float temp){
		this.MinTemperature = temp;
	}
	
	/***
	 * <h3>getMinTemp</h3>
	 * <pre>public void getMinTemp()</pre>
	 * Get the minimum temperature record of this report.
	 * @return Float number of minimum temperature
	 */
	public float getMinTemp(){
		return this.MinTemperature;
	}
	
	/***
	 * <h3>setMinTempAround</h3>
	 * <pre>public void setMinTempAround(int temp)</pre>
	 * Similar to min. temperature, but it is rounded off.
	 * @param temp Integer of Min. Temperature Around
	 */
	public void setMinTempAround(int temp){
		this.MinTemperature_around = temp;
	}
	
	/***
	 * <h3>getMinTempAround</h3>
	 * <pre>public int getMinTempAround()</pre>
	 * Similar to min. temperature, but it is rounded off.
	 * @return Integer of Min. Temperature Around
	 */
	public int getMinTempAround(){
		return this.MinTemperature_around;
	}
	
	/***
	 * <h3>setHomeMaxTemp</h3>
	 * <pre>public void setHomeMaxTemp(int temp)</pre>
	 * Similar to max. temp, but it is estimated about the indoor temperature.
	 * @param temp Integer of indoor max. temperature.
	 */
	public void setHomeMaxTemp(int temp){
		this.HomeMaxTemperature = temp;
	}
	
	/***
	 * <h3>getHomeMaxTemp</h3>
	 * <pre>public void setHomeMaxTemp()</pre>
	 * Similar to max. temp, but it is estimated about the indoor temperature.
	 * @return Integer of indoor max. temperature.
	 */
	public int getHomeMaxTemp(){
		return this.HomeMaxTemperature;
	}
	
	/***
	 * <h3>setHomeMinTemp</h3>
	 * <pre>public void setHomeMinTemp(int temp)</pre>
	 * Similar to min. temp, but it is estimated about the indoor temperature.
	 * @param temp Integer of indoor min. temperature.
	 */
	public void setHomeMinTemp(int temp){
		this.HomeMinTemperature = temp;
	}
	
	/***
	 * <h3>getHomeMinTemp</h3>
	 * <pre>public void setHomeMinTemp()</pre>
	 * Similar to min. temp, but it is estimated about the indoor temperature.
	 * @return Integer of indoor min. temperature.
	 */
	public int getHomeMinTemp(){
		return this.HomeMinTemperature;
	}
}
