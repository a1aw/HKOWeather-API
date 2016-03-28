package com.mob41.hkoweather.api;

public class WeatherReport {
	
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
	
	/***
	 * <h3>WeatherReport</h3>
	 * <pre>protected WeatherReport(String stationcode)</pre>
	 * Create a new weather report.
	 * @param stationcode - To classify this weather report to a specific Weather Station.
	 */
	protected WeatherReport(String stationcode){
		this.stationcode = stationcode;
	}
	
	/***
	 * <h3>setStationCode</h3>
	 * <pre>protected void setStationCode(String stationcode)</pre>
	 * Set the weather station code of this report
	 * @param stationcode - Weather Station Code. e.g. HKO, WTS..etc
	 */
	protected void setStationCode(String stationcode){
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
	 * <pre>protected void setStationName_zh(String name)</pre>
	 * Set the weather station's Chinese name of this report
	 * @param name - Weather Station's Chinese name.
	 */
	protected void setStationName_zh(String name){
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
	 * <pre>protected void setStationName_en(String name)</pre>
	 * Set the weather station's English name of this report
	 * @param name - Weather Station's English name.
	 */
	protected void setStationName_en(String name){
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
	protected void setUpdateTime(String time){
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
	 * <pre>protected void setTemp(float temp)</pre>
	 * Set the temperature of the weather of this report.
	 * @param temp - Float number of the temperature.
	 */
	protected void setTemp(float temp){
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
	 * <pre>protected void setTempAround(int temp)</pre>
	 * Set the temperature around (rounded) of the weather of this report.
	 * @param temp Integer of the temperature around (rounded) 
	 */
	protected void setTempAround(int temp){
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
	 * <pre>protected void setHumidity(int humidity)</pre>
	 * Set the humidity of the weather of this report.
	 * @param humidity Humidity of the weather
	 */
	protected void setHumidity(int humidity){
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
	 * @param windDirectionCode
	 */
	protected void setWindDirectionCode(String windDirectionCode){
		this.windDirectionCode = windDirectionCode;
	}
	
	//TODO Finish JavaDoc
	public String getWindDirectionCode(){
		return this.windDirectionCode;
	}
	
	protected void setWindDirection_en(String windDirection_en){
		this.windDirectionEn = windDirection_en;
	}
	
	public String getWindDirectionInEN(){
		return this.windDirectionEn;
	}
	
	protected void setWindDirection_en_shortform(String windDirection_en_shortform){
		this.windDirectionShortformEn = windDirection_en_shortform;
	}
	
	public String getWindDirectionShortformInEN(){
		return this.windDirectionShortformEn;
	}
	
	protected void setWindDirection_zh(String windDirection_zh){
		this.windDirectionZh = windDirection_zh;
	}
	
	public String getWindDirectionInZH(){
		return this.windDirectionZh;
	}
	
	protected void setWindDirection_zh_shortform(String windDirection_zh_shortform){
		this.windDirectionShortformZh = windDirection_zh_shortform;
	}
	
	public String getWindDirectionShortformInZH(){
		return this.windDirectionShortformZh;
	}
	
	protected void setWindSpeed(float speedkm){
		this.windSpeedKm = speedkm;
	}
	
	public float getWindSpeed(){
		return this.windSpeedKm;
	}
	
	protected void setMeanSeaLevelPressure(float pressure){
		this.MeanSeaLevelPressure = pressure;
	}
	
	public float getMeanSeaLevelPressure(){
		return this.MeanSeaLevelPressure;
	}
	
	protected void setTenMinuteMeanVisibility(int visibility){
		this.TenMinuteMeanVisibility = visibility;
	}
	
	public int getTenMinuteMeanVisibility(){
		return this.TenMinuteMeanVisibility;
	}
	
	protected void setMaxTemp(float temp){
		this.MaxTemperature = temp;
	}
	
	public float getMaxTemp(){
		return this.MaxTemperature;
	}
	
	protected void setMaxTempAround(int temp){
		this.MaxTemperature_around = temp;
	}
	
	public int getMaxTempAround(){
		return this.MaxTemperature_around;
	}
	
	protected void setMinTemp(float temp){
		this.MinTemperature = temp;
	}
	
	public float getMinTemp(){
		return this.MinTemperature;
	}
	
	protected void setMinTempAround(int temp){
		this.MinTemperature_around = temp;
	}
	
	public int getMinTempAround(){
		return this.MinTemperature_around;
	}
	
	protected void setHomeMaxTemp(int temp){
		this.HomeMaxTemperature = temp;
	}
	
	public int getHomeMaxTemp(){
		return this.HomeMaxTemperature;
	}
	
	protected void setHomeMinTemp(int temp){
		this.HomeMinTemperature = temp;
	}
	
	public int getHomeMinTemp(){
		return this.HomeMinTemperature;
	}
}
