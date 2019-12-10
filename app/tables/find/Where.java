package tables.find;

import io.ebean.ExpressionList;

public interface Where<TABLE> {

    ExpressionList<TABLE> where();

}