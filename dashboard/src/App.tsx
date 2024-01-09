import Dashboard from "./components/dashboard"
import Sidebar from "./components/sidebar"
import Topbar from "./components/topbar"

function App() {
  return (
    <div className="flex w-full h-screen">
      <Sidebar />
      <div className="flex flex-1 flex-col">
        <Topbar />
        <Dashboard />
      </div>
    </div>
  )
}

export default App
