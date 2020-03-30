package by.gerasimov.hibernate.queries;

public interface QueryBuilder {
    QueryBuilder setTable(String table);
    QueryBuilder select();
    QueryBuilder delete();
    QueryBuilder where();
    QueryBuilder equal(String field, String value);
    QueryBuilder and();
    QueryBuilder or();
    QueryBuilder like(String field, String value);
    void clear();
    String getQuery();
}
