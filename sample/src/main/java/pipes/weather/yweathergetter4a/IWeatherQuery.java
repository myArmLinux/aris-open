package pipes.weather.yweathergetter4a;

import android.content.Context;

public interface IWeatherQuery {

    IWeather getWeather(Context context, String place);

}
