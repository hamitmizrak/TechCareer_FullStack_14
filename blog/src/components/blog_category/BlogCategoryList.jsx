// React
import React, { useEffect, useState } from 'react'

// Router
import { useNavigate } from 'react-router-dom'

// List
import BlogCategoryApi from '../../services/BlogCategoryApi';

// I18n
import { withTranslation } from 'react-i18next';
import { Link } from 'react-router-dom/dist';


// Function BlogCategoryList
function BlogCategoryList({t,i18n,props}) {

    // REDIRECT
    let navigate=useNavigate();

    // STATE
    const [blogCategoriesList,setBlogCategoriesList]=useState([]); //unutma list yazacaksınız.

    // EFFECT 
    useEffect( ()=>{
        fetchBlogCategoryList()
    },[]);

    // List
    const fetchBlogCategoryList=async()=>{
        try {
            const response= await BlogCategoryApi.categoryApiList();
            setBlogCategoriesList(response.data);
        } catch (error) {
            console.error(error)
            
        }
    }

/////////////////////////////////////////////
    // Method
    setUpdateBlogCategory=(data)=>{
        let {id,categoryName}=data;
        localStorage.setItem("blog_category_update_id",id);
        localStorage.setItem("blog_category_update_category_name",categoryName);
    }


    setViewBlogCategory=(id)=>{
localStorage.setItem("blog_category_view_id",id);
    }


    setDeleteBlogCategory=(id)=>{
        if(window.confirm("Are you sure you want to delete?")){
            BlogCategoryApi.categoryApiDelete(id);
            navigate("/blog/category/list");
        }
    }

    // RETURN
  return (
    <>
    <div className="mt-5">
<h1 className="text-center h1 mb-5">{t('blog_category_list')}</h1>
<Link className='btn btn-primary me-2' to="/blog/category/create">{t('create')}</Link>
    </div>
     <table className="table table-striped table-responsive mb-4">
        <thead>
            <tr>
                    <th>{t('id')}</th>
                    <th>{t('blog_category_name')}</th>
                    <th>{t('date')}</th>
                    <th>{t('update')}</th>
                    <th>{t('show')}</th>
                    <th>{t('delete')}</th>
            </tr>
        </thead>
        <tbody>
            {
                blogCategoriesList.map((data)=>
                <tr>
                    <td>{data.categoryId}</td>
                    <td>{data.categoryName}</td>
                    <td>{data.systemCreatedDate}</td>
                   
                    <td>
                                <Link to={`/blog/category/update/${data.categoryId}`}>
                                    <i onClick={() => setUpdateBlogCategory(data)} className="fa-solid fa-pen-nib text-primary"></i>
                                </Link>
                    </td>
                    <td>
                                <Link to={`/blog/category/view/${data.categoryId}`}>
                                    <i onClick={() => setViewBlogCategory(data.categoryId)} className="fa-solid fa-eye text-secondary"></i>
                                </Link>
                    </td>
                    <td>
                                <Link>
                                    <i onClick={() => setDeleteBlogCategory(data.categoryId)} className="fa-solid fa-trash text-danger"></i>
                                </Link>
                     </td>
                </tr>
                )
            }
        </tbody>
     </table>
    </>
  ) // end return
} //end function

// i18n
export default withTranslation()(BlogCategoryList) 