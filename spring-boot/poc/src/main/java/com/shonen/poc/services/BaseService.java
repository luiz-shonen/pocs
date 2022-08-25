package com.shonen.poc.services;

import com.shonen.poc.models.Base;
import com.shonen.poc.resources.requests.BaseRequest;
import com.shonen.poc.resources.responses.BaseResponse;
import com.shonen.poc.resources.responses.Response;
import lombok.NonNull;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T extends Base, X extends BaseRequest, Y extends BaseResponse> {
    List<T> findAllEntities();

    Response findAll();

    Response findAllPageSort(@NonNull Integer page, @NonNull Integer size, String sort, Sort.Direction direction);

    Response findAllSearchPageSort(Integer page, Integer size, String sort, Sort.Direction direction, @NonNull List<Object> q);

    Response findAllSearchPageSortAtivo(Integer page, Integer size, String sort, Sort.Direction direction, List<Object> q, Boolean ativo);


    T findEntityById(@NonNull Long id);

    Response findById(@NonNull Long id);

    T saveEntity(@NonNull X baseRequest);

    Response save(@NonNull X baseRequest);

    Response update(@NonNull Long id, @NonNull X baseRequest);

    void delete(@NonNull Long id);
}
