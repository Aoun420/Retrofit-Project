package com.example.retrofitapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerImplemntation {
    public static final String url="https://www.googleapis.com/blogger/v3/blogs/513132701909328597/posts/";
    public static final String key="AIzaSyD3ODwLaVGgBbMoX2s9QdXeY8XXXYKTNQo";
    public static PostService postService=null;
    public static PostService getService(){
        if (postService==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService=retrofit.create(PostService.class);
        }
        return postService;
    }
    public interface PostService{
        @GET("?key="+key)
        Call<PostList> getPostList();
//        @GET("{PostId}/?key="+key)
//        Call<Item> getPostById(String id);
    }
}
