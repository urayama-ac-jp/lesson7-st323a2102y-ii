package com.classroom.assignment.service;

import com.classroom.assignment.repository.CommentDao;
import org.springframework.stereotype.Service;
import com.classroom.assignment.entity.Comment;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentDao dao;

  public CommentServiceImpl(CommentDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Comment Comment) {
    dao.insertComment(Comment);
  }

  @Override
  public List<Comment> getAll() {
    List<Comment> list = dao.getAll();
    return list;
  }

  @Override
  public List<Comment> getCommentSerchByName(String name) {
    if (name.isEmpty()) {
      List<Comment> list = dao.getAll();
      return list;
    }else{
      List<Comment> list = dao.getCommentSerchByName(name);
      return list;
    }
  }

  @Override
  public List<Comment> getCommentSerchById(String id) {
    List<Comment> list = new ArrayList<Comment>();
    try {
      list = dao.getCommentSerchById(Integer.parseInt(id));
    } catch (NumberFormatException e) {
      list = dao.getAll();
    }
    return list;
  }
}
