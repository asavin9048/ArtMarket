package asavin.mvp.model.dao;

import java.util.ArrayList;

/**
 * Created by 1 on 06.12.2017.
 */


public interface EntityDao<E> {

    E getEntitybyId(int id);

    ArrayList<E>getAllEnteties();
    ArrayList<E>getParametrEnteties(String sqlParametrs);
}
