import { Card, CardContent } from "@/components/ui/card";
import { Cloud, CloudSun, Sun, CloudDrizzle } from "lucide-react";

// pick an icon based on avg temp
function tempIcon(avg) {
    if (avg >= 33) return Sun;
    if (avg >= 30) return CloudSun;
    if (avg >= 27) return Cloud;
    return CloudDrizzle;
}

export default function ForecastDayCard({ day }) {
    const Icon = tempIcon(day.avgTemp);
    const mmdd = day.date.slice(5);

    return (
        <Card className="bg-zinc-700 border-zinc-800 rounded-xl">
            <CardContent className="">
                <div className="text-sm text-zinc-300 mb-2">
                    {new Date(day.date).toLocaleDateString(undefined, {
                        weekday: "long",
                    })}
                </div>
                <div className="flex items-center gap-2">
                    <Icon className="h-8 w-8" />
                    <div className="text-xl font-semibold">
                        {Math.round(day.maxTemp)}°
                    </div>
                    <div className="ml-auto text-sm text-zinc-400">{mmdd}</div>
                </div>
                <div className="flex gap-3 text-xs text-zinc-400 mt-2">
                    <span>Min {Math.round(day.minTemp)}°</span>
                    <span>Avg {Math.round(day.avgTemp)}°</span>
                </div>
            </CardContent>
        </Card>
    );
}
