import java.util.HashMap;
import java.util.Map;

// Common data format for the mobile application
class CommonWeatherData {
    private double temperature;
    private double humidity;
    private String description;

    public CommonWeatherData() {
        // Default constructor
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

// Original data format for WeatherAPI1
class WeatherAPI1Data {
    private double temp;
    private double humid;
    private String desc;

    public WeatherAPI1Data() {
        // Default constructor
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumid() {
        return humid;
    }

    public void setHumid(double humid) {
        this.humid = humid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

// Original data format for WeatherAPI2
class WeatherAPI2Data {
    private double tempC;
    private double humidity;
    private String weather;

    public WeatherAPI2Data() {
        // Default constructor
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}

// Adapter for WeatherAPI1
class WeatherAPI1Adapter {
    private WeatherAPI1Data apiData;

    public WeatherAPI1Adapter(WeatherAPI1Data apiData) {
        this.apiData = apiData;
    }

    public CommonWeatherData getCommonData() {
        CommonWeatherData commonData = new CommonWeatherData();
        commonData.setTemperature(apiData.getTemp());
        commonData.setHumidity(apiData.getHumid());
        commonData.setDescription(apiData.getDesc());
        return commonData;
    }
}

// Adapter for WeatherAPI2
class WeatherAPI2Adapter {
    private WeatherAPI2Data apiData;

    public WeatherAPI2Adapter(WeatherAPI2Data apiData) {
        this.apiData = apiData;
    }

    public CommonWeatherData getCommonData() {
        CommonWeatherData commonData = new CommonWeatherData();
        commonData.setTemperature(apiData.getTempC());
        commonData.setHumidity(apiData.getHumidity());
        commonData.setDescription(apiData.getWeather());
        return commonData;
    }
}

public class Adapter {
    public static void main(String[] args) {
        WeatherAPI1Data api1Data = new WeatherAPI1Data();
        api1Data.setTemp(25);
        api1Data.setHumid(60);
        api1Data.setDesc("Partly cloudy");

        WeatherAPI2Data api2Data = new WeatherAPI2Data();
        api2Data.setTempC(26);
        api2Data.setHumidity(55);
        api2Data.setWeather("Sunny");

        WeatherAPI1Adapter adapter1 = new WeatherAPI1Adapter(api1Data);
        WeatherAPI2Adapter adapter2 = new WeatherAPI2Adapter(api2Data);

        CommonWeatherData commonData1 = adapter1.getCommonData();
        CommonWeatherData commonData2 = adapter2.getCommonData();

        System.out.println("Common data from API 1: " + "Temperature: " + commonData1.getTemperature() + ", Humidity: " + commonData1.getHumidity() + ", Description: " + commonData1.getDescription());
        System.out.println("Common data from API 2: " + "Temperature: " + commonData2.getTemperature() + ", Humidity: " + commonData2.getHumidity() + ", Description: " + commonData2.getDescription());
    }
}
