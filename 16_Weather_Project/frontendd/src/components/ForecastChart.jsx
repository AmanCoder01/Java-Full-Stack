import { Card, CardContent } from "@/components/ui/card";
import {
    ResponsiveContainer,
    LineChart,
    Line,
    Tooltip,
    XAxis,
    YAxis,
    CartesianGrid,
} from "recharts";

export default function ForecastChart({ series }) {
    // format data for chart
    const chartData = series.map((d) => ({
        date: d.date.slice(5), // MM-DD
        avg: Number(d.avgTemp.toFixed(1)),
    }));

    return (
        <Card className="bg-[#2eb0ae8a] rounded-2xl mt-4">
            <CardContent className="p-6">
                <div className="flex items-center justify-between mb-4">
                    <div className="text-lg font-medium text-zinc-400">Temperature Trend</div>
                    <div className="text-sm text-zinc-400">
                        Avg over {series.length} days
                    </div>
                </div>
                <div className="h-64 w-full">
                    <ResponsiveContainer width="100%" height="100%">
                        <LineChart data={chartData}>
                            <CartesianGrid strokeDasharray="3 3" opacity={0.15} />
                            <XAxis dataKey="date" tick={{ fill: "#a1a1aa" }} />
                            <YAxis
                                domain={["dataMin - 2", "dataMax + 2"]}
                                tick={{ fill: "#a1a1aa" }}
                                unit="°C"
                            />
                            <Tooltip
                                formatter={(v) => `${v} °C`}
                                labelFormatter={(l) => `Date: ${l}`}
                                contentStyle={{
                                    background: "#09090b",
                                    border: "1px solid #27272a",
                                    borderRadius: 12,
                                    color: "#e4e4e7",
                                }}
                            />
                            <Line type="monotone" dataKey="avg" strokeWidth={3} />
                        </LineChart>
                    </ResponsiveContainer>
                </div>
            </CardContent>
        </Card>
    );
}
