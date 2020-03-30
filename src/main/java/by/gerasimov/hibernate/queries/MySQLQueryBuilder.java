package by.gerasimov.hibernate.queries;

public class MySQLQueryBuilder implements QueryBuilder {

    private String query;

    @Override
    public QueryBuilder setTable(String table) {
        query += " " + table + " ";
        return this;
    }

    @Override
    public QueryBuilder select() {
        query = "select * from ";
        return this;
    }

    @Override
    public QueryBuilder delete() {
        query = "delete from ";
        return this;
    }

    @Override
    public QueryBuilder where() {
        query += " where ";
        return this;
    }

    @Override
    public QueryBuilder equal(String field, String value) {
        query += field + " = '" + value + "'";
        return this;
    }

    @Override
    public QueryBuilder and() {
        query += " and ";
        return this;
    }

    @Override
    public QueryBuilder or() {
        query += " or ";
        return this;
    }

    @Override
    public QueryBuilder like(String field, String value) {
        query += " " + field + " like '" + value + "'";
        return this;
    }
    @Override
    public void clear() {
        query = "";
    }

    @Override
    public String getQuery() {
        return query;
    }
}
