import { Card, CardContent } from "@/components/ui/card";
import { motion } from "framer-motion";
import { Cloud, CloudSun, CloudDrizzle, CloudFog, Sun, CloudLightning } from "lucide-react";

function getConditionIcon(condition) {
  if (!condition) return Cloud;
  const c = condition.toLowerCase();
  if (c.includes("mist") || c.includes("fog")) return CloudFog;
  if (c.includes("thunder")) return CloudLightning;
  if (c.includes("rain") || c.includes("drizzle")) return CloudDrizzle;
  if (c.includes("cloud")) return CloudSun;
  if (c.includes("clear")) return Sun;
  return Cloud;
}

export default function CurrentWeather({ meta }) {
  const Icon = getConditionIcon(meta?.condition);

  return (
    <Card className="bg-gradient-to-br from-zinc-900 to-zinc-700 border-zinc-700 rounded-2xl shadow-xl">
      <CardContent className="flex items-center justify-between">
        <div className="flex items-center gap-4">
          <motion.div initial={{ scale: 0.9, opacity: 0 }} animate={{ scale: 1, opacity: 1 }}>
            <Icon className="h-14 w-14" />
          </motion.div>
          <div>
            <div className="text-4xl font-semibold text-zinc-400">
              {meta ? Math.round(meta.temperature) : "--"}°C
            </div>
            <div className="text-zinc-300 text-sm mt-1">
              {meta ? meta.condition : "—"}
            </div>
          </div>
        </div>
        <div className="text-right">
          <div className="text-xl font-medium">Weather</div>
          <div className="text-zinc-300 text-sm">{meta ? `${meta.city}, ${meta.region}` : "—"}</div>
          <div className="text-zinc-400 text-xs">{meta?.country}</div>
        </div>
      </CardContent>
    </Card>
  );
}
