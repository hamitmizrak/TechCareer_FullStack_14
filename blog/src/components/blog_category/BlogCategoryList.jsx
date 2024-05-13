import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import BlogCategoryApi from '../../services/BlogCategoryApi';

export default function BlogCategoryList({t,i18n,props}) {

    // REDIRECT
    let navigate=useNavigate();

    // STATE
    const [blogCategoriesList,setBlogCategoriesList]=useState([]); //unutma list yazacaksınız.

    // EFFECT 
    useEffect( ()=>{
        fetchBlogCategoryList()
    },[]);

    const fetchBlogCategoryList=async()=>{
        try {
            const response= await BlogCategoryApi.categoryApiList();
            setBlogCategoriesList(response.data);
        } catch (error) {
            console.error(error)
            
        }
    }

    // RETURN
  return (
    <>
    <table className="table table-striped table-responsive mb-4">
        <thead>
            <tr>
            <th>Id</th>
            <th>Category Name</th>
            <th>Date</th>
            <th>Update</th>
            <th>View</th>
            <th>Delete</th>
            </tr>
        </thead>
        <tbody>

{
    blogCategoriesList.map((data)=>
    <tr>
        <td>{data.categoryId}</td>
        <td>{data.categoryName}</td>
        <td>{data.systemCreatedDate}</td>
        <td><button className="btn btn-warning" >Update</button></td>
                <td><button className="btn btn-info">View</button></td>
                <td><button className="btn btn-danger">Delete</button></td>
    </tr>
    )
}






            {/* {getBlogCategoriesList.map((blogCategory)=>
            <tr key={blogCategory.id}>
                <td>{blogCategory.id}</td>
                <td>{blogCategory.name}</td>
                <td>{blogCategory.created_at}</td>
                <td><button className="btn btn-warning" onClick={()=>navigate("/blog/category/update/"+blogCategory.id)}>Update</button></td>
                <td><button className="btn btn-info" onClick={()=>navigate("/blog/category/view/"+blogCategory.id)}>View</button></td>
                <td><button className="btn btn-danger">Delete</button></td>
            </tr>
            )} */}
        </tbody>
    </table>
    </>
  )
}
