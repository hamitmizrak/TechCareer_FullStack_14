// rfce
// REACT
import React, { useEffect, useState } from 'react'

// LINK
import {Link, Route, useNavigate} from 'react-router-dom'

// I18N
import { withTranslation } from 'react-i18next';

// CATEGORY API
import BlogCategoryApi from "../../services/BlogCategoryApi";

// FUNCTION COMPONENT
function BlogCategoryList({ t, i18n, props }) {

    // REDIRECT
    let navigate = useNavigate();

    // STATE
    const [blogCategoryApiListData, setBlogCategoryApiListData] = useState([]); //unutma diziyi yaz

    // EFFECT
    useEffect(() => {
        //2.YOL
        fetchBlogCategoryList();
    }, []) //end useEffect

    // Fetch users from API
    const fetchBlogCategoryList = async () => {
        try {
            const response = await BlogCategoryApi.categoryApiList();   //fetch('https://api.example.com/users');
            setBlogCategoryApiListData(response.data)
        } catch (error) {
            console.error('Error fetching users:', error);
        }
    };

    // FUNCTION
    // LIST AFTER LOADING
    const listManipulationAfter = () => {
        BlogCategoryApi.categoryApiList()
            .then(
                (response) => {
                    console.log(response);
                    console.log(response.data);
                    console.log(response.status);
                    console.log(response.headers);
                    if (response.status === 200) {
                        setBlogCategoryApiListData(response.data)
                    }
                }
            )
            .catch((err) => {
                console.log(err);
            });
    }

 
    ////////////////////////////
    // CRUD
    // REGISTER UPDATE
    const setUpdateBlogCategory = (data) => {
        // 1.YOL (id useParams)
        // 2.YOL (localStorage)
        let { id, categoryName } = data
        localStorage.setItem("blog_category_update_id", data.id)
        localStorage.setItem("blog_category_nick_name", categoryName)
    }

    // REGISTER VIEW
    const setViewBlogCategory = (id) => {
        // 1.YOL (id useParams)
        // 2.YOL (localStorage)
        localStorage.setItem("blog_category_view_id", id)
    }

    //REGISTER DELETE
    const setDeleteBlogCategory = (id) => {
        if (window.confirm(id + " id datayı silmek istiyor musunuz ?")) {
            // 1.YOL
            BlogCategoryApi.categoryApiDeleteById(id)
                .then((response) => {
                    if (response.status === 200) {
                        listManipulationAfter();
                        navigate('/blog/category/list')
                        //window.location = "/blog/category/list"
                    }
                })
                .catch((err) => {
                    console.error(err);
                    navigate('/blog/category/list')
                    //window.location = "/register/list"
                });
        } else {
            alert(id + " nolu data silinmedi !!!");
            //navigate('/register/list')
            window.location = "/blog/category/list"
        }
        // 2.YOL (delete axios yazarak)
        // axios.delete(" http://localhost:4444/register/api/v1.0.0/delete/"+id).then().catch();
    }

    // RETURN
    return (
        <React.Fragment>
            <br /><br /><br /><br />
            <h1 className="text-center display-5 mb-5">{t('blog_category_list')}</h1>
            <Link className='btn btn-primary me-2' to="/blog/category/create">{t('create')}</Link>
             <table className='table table-striped table-responsive mb-5'>
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
                    blogCategoryApiListData.map((data) =>
                        <tr key={data.categoryId}>
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
        </React.Fragment>
    ) //end return
} //end function

// i18n
export default withTranslation()(BlogCategoryList)

