// rcc 
import { withTranslation } from 'react-i18next';

import { Navigate, Route, Routes } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import MainComponent from './components/MainComponent';
import React from 'react';
import BlogCategoryList from './components/blog_category/BlogCategoryList';
import BlogCategoryCreate from './components/blog_category/BlogCategoryCreate';
import BlogCategoryView from './components/blog_category/BlogCategoryView';
import BlogCategoryUpdate from './components/blog_category/BlogCategoryUpdate';

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


                            {/* Blog Categories */}
                            <Route path={"/blog/category/list"} element={<BlogCategoryList/>} />
                            <Route path={"/blog/category/create"} element={<BlogCategoryCreate/>} />
                            <Route path={"/blog/category/view/:id"} element={<BlogCategoryView/>} />
                            <Route path={"/blog/category/update/:id"} element={<BlogCategoryUpdate/>} />


                            <Route path={"*"} element={<Navigate to={"/"} />} />
                            {/* 
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