import React from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';

// ROUTER
import BlogRouter from "./BlogRouter";

// dark mode
import './index.css';

// Dil Secenegi
import './internationalization/i18nlanguage';

// ROUTER
// BrowserRouter  http://localhost:3000/
// HashRouter     http://localhost:3000/#/
import { BrowserRouter  } from 'react-router-dom';


// ROOT - DOM
const root = ReactDOM.createRoot(document.getElementById('root'));

// RENDER
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <BlogRouter />
      {/* <App /> */}
    </BrowserRouter>

  </React.StrictMode>
);

reportWebVitals();
