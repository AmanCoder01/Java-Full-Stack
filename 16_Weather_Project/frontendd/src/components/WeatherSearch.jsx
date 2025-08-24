import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { Loader2 } from "lucide-react";

export default function WeatherSearch({ city, setCity, onSearch, loading }) {
  return (
    <div className="flex gap-3 mb-4 ">
      <Input
        className="bg-zinc-900 border-zinc-800  w-full h-9 text-base"
        placeholder="Enter city (e.g., Noida)"
        value={city}
        onChange={(e) => setCity(e.target.value)}
      />
      <Button
        className="h-9 rounded-2xl"
        onClick={onSearch}
        disabled={loading || !city}
      >
        {loading ? (
          <span className="inline-flex items-center gap-2">
            <Loader2 className="h-4 w-4 animate-spin" /> Loading
          </span>
        ) : (
          "Search"
        )}
      </Button>
    </div>
  );
}
