import { GiSteamLocomotive } from 'react-icons/gi'
import { IoIosHome } from 'react-icons/io'

const Sidebar = () => {
    return (
        <div className="w-[300px] h-full bg-base-300 py-4 pr-4 gap-4 flex flex-col">
            <div className='flex w-full justify-center items-center p-4 text-primary'>
                <GiSteamLocomotive size={100} />
            </div>
            <div className='flex flex-col'>
                <button className='rounded-r-lg flex items-center border-l-[4px] border-primary gap-3 p-4 px-6 bg-[rgba(255,255,255,0.1)] active:translate-x-[-4px] transition-all duration-300'>
                    <IoIosHome />
                    Dashboard
                </button>
            </div>
        </div>
    )
}

export default Sidebar;