// rcc 
import { withTranslation } from 'react-i18next';

import { Navigate, Route, Routes } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent.';
import MainComponent from './components/MainComponent.';
import React from 'react';

// CLASS COMPONENT BlogRouter
function BlogRouter() {

    // RETURN
        return (
            <React.Fragment>
                    <HeaderComponent logo="fa-solid fa-blog"></HeaderComponent>

                    <div class="container">
                    <Routes>
                            <Route path={"/"} element={<MainComponent />} />
                            <Route path={"/index"} element={<MainComponent />} />


                            <Route path={"*"} element={<Navigate to={"/"} />} />
                            {/* <Route path="/about" element={<About />} />
                            <Route path="/contact" element={<Contact />} />
                            <Route path="/blog" element={<Blog />} />
                            <Route path="/blog/:slug" element={<BlogDetail />} />
                            <Route path="*" element={<NotFound />} /> */}
                    </Routes>
                    </div>

                    <FooterComponent></FooterComponent>
            </React.Fragment>
        );
}

// EXPORT
// export default withTranslation()(BlogRouter);
export default withTranslation()(BlogRouter) ;