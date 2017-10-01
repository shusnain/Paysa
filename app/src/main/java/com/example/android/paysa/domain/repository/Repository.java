package com.example.android.paysa.domain.repository;

/**
 * Created by S_Husnain on 2017-09-30.
 */

import com.example.android.paysa.domain.models.SampleModel;

/**
 * A sample repository with CRUD operations on a model.
 */

public interface Repository {

    boolean insert(SampleModel model);

    boolean update(SampleModel model);

    SampleModel get(Object id);

    boolean delete(SampleModel model);
}
