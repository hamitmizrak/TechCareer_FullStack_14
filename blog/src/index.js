import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import BlogRouter from './BlogRouter';

// BrowserRouter => http://localjhost:3000/
// HashRouter    => http://localjhost:3000/#
import { BrowserRouter } from 'react-router-dom';

// Dil Seçeneği (Ekledim)
import './internationalization/i18nlanguage'

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
     <BrowserRouter> 
       {/* <App />  */}
       <BlogRouter /> 
     </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
