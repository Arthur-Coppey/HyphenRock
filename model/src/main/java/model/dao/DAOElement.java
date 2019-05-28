package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOElement<E> {

    private final Connection connection;

    public DAOElement(final Connection connection) throws SQLException {
        this.connection = connection;
    }

    public boolean create(final E element) {
        return false;
    }

    public boolean delete(final E element) {
        return false;
    }

    public E find(final int id) {
        return null;
    }

    public E find(final String code) {
        return null;
    }

    protected Connection getConnection() {
        return this.connection;
    }

    public boolean update(final E element) {
        return false;
    }

}
