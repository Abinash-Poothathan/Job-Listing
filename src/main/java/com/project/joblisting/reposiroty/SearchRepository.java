package com.project.joblisting.reposiroty;

import com.project.joblisting.Model.Post;

import java.util.ArrayList;
import java.util.List;


public interface SearchRepository {

    List<Post> findByText(String text);

}
