import { useState } from "react";

const API_BASE = "http://localhost:8080/weather/forecast";

export default function useForecast() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  async function fetchForecast(city, days = 6) {
    try {
      setLoading(true);
      setError(null);
      const res = await fetch(`${API_BASE}?city=${city}&days=${days}`);
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const json = await res.json();
      setData(json);
    } catch (e) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  }

  return { data, loading, error, fetchForecast };
}
