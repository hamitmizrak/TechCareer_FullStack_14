// React
import React from "react";

// Sun , Moon
import { ReactComponent as Sun } from "./Sun.svg";
import { ReactComponent as Moon } from "./Moon.svg";

// DarkMode.css
import "./DarkMode.css";

// Function
const DarkMode = () => {
    // DARK MODE
    const setDarkMode = () => {
        document.querySelector("body").setAttribute('data-theme', 'dark')
        localStorage.setItem("selectedTheme", "dark")
    }

    // LIGHT MODE
    const setLightMode = () => {
        document.querySelector("body").setAttribute('data-theme', 'light')
        localStorage.setItem("selectedTheme", "light")
    }

    // SELECTED
    const selectedTheme = localStorage.getItem("selectedTheme")
    if (selectedTheme === "dark") {
        setDarkMode();
    }

    // Eğer button tıklanmışsa DarkMode seçilsin
    const onChangeToggleTheme = (e) => {
        if (e.target.checked)
            setDarkMode()
        else
            setLightMode()
    };

    // RETURN
    return (
        <div className='dark_mode'>
            <input
                className='dark_mode_input'
                type='checkbox'
                id='darkmode-toggle'
                onChange={onChangeToggleTheme}
                defaultChecked={selectedTheme === "dark"}
            />
            <label className='dark_mode_label' htmlFor='darkmode-toggle'>
                <Sun />
                <Moon />
            </label>
        </div>
    );
};

// Export
export default DarkMode;
