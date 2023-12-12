package com.vti.blogapp.Specification;

import com.vti.blogapp.Entity.Comment;
import com.vti.blogapp.Form.CommentFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
public class CommentSpecification
{
    public static Specification<Comment> buildSpec(CommentFilterForm form)
    {
        return (root, query, builder) ->
        {
            var predicates = new ArrayList<Predicate>();
            var postId = form.getPostId();
            if(postId != null)
            {
                var predicate = builder.equal(root.get("post").get("id"), postId);
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
