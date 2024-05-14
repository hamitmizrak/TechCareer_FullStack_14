import React, { useEffect, useState } from 'react'
import { withTranslation } from 'react-i18next'
import BlogCategoryApi from '../../services/BlogCategoryApi';

import sunRise from '../../assets/sunrise.jpg'
import { Link } from 'react-router-dom';

function BlogCategoryView({ t, i18n, props }) {

// STATE
const [id,setId]=useState(null);
const[blogCategoryView,setBlogCategoryView]=useState([]);

useEffect(()=>{
  setId(localStorage.getItem("blog_category_view_id"))

  BlogCategoryApi.categoryApiFindById(localStorage.getItem("blog_category_view_id"))
  .then((response)=>{
    console.log(response);
    if(response.status===200){
      setBlogCategoryView(response.data)
    }
  })
  .catch((err)=>{console.error(err);})
},[]); //end useEffect


  return (
    <div>

<div className="card mt-5">
  <img className="card-img-top" src={sunRise} alt="Title" />
  <div className="card-body">
    <h4 className="card-title">{blogCategoryView.categoryName}</h4>
    <p className="card-text">{blogCategoryView.systemCreatedDate}</p>
  </div>
</div>
<Link to="/blog/category/list" className="btn btn-primary btn-sm mt-3">Blog Category</Link>
  

    </div>
  )
}

export default withTranslation()(BlogCategoryView) 