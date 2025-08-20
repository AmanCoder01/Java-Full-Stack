import React from 'react'
import WeatherDashboard from './components/WeatherDashboard'
import { Card } from "@/components/ui/card";


const App = () => {
  return (
    <div className='bg-zinc-200 flex justify-center'>
      <Card className="bg-zinc-600 w-full md:w-5/12 shadow-2xl">
          <WeatherDashboard/>
      </Card>
    </div>
  )
}

export default App
