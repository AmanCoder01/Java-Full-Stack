import React, { useState } from "react";
import useForecast from "../hooks/useForecast";
import CurrentWeather from "./CurrentWeather";
import ForecastChart from "./ForecastChart";
import ForecastDayCard from "./ForecastDayCard";
import WeatherSearch from "./WeatherSearch";

export default function WeatherDashboard() {
  const [city, setCity] = useState("");
  const { data, loading, error, fetchForecast } = useForecast();

  return (
    <div className="px-6  min-h-screen text-zinc-100 w-full">
      {/* Search Bar */}
      <WeatherSearch
        city={city}
        setCity={setCity}
        loading={loading}
        onSearch={() => fetchForecast(city)}
      />

      {!data ? (
        <div className="flex flex-col items-center justify-center py-12 space-y-4 text-gray-400">
          <img
            src="https://cdn-icons-png.flaticon.com/512/1163/1163661.png"
            alt="Weather placeholder"
            className="w-28 h-28 opacity-80"
          />
          <p className="text-lg text-center">Search for a city to see the weather forecast</p>
        </div>
      ) : (
        <>
          <CurrentWeather meta={data.weatherResponse} />

          <h1 className="mt-4 text-sm text-center text-zinc-900 font-medium">6 Days Forecast</h1>
          <div className="border mt-2 mb-4 border-zinc-500 "></div>

          <div className="flex flex-wrap gap-1 md:gap-3 mt-4 justify-center">
            {data.dayTemp.map((d) => (
              <ForecastDayCard key={d.date} day={d} />
            ))}
          </div>

          {/* <ForecastChart series={data.dayTemp} /> */}
        </>
      )}

      {error && <div className="text-red-400 mt-4">Error: {error}</div>}
    </div>
  );
}
