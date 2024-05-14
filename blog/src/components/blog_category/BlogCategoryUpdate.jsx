import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import BlogCategoryApi from '../../services/BlogCategoryApi';

// Function BlogCategoryCreate
function BlogCategoryUpdate({ t, i18n, props }) {

// REDIRECT
const navigate=useNavigate();

// STATE
const [categoryName,setCategoryName]=useState(null);
const [error,setError]=useState(undefined);
const [spinner,setSpinner]=useState(false);
const [multipleRequest,setMultipleRequest]=useState(false);


// PARAMS
const [paramID,setParamID]=useState(null);
const updateBlogCategoryID=useParams();


useEffect(()=>{
  setParamID(updateBlogCategoryID.id);
  localStorage.setItem("blog_category_update_id",updateBlogCategoryID.id);

  BlogCategoryApi.categoryApiFindById(updateBlogCategoryID.id).
  then((response)=>{
if(response.status === 200){
  setCategoryName(response.data.categoryName);
}
  }).catch((err)=>{
    console.error(err)
  })
},[])


// Clear
const clear=()=>{
  setCategoryName(null);
  }

// onChange
const categoryNameOnChange=(event)=>{
const {name,value}=event.target;
console.log(name+" "+value);
setCategoryName(value);
}


// Form Submit 
const onSubmitForm=(event)=>{
  event.preventDefault();
}

// Submit
const blogCategoryCreateSubmit= async (event)=>{

  const blogCategoryObject={
    categoryName
  }

  // Hataları Gösterme
  setError(null);

  // Spinner
  setSpinner(true);

  // Çoklu İstek
  setMultipleRequest(true);

  try {
    const response = await BlogCategoryApi.categoryApiUpdate(localStorage.getItem("blog_category_update_id"),blogCategoryObject);
    if(response.status==200){
      setSpinner(false);
      setMultipleRequest(false);
      //alert("Güncellendi")
      navigate("/blog/category/list")
    }
  } catch (err) {
    console.error(err,"Blog Category Eklenmedi !!!");
    setError(err.response.data.validationErrors);
    setSpinner(true);
    setMultipleRequest(false);
  }

  }

  // Spinner
  const spinnerData=()=>{
    if(spinner){
      return (
        <div class="spinner-border text-warning" role="status">
  <span class="sr-only">Loading...</span>
</div>
      )
    }else{
      return "";
    }
  }

  // Error
  const inputInvalidErrorClass= {error} ? "form-control is-invalid" : "form-control";

  // RETURN
  return (
    <>
    <div className="container mt-5">
      <h1>Blog Category Update</h1>


<form onSubmit={onSubmitForm}>

<div className="form-group">
        <label htmlFor="categoryName">Category Name</label>
        <input 
        type="text" 
        className={inputInvalidErrorClass} 
        id="categoryName" 
        name="categoryName"
        autoFocus={true} 
        placeholder="Enter Category Name" 
        required={true}
        onChange={categoryNameOnChange} 
        value={categoryName}
        />
        
        {error ? <div className="invalid-feedback">{error.categoryName}</div>:""}
      </div>

      {/* RESET */}
      <button 
      type="reset"
      onClick={clear}
      className="btn btn-danger mt-2 shadow" 
      >Temizle</button>

    <button 
    type="submit"
    onClick={blogCategoryCreateSubmit}
    className="btn btn-primary mt-2 ms-2 shadow"
    disabled={ multipleRequest}

    >
      {spinnerData()}
      Update</button>

      {/* <button className="btn btn-primary mt-2" onClick={()=>{
        console.log("Category Name: "+categoryName);
        navigate("/blog/category/list");
      }}>Create</button> */}
</form>

      </div>
    </>
  )
}

// Export
export default BlogCategoryUpdate