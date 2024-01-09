import axios from "axios";
import { useEffect, useState } from "react";

const Dashboard = () => {
  const [data, setData] = useState({
    totalLocomotif: 0,
    totalLocomotifExcellent: 0,
    totalLocomotifGood: 0,
    totalLocomotifPoor: 0
  })

  useEffect(() => {
    axios.get("http://localhost:8080/api/summary")
    .then((res) => {
      setData(res.data)
    })
    .catch((err: unknown) => {
      console.log(err)
    })
  }, []);

  return (
    <div className="w-full h-full flex justify-center px-4">
      <div className="w-full max-w-[1200px] flex flex-col py-6 gap-6">
        <span className="font-bold text-2xl">Dashboard</span>
        <div className="w-full flex gap-4">
          <div className="card flex-1 bg-primary text-primary-content">
            <div className="card-body gap-4">
              <span className="text-lg font-bold">Total Locomotive</span>
              <div className="font-bold text-6xl">{data.totalLocomotif}</div>
            </div>
          </div>
          <div className="card flex-1 bg-error text-error-content">
            <div className="card-body gap-4">
              <span className="text-lg font-bold">Total Poor</span>
              <div className="font-bold text-6xl">{data.totalLocomotifPoor}</div>
            </div>
          </div>
          <div className="card flex-1 bg-warning text-warning-content">
            <div className="card-body gap-4">
              <span className="text-lg font-bold">Total Good</span>
              <div className="font-bold text-6xl">{data.totalLocomotifGood}</div>
            </div>
          </div>
          <div className="card flex-1 bg-success text-success-content">
            <div className="card-body gap-4">
              <span className="text-lg font-bold">Total Excellent</span>
              <div className="font-bold text-6xl">{data.totalLocomotifExcellent}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Dashboard;