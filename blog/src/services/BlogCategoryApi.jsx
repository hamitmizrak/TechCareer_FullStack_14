
// http://localhost:4444/blog/category/api/v1/delete/all
// proxy:    http://localhost:4444/
// persist:  blog/category/api/v1
// URL:      /delete/all

import axios from "axios";

// PERSIST
const BLOG_CATEGORY_API_PERSIST_URL="/blog/category/api/v1"

// BlogCategoryApi
class BlogCategoryApi{

    // SPEED DATA
    // http://localhost:4444/blog/category/api/v1/speed/10
    //@GetMapping(value="/speed/{id}")
    categoryApiSpeedData(data) {
        return axios.get(BLOG_CATEGORY_API_PERSIST_URL+"/speed/10");
    }

    // ALL DELETE
    // http://localhost:4444/blog/category/api/v1/delete/all
    // @DeleteMapping(value="/delete/all")
    categoryApiAllDelete() {
        return axios.delete(`${BLOG_CATEGORY_API_PERSIST_URL}/delete/all`);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/blog/category/api/v1/create
    // @PostMapping("/create")
    categoryApiCreate(categoryDto) {
        return axios.post(`${BLOG_CATEGORY_API_PERSIST_URL}/create`,categoryDto)
    }

    // LIST
    // http://localhost:4444/blog/category/api/v1/list
    //@GetMapping(value="/list")
    categoryApiList() {
       return axios.get(`${BLOG_CATEGORY_API_PERSIST_URL}/list`);
    }

    // FIND
    // http://localhost:4444/blog/category/api/v1/find/1
    //@GetMapping(value="/find/{id}")
    categoryApiFindById(id) {
        return axios.get(`${BLOG_CATEGORY_API_PERSIST_URL}/find/${id}`);
    }

    // UPDATE
    // http://localhost:4444/blog/category/api/v1/update/1
    //@PutMapping(value="/update/{id}")
    categoryApiUpdate( id,categoryDto) {
        return axios.put(`${BLOG_CATEGORY_API_PERSIST_URL}/update/${id}`,categoryDto);
    }

    // DELETE BY ID
    // http://localhost:4444/blog/category/api/v1/delete/1
    // @DeleteMapping(value="/delete/{id}")
    categoryApiDeleteById(id) {
        return axios.delete(`${BLOG_CATEGORY_API_PERSIST_URL}/delete/${id}`);
    }
} //end class BlogCategoryApi

// Export Default
export default new BlogCategoryApi();