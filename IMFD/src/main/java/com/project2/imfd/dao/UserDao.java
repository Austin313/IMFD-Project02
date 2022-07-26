package com.project2.imfd.dao;

import antlr.collections.List;

public interface UserDao {
 public boolean login(String username, String password);
 List getUsers();
}
